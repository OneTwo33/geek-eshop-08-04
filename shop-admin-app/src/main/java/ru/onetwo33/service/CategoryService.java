package ru.onetwo33.service;

import org.springframework.data.domain.Page;
import ru.onetwo33.controller.dto.CategoryDto;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    List<CategoryDto> findAll();

    Page<CategoryDto> findAll(Integer page, Integer size);

    Optional<CategoryDto> findById(Long id);

    void save(CategoryDto categoryDto);

    void deleteById(Long id);
}
