package ru.itis.project.listeners;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.project.repositories.*;
import ru.itis.project.services.ProductsService;
import ru.itis.project.services.ProductsServiceImpl;
import ru.itis.project.services.UsersService;
import ru.itis.project.services.UsersServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ComponentsListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("ru.itis/context.xml");
        UsersService usersService = context.getBean(UsersService.class);
        ProductsService productsService = context.getBean(ProductsService.class);
        sce.getServletContext().setAttribute("usersService", usersService);
        sce.getServletContext().setAttribute("productsService", productsService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

