package ru.itis.project.servlets.common;

import ru.itis.project.check.CookieChecker;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private UsersService usersService;
    private ProductsService productsService;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = "";
        Cookie[] cookies = req.getCookies();
        name = new CookieChecker().checker(cookies, usersService);
        List<Product> products = productsService.forTable();
        if (req.getParameter("search") != null){
            products = productsService.findListBySearch(req.getParameter("search"));
        }
        req.setAttribute("name", name);
        req.setAttribute("products", products);
        req.getRequestDispatcher("ftl/main.ftl").forward(req, resp);

    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService) context.getAttribute("usersService");
        productsService = (ProductsService) context.getAttribute("productsService");
    }
}
