package ru.itis.shop.services;

import ru.itis.shop.forms.SignInForm;
import ru.itis.shop.forms.SignUpForm;
import ru.itis.shop.models.User;


public interface UsersService {
    void signUp(SignUpForm form);

    String signIn(SignInForm form);

    User getUser(String cookie);

    boolean isExistByCookie(String cookieValue);
}
