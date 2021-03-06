package ru.itis.project.services;

import ru.itis.project.forms.SettingsUserForm;
import ru.itis.project.forms.SignInForm;
import ru.itis.project.forms.SignUpForm;
import ru.itis.project.models.Product;
import ru.itis.project.models.User;
import ru.itis.project.servlets.common.EditProfileServlet;

import java.util.List;
import java.util.Optional;

public interface UsersService {
    void signUp(SignUpForm userForm);

    void edit(SettingsUserForm form);

    String signIn(SignInForm loginForm);

    boolean isExistByCookie(String cookieValue);

    Optional<User> Login (String cookieValue);

    Optional<User> find (Long id);

    List<User> findAll ();

}
