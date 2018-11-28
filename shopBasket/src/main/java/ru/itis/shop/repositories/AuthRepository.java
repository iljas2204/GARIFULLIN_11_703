package ru.itis.shop.repositories;

import ru.itis.shop.models.Auth;


public interface AuthRepository extends CrudRepository<Auth> {
    Auth findByCookieValue(String cookieValue);
}
