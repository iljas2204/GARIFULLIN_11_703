package ru.itis.project.check;

import ru.itis.project.services.UsersService;
import ru.itis.project.services.UsersServiceImpl;

import javax.servlet.http.Cookie;

public class CookieChecker {
    String name = "";
    String cookie = "";
    public String checker(Cookie[] cookies, UsersService usersService){
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("auth")) {
                    cookie = cookies[i].getValue();
                    name = usersService.Login(cookie).get().getLogin();
                }
            }
        }
        return name;
    }
}
