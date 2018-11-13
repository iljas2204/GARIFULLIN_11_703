package ru.itis.project.repositories;

import ru.itis.project.models.Product;

import java.util.List;

public interface ProductsRepository extends CrudRepository<Product> {
    List<Product> findAllProducts();
    List<Product> findByUserId(Long id);
}
