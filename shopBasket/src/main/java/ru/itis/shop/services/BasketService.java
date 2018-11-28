package ru.itis.shop.services;

import ru.itis.shop.models.Basket;
import ru.itis.shop.models.Product;
import ru.itis.shop.models.User;

import java.util.List;


public interface BasketService {
    List<Product> addProductToUserBasket(Basket basket, Long productId);
    Basket createBasket(User user);
    List<Product> getProduct(Basket basket);
    Basket getBasket(User user);

    Basket showBasket(User user);
}
