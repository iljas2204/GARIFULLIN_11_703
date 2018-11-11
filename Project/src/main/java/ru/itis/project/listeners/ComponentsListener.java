package ru.itis.project.listeners;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.project.repositories.AuthRepository;
import ru.itis.project.repositories.AuthRepositoryImpl;
import ru.itis.project.repositories.UsersRepository;
import ru.itis.project.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.project.services.UsersService;
import ru.itis.project.services.UsersServiceImpl;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ComponentsListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("admin");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/postgres");
        UsersRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        UsersService usersService = new UsersServiceImpl(usersRepository, authRepository);
        sce.getServletContext().setAttribute("usersService", usersService);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}

