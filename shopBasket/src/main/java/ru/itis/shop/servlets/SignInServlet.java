package ru.itis.shop.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.shop.forms.SignInForm;
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
import javax.xml.crypto.Data;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/signIn")
public class SignInServlet extends HttpServlet {

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
        usersService = new UsersServiceImpl(usersRepository, authRepository,basketService);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/signIn.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        SignInForm form = SignInForm.builder()
                .name(req.getParameter("name"))
                .password(req.getParameter("password"))
                .build();

        String cookieValue = usersService.signIn(form);
        if (cookieValue != null) {
            Cookie auth = new Cookie("auth", cookieValue);
            resp.addCookie(auth);
            resp.sendRedirect("/shop");
        } else {
            resp.sendRedirect("/signIn");
        }

    }
}
