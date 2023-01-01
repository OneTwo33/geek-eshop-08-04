package ru.onetwo33.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ru.onetwo33.controller.dto.CategoryDto;
import ru.onetwo33.persist.model.Category;
import ru.onetwo33.persist.CategoryRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll().stream()
                .map(category -> new CategoryDto(category.getId(), category.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public Page<CategoryDto> findAll(Integer page, Integer size) {
        return categoryRepository.findAll(PageRequest.of(page, size, Sort.by("id")))
                .map(category -> new CategoryDto(category.getId(), category.getName()));
    }

    @Override
    public Optional<CategoryDto> findById(Long id) {
        return categoryRepository.findById(id)
                .map(category -> new CategoryDto(category.getId(), category.getName()));
    }

    @Override
    public void save(CategoryDto categoryDto) {
        Category category = new Category(categoryDto.getId(), categoryDto.getName());
        categoryRepository.save(category);
    }

    @Override
    public void deleteById(Long id) {
        categoryRepository.deleteById(id);
    }
}