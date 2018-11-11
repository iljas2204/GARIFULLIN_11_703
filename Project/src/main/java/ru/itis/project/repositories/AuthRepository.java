package ru.itis.project.repositories;

import ru.itis.project.models.Auth;

public interface AuthRepository extends CrudRepository<Auth> {
    Auth find(Long id);

    void update(Auth model);

    Auth findByCookieValue(String cookieValue);
}
