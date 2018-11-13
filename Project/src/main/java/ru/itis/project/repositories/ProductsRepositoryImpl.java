package ru.itis.project.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import ru.itis.project.models.Product;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryImpl implements ProductsRepository {
    //language=SQL
    private static final String SQL_INSERT =
            "insert into products (product_name, small_info, full_info, user_id) values (?, ?, ?, ?);";
    //language=SQL
    private static final String SQL_DELETE =
            "delete from products where product_id = ?";
    //language=SQL
    private static final String SQL_SELECT_ALL_PRODUCTS =
            "select * from products";
    //language=SQL
    private static final String SQL_SELECT_PRODUCTS_BY_USER_ID =
            "select * from products where user_id = ?";
    //language=SQL
    private static final String SQL_SELECT_ONE =
            "select * from products where product_id = ?";

    private JdbcTemplate jdbcTemplate;

    public ProductsRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("product_id"))
            .userId(resultSet.getLong("user_id"))
            .name(resultSet.getString("product_name"))
            .smallInfo(resultSet.getString("small_info"))
            .fullInfo(resultSet.getString("full_info"))
            .build();

    @Override
    public List<Product> findAllProducts() {
        return jdbcTemplate.query(SQL_SELECT_ALL_PRODUCTS, productRowMapper);
    }
    @Override
    public List<Product> findByUserId(Long id) {
        return jdbcTemplate.query(SQL_SELECT_PRODUCTS_BY_USER_ID, productRowMapper, id);
    }
    @Override
    public Optional<Product> findOne(Long id) {
        return Optional.of(jdbcTemplate.queryForObject(SQL_SELECT_ONE, productRowMapper, id));
    }

    @Override
    public void save(Product model) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_INSERT, new String[]{"product_id"});
                    ps.setString(1, model.getName());
                    ps.setString(2, model.getSmallInfo());
                    ps.setString(3, model.getFullInfo());
                    ps.setLong(4, model.getUserId());
                    return ps;
                }, keyHolder);

        model.setId(keyHolder.getKey().longValue());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps =
                            connection.prepareStatement(SQL_DELETE);
                    ps.setLong(1,id);
                    return ps;
                }
        );
    }

    @Override
    public void update(Product model, Long id) {

    }

    @Override
    public List<Product> findAll() {
        return null;
    }
}
