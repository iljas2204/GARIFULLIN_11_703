package ru.itis.project.repositories;

import ru.itis.project.models.Product;
import ru.itis.project.models.User;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends CrudRepository<User> {
    Optional<User> findOneByEmail(String email);
    Optional<User> findOneByCookie(String cookieValue);
    List<Product> findAllProducts();
}
