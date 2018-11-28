package ru.itis.shop.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.shop.forms.SignUpForm;
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


@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;
    private BasketService basketService;
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignUpForm form = SignUpForm.builder()
                .name(request.getParameter("name"))
                .password(request.getParameter("password"))
                .age(Integer.parseInt(request.getParameter("age")))
                .build();

        usersService.signUp(form);

        response.sendRedirect("/signIn");
    }
}
