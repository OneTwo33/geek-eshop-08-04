package ru.onetwo33.service;

import org.springframework.data.domain.Page;
import ru.onetwo33.controller.dto.ProductDto;

import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findAll(Integer page, Integer size);

    Optional<ProductDto> findById(Long id);

    void save(ProductDto productDto);

    void deleteById(Long id);
}
