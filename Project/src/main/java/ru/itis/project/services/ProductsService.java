package ru.itis.project.services;

import ru.itis.project.models.Product;

import java.util.List;

public interface ProductsService {
    List<Product> addProductToUserBasket(String cookieValue, Long productId);

}
