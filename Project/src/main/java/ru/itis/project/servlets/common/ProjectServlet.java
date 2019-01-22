package ru.itis.project.servlets.common;

import ru.itis.project.check.CookieChecker;
import ru.itis.project.models.Product;
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


@WebServlet("/project")
public class ProjectServlet extends HttpServlet {
    ProductsService productsService;
    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        productsService = (ProductsService) context.getAttribute("productsService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Optional<Product> product = productsService.findOneById(Long.valueOf(req.getParameter("productId")));
        req.setAttribute("product", product);
        req.getRequestDispatcher("ftl/project.ftl").forward(req, resp);
    }
}
