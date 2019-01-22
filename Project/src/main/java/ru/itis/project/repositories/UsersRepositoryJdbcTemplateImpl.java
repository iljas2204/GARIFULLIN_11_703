package ru.itis.project.repositories;

import ru.itis.project.models.Product;
import ru.itis.project.models.User;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    //language=SQL
    private static final String SQL_INSERT =
            "insert into product_user(login, hash_password) values (?, ?);";

    //language=SQL
    private static final String SQL_UPDATE_USER =
            "update product_user set (email, login, git, first_name, last_name) = (?,?,?,?,?) where id=?";
    //language=SQL
    private static final String SQL_SELECT_ALL =
            "select * from product_user left join products p on product_user.id = p.user_id";

    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "select * from product_user where id = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL =
            "select * from product_user where login = ?;";

    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE =
            "select * from product_user where id IN (select user_id from auth where cookie_value = ?);";

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .login(resultSet.getString("login"))
            .git(resultSet.getString("git"))
            .lastName(resultSet.getString("last_name"))
            .firstName(resultSet.getString("first_name"))
            .email(resultSet.getString("email"))
            .hashPassword(resultSet.getString("hash_password"))
            .build();


    @Override
    public Optional<User> findOne(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id));
    }
    @Override
    public Optional<User> findOneByLogin(String login) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, userRowMapper, login));
    }
    public Optional<User> findOneByCookie(String cookie) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE, userRowMapper, cookie));
    }

    @Override
    public void save(User model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_INSERT, new String[] {"id"});
                    ps.setString(1, model.getLogin());
                    ps.setString(2, model.getHashPassword());
                    return ps;
                }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public void update(User model, Long id) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_UPDATE_USER);
                    ps.setInt(6, Math.toIntExact(model.getId()));
                    ps.setString(1, model.getEmail());
                    ps.setString(2, model.getLogin());
                    ps.setString(3, model.getGit());
                    ps.setString(4, model.getFirstName());
                    ps.setString(5, model.getLastName());

                    return ps;
                });
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }


}
