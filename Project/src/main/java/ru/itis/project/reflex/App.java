package ru.itis.project.reflex;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.project.repositories.ProductsRepository;
import ru.itis.project.services.ProductsService;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class App {
    public static void main(String[] args) throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("C:\\Users\\Iljas\\Desktop\\Project\\src\\main\\resources\\application.properties"));

        DataSource dataSource = new DriverManagerDataSource(
                properties.getProperty("url"),
                properties.getProperty("username"),
                properties.getProperty("password")
        );

        WebAppContextWithAnnotationImpl context = new WebAppContextWithAnnotationImpl("ru.itis.project.repositories", "ru.itis.project.services");
        context.addDependency(DataSource.class, dataSource);
        context.init();
        context.showComponents();

        System.out.println("Via context");
        // new ProductService
        ProductsService productService = context.getComponent(ProductsService.class);
        System.out.println(productService.forTable());
        System.out.println(context.getComponent(ProductsRepository.class));

    }
}