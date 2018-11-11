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
            "insert into product_user(email, hash_password) values (?, ?);";

    //language=SQL
    private static final String SQL_SELECT_ALL =
            "select * from pizza_user";

    //language=SQL
    private static final String SQL_SELECT_ALL_PRODUCTS =
            "select * from products";

    //language=SQL
    private static final String SQL_SELECT_BY_ID =
            "select * from product_user where id = ?";

    //language=SQL
    private static final String SQL_SELECT_BY_EMAIL =
            "select * from product_user where email = ?;";

    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE =
            "select * from product_user where id IN (select user_id from auth where cookie_value = ?);";

    private JdbcTemplate jdbcTemplate;

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .email(resultSet.getString("email"))
            .hashPassword(resultSet.getString("hash_password"))
            .build();
    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("product_id"))
            .userId(resultSet.getLong("id"))
            .info(resultSet.getString("info"))
            .build();

    @Override
    public Optional<User> findOne(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_ID, userRowMapper, id));
    }
    public Optional<User> findOneByEmail(String email) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_BY_EMAIL, userRowMapper, email));
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
                    ps.setString(1, model.getEmail());
                    ps.setString(2, model.getHashPassword());
                    return ps;
                }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void delete(Long id) {
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL, userRowMapper);
    }

    public List<Product> findAllProducts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productRowMapper);
    }
}
