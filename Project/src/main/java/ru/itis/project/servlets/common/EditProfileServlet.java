package ru.itis.project.servlets.common;

import ru.itis.project.forms.SettingsUserForm;
import ru.itis.project.forms.SignUpForm;
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

@WebServlet("/edit")
public class EditProfileServlet extends HttpServlet {

    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        usersService = (UsersService)context.getAttribute("usersService");
    }

    @Override

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/edit.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        String cookie = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {

                if (cookies[i].getName().equals("auth")) {
                    cookie = cookies[i].getValue();
                }
            }
        }
        SettingsUserForm form = SettingsUserForm.builder()
                .id(usersService.Login(cookie).get().getId())
                .login(request.getParameter("login"))
                .email(request.getParameter("email"))
                .firstName(request.getParameter("firstName"))
                .lastName(request.getParameter("lastName"))
                .git("git")
                .build();

        usersService.edit(form);

        response.sendRedirect("/profile");
    }
}
