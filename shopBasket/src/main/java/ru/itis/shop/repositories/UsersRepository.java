package ru.itis.shop.repositories;

import ru.itis.shop.models.User;

public interface UsersRepository extends CrudRepository<User> {
    User findByName(String name);
    User getUser(String cookie);
}
