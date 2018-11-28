package ru.itis.shop.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.shop.models.Basket;
import ru.itis.shop.models.Product;
import ru.itis.shop.models.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class BasketRepositoryImpl implements BasketRepository {

    private JdbcTemplate jdbcTemplate;

    //language=SQL
    private static final String SQL_INSERT_INTO_BASKET_PRODUCT =
            "insert into basket_product(basket_id ,product_id) values(?,?)";

    //language=SQL
    private static final String SQL_SELECT_ID =
            "SELECT id,title,price FROM product RIGHT JOIN basket_product bp on product.id = bp.product_id AND basket_id = ?;";

    //language=SQL
    private static final String SELECT_BASKET_BY_USER =
            "select *from basket where user_id = ?";

    //language=SQL
    private static final String INSERT_BASKET =
            "insert into basket (user_id) values (?)";

    //language=SQL
    private static final String SQL_SELECT_BASKET_PRODUCT =
            "select * from basket_product where id = ?";
    //language=SQL
    private static final String SQL_DELETE_BASKET =
            "DELETE FROM basket_product USING basket WHERE basket_id = ?";

    public BasketRepositoryImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    //преобразование данных в лист
    private RowMapper<Product> productRowMapper=((resultSet, i) ->Product.builder()
            .id(resultSet.getLong("id"))
            .title(resultSet.getString("title"))
            .price(resultSet.getInt("price"))
            .build());


    @Override
    public List<Basket> findAll() {
        ArrayList<Basket> basketProducts = new ArrayList<>();
        return basketProducts;
    }

    @Override
    public Basket find(Long id) {
        return null;
    }

    @Override
    public void save(Basket model) {

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.query(SQL_DELETE_BASKET,basketRowMapper,id);
    }

    @Override
    public void update(Basket model) {

    }

    @Override
    public void addProduct(Long product, Long basket) {
        jdbcTemplate.update(SQL_INSERT_INTO_BASKET_PRODUCT,basket,product);
    }





    @Override
    public List<Product> getProducts(Basket basket) {
        return jdbcTemplate.query(SQL_SELECT_ID, productRowMapper, basket.getId());
    }

    //возвращает объекты,удовлетворяющие
    //basket_product
    /*@Override
    public Basket findByCookieValue(String cookieValue) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_COOKIE_VALUE, basketRowMapper, cookieValue);
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }
*/

    private RowMapper<Basket> basketRowMapper = (resultSet, i) -> Basket.builder()
            .id(resultSet.getLong("id"))
            .build();

    //создание корзины для юзера
    @Override
    public Basket createCookieBasket(User user) {
        System.out.println(user.getId());
        jdbcTemplate.update(INSERT_BASKET, user.getId());
        return getBasket(user);
    }
    //получаем корзину
    @Override
    public Basket getBasket(User user) {
        return jdbcTemplate.queryForObject(SELECT_BASKET_BY_USER, basketRowMapper, user.getId());
    }

    @Override
    public Basket showBasket(User user) {
        return jdbcTemplate.queryForObject(SQL_SELECT_BASKET_PRODUCT, basketRowMapper, user.getId());
    }


}
