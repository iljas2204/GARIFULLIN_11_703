package ru.itis.project.servlets.common;

import ru.itis.project.models.Product;
import ru.itis.project.models.User;
import ru.itis.project.services.ProductsService;
import ru.itis.project.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {
    UsersService usersService;
    ProductsService productsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cookie = null;
        if(req.getParameter("userId") == null){
            Cookie[] cookies = req.getCookies();
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    if (cookies[i].getName().equals("auth")) {
                        cookie = cookies[i].getValue();
                    }
                }
            }
            Optional<User> user = usersService.Login(cookie);
            List<Product> products = productsService.forProfile(user.get().getId());
            req.setAttribute("products", products);
            req.setAttribute("user", user);
        }
        else {
            Optional<User> user = usersService.find(Long.valueOf(req.getParameter("userId")));
            List<Product> products = productsService.forProfile(user.get().getId());
            req.setAttribute("products", products);
            req.setAttribute("user", user);
        }
        req.setAttribute("cookie", cookie);
        req.getRequestDispatcher("ftl/profile.ftl").forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
        productsService = (ProductsService) context.getAttribute("productsService");
    }
}
