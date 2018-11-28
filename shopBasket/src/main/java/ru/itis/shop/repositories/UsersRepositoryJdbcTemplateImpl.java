package ru.itis.shop.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.shop.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;



public class UsersRepositoryJdbcTemplateImpl implements UsersRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_SELECT_USER_BY_ID =
            "select * from shop_user where id = ?";

    //language=SQL
    private static final String SQL_SELECT_ALL_USERS =
            "select * from shop_user";

    //language=SQL
    private static final String SQL_INSERT =
            "insert into shop_user(name, password_hash, age) values (?, ?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_NAME =
            "select * from shop_user where name = ?";

    //language=SQL
    private static final String SQL_SELECT_COOKIE =
                    "SELECT shop_user.id, name, password_hash FROM shop_user,auth WHERE auth.user_id = shop_user.id AND cookie_value = ?;";

    private RowMapper<User> userRowMapper = (resultSet, i) -> User.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .passwordHash(resultSet.getString("password_hash"))
            .build();

    public UsersRepositoryJdbcTemplateImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<User> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_USERS, userRowMapper);
    }

    @Override
    public User find(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_USER_BY_ID,
                userRowMapper, new Object[]{id});
    }

    @Override
    public void save(User model) {
        jdbcTemplate.update(SQL_INSERT, model.getName(), model.getPasswordHash(), model.getAge());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User model) {

    }

    @Override
    public User findByName(String name) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, userRowMapper, name);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    //для получения покупочек
    @Override
    public User getUser(String cookie) {
        User user = jdbcTemplate.queryForObject(SQL_SELECT_COOKIE, userRowMapper, cookie);
        return user;
    }
}
