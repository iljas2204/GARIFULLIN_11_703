package ru.itis.project.servlets.common;

import ru.itis.project.forms.SignUpForm;
import ru.itis.project.services.UsersService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService)context.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("jsp/signUp.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SignUpForm form = SignUpForm.builder()
                .email(request.getParameter("email"))
                .password(request.getParameter("password"))
                .build();

        usersService.signUp(form);

        response.sendRedirect("/signIn");
    }
}
