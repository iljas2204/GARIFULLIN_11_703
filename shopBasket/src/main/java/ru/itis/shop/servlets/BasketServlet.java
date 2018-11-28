package ru.itis.shop.servlets;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.shop.repositories.*;
import ru.itis.shop.services.BasketService;
import ru.itis.shop.services.BasketServiceImpl;
import ru.itis.shop.services.UsersService;
import ru.itis.shop.services.UsersServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/shop")
public class BasketServlet extends HttpServlet {

    private BasketService basketService;
    private UsersService usersService;
    private BasketRepository basketRepository;

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
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/shop.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       /* BasketForm basketForm=BasketForm.builder()
                .user_id( req.getIntHeader("user_id"))
                .title(req.getParameter("title"))
                .build();
*/

    }
}