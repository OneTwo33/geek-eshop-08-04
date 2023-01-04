package ru.onetwo33.service;

import ru.onetwo33.controller.dto.ProductDto;

public interface FullTextSearchIndexService {

    void index(ProductDto productDto);
}
