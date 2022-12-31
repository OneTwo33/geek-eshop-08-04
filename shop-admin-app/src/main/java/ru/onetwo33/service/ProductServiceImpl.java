package ru.onetwo33.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.onetwo33.controller.dto.CategoryDto;
import ru.onetwo33.controller.dto.ProductDto;
import ru.onetwo33.persist.model.Category;
import ru.onetwo33.persist.CategoryRepository;
import ru.onetwo33.persist.model.Product;
import ru.onetwo33.persist.ProductRepository;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Page<ProductDto> findAll(Integer page, Integer size) {
        return productRepository.findAll(PageRequest.of(page, size, Sort.by("id")))
                .map(product -> new ProductDto(product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        new CategoryDto(product.getCategory().getId(), product.getCategory().getName())));
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return productRepository.findById(id)
                .map(product -> new ProductDto(product.getId(),
                        product.getName(),
                        product.getDescription(),
                        product.getPrice(),
                        new CategoryDto(product.getCategory().getId(), product.getCategory().getName())));
    }

    @Override
    public void save(ProductDto productDto) {
        Category category = categoryRepository.findById(productDto.getCategory().getId())
                .orElseThrow(() -> new RuntimeException("Category not found"));
        Product product = new Product(productDto.getId(),
                productDto.getName(),
                productDto.getDescription(),
                productDto.getPrice(),
                category
        );
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }
}
