package ru.itis.shop.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.shop.models.Basket;
import ru.itis.shop.models.Product;
import ru.itis.shop.repositories.*;
import ru.itis.shop.services.BasketService;
import ru.itis.shop.services.BasketServiceImpl;
import ru.itis.shop.services.UsersService;
import ru.itis.shop.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/products")
public class ProductsServlet extends HttpServlet {

    /*private List<Integer> ids = new ArrayList<>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ids.add(Integer.parseInt(request.getParameter("productId")));
        String json = objectMapper.writeValueAsString(ids);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }*/

    private List<Product> ids = new ArrayList<>();
    private BasketService basketService;
    private UsersService usersService;
    private ObjectMapper objectMapper = new ObjectMapper();
    private BasketRepository basketRepository;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/shop");
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        basketService = new BasketServiceImpl(dataSource);
        usersService = new UsersServiceImpl(usersRepository, authRepository, basketService);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("auth")) {
                Long id = Long.parseLong(request.getParameter("productId"));
                if(basketService == null) System.out.println("!!!");
                Basket basket = basketService.getBasket(usersService.getUser(cookie.getValue()));
                ids = basketService.addProductToUserBasket(basket, id);
            }
        }

        String json = objectMapper.writeValueAsString(ids);
        response.setContentType("application/json");
        response.getWriter().write(json);
    }
}
