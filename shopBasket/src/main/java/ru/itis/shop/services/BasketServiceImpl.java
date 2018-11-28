package ru.itis.shop.services;

import ru.itis.shop.models.Basket;
import ru.itis.shop.models.Product;
import ru.itis.shop.models.User;
import ru.itis.shop.repositories.BasketRepository;
import ru.itis.shop.repositories.BasketRepositoryImpl;

import javax.sql.DataSource;
import java.util.List;

public class BasketServiceImpl implements BasketService {


    private BasketRepository basketRepository;
    public BasketServiceImpl(DataSource dataSource) {
        basketRepository = new BasketRepositoryImpl(dataSource);
    }

    @Override
    public List<Product> getProduct(Basket basket) {
        return null;
    }

    @Override
    public Basket createBasket(User user) {
        return basketRepository.createCookieBasket(user);
    }

    @Override
    public List<Product> addProductToUserBasket(Basket basket, Long productId) {
        basketRepository.addProduct(productId, basket.getId());
        return basketRepository.getProducts(basket);
    }

    @Override
    public Basket getBasket(User user) {
        return basketRepository.getBasket(user);
    }

    @Override
    public Basket showBasket(User user) {
        return basketRepository.showBasket(user);
    }
}
