package ru.itis.project.services;

import ru.itis.project.forms.NewProjectForm;
import ru.itis.project.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductsService {
    List<Product> addProductToUserBasket(String cookieValue, Long productId);
    List<Product> forTable ();
    void newProject(NewProjectForm projectForm);
    Optional<Product> findOneById(Long id);
    List<Product> forProfile (Long id);
    List<Product> findListBySearch(String search);
}
