package ru.itis.project.servlets.personal;

import ru.itis.project.forms.NewProjectForm;
import ru.itis.project.services.ProductsService;

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

    @Override
    public void init(ServletConfig config) throws ServletException {
        ServletContext context = config.getServletContext();
        productsService = (ProductsService) context.getAttribute("productsService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("jsp/newProject.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewProjectForm form = NewProjectForm.builder()
                .name(req.getParameter("name"))
                .smallInfo(req.getParameter("smallInfo"))
                .fullInfo(req.getParameter("fullInfo"))
                .userId(Long.valueOf(req.getParameter("userId")))
                .build();
        productsService.newProject(form);
        resp.sendRedirect("/main");
    }
}
