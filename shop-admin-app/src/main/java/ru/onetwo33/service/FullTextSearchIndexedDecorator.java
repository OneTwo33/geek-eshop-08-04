package ru.onetwo33.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import ru.onetwo33.controller.dto.ProductDto;
import ru.onetwo33.persist.model.Product;

import java.util.Optional;

@Component
public class FullTextSearchIndexedDecorator implements ProductService {

    private final ProductService wrappedProductService;
    private final FullTextSearchIndexService fullTextSearchIndexService;

    @Autowired
    public FullTextSearchIndexedDecorator(@Qualifier("productServiceImpl") ProductService wrappedProductService,
                                          @Qualifier("fullTextSearchIndexServiceImpl") FullTextSearchIndexService fullTextSearchIndexService) {
        this.wrappedProductService = wrappedProductService;
        this.fullTextSearchIndexService = fullTextSearchIndexService;
    }

    @Override
    public Page<ProductDto> findAll(Integer page, Integer size) {
        return wrappedProductService.findAll(page, size);
    }

    @Override
    public Optional<ProductDto> findById(Long id) {
        return wrappedProductService.findById(id);
    }

    @Override
    public Product save(ProductDto productDto) {
        Product product = wrappedProductService.save(productDto);
        fullTextSearchIndexService.index(productDto);
        return product;
    }

    @Override
    public void deleteById(Long id) {
        wrappedProductService.deleteById(id);
    }
}
