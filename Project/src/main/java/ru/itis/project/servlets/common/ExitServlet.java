package ru.itis.project.servlets.common;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/exit")
public class ExitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = req.getCookies();
        for (int i = 0; i < cookies.length ; i++) {
            if(cookies[i].getName().equals("auth")){
                cookie = cookies[i];
            }
        }
        cookie.setMaxAge(0);
        resp.addCookie(cookie);
        resp.sendRedirect("/home");
    }
}
