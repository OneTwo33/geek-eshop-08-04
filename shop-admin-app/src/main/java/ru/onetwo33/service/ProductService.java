package ru.onetwo33.service;

import org.springframework.data.domain.Page;
import ru.onetwo33.controller.dto.ProductDto;
import ru.onetwo33.persist.model.Product;

import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findAll(Integer page, Integer size, String sortField);

    Optional<ProductDto> findById(Long id);

    Product save(ProductDto productDto);

    void deleteById(Long id);
}
