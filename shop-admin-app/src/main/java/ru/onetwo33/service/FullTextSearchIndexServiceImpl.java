package ru.onetwo33.service;

import org.springframework.stereotype.Service;
import ru.onetwo33.controller.dto.ProductDto;

@Service
public class FullTextSearchIndexServiceImpl implements FullTextSearchIndexService {
    @Override
    public void index(ProductDto productDto) {
        // Индексация товара
    }
}
