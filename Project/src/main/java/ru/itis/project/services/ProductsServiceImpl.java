package ru.itis.project.services;

import ru.itis.project.forms.NewProjectForm;
import ru.itis.project.models.Product;
import ru.itis.project.repositories.ProductsRepository;

import java.util.List;
import java.util.Optional;

public class ProductsServiceImpl implements ProductsService {
    private ProductsRepository productsRepository;

    public ProductsServiceImpl(ProductsRepository productsRepository) {
        this.productsRepository = productsRepository;
    }


    @Override
    public List<Product> addProductToUserBasket(String cookieValue, Long productId) {
        return null;
    }
    @Override
    public List<Product> forTable() {
        return productsRepository.findAllProducts();
    }

    @Override
    public void newProject(NewProjectForm projectForm) {
        Product product = Product.builder()
                .name(projectForm.getName())
                .smallInfo(projectForm.getSmallInfo())
                .fullInfo(projectForm.getFullInfo())
                .userId(projectForm.getUserId())
                .build();

        productsRepository.save(product);
    }

    @Override
    public Optional<Product> findOneById(Long id) {
        return productsRepository.findOne(id);
    }

    @Override
    public List<Product> forProfile(Long id) {
        return productsRepository.findByUserId(id);
    }
}
