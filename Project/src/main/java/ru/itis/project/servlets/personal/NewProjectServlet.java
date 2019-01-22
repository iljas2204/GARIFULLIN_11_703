package ru.itis.project.servlets.personal;

import ru.itis.project.forms.NewProjectForm;
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

@WebServlet("/new")
public class NewProjectServlet extends HttpServlet {
    private ProductsService productsService;
    private UsersService usersService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        productsService = (ProductsService) context.getAttribute("productsService");
        usersService = (UsersService) context.getAttribute("usersService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ftl/newProject.ftl").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        String cookie = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("auth")) {
                    cookie = cookies[i].getValue();
                }
            }
        }
        NewProjectForm form = NewProjectForm.builder()
                .name(req.getParameter("name"))
                .smallInfo(req.getParameter("smallInfo"))
                .fullInfo(req.getParameter("fullInfo"))
                .userId(usersService.Login(cookie).get().getId())
                .build();
        productsService.newProject(form);
        resp.sendRedirect("/main");
    }
}
