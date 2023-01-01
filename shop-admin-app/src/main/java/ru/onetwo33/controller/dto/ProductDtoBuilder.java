package ru.onetwo33.controller.dto;

import java.math.BigDecimal;

public class ProductDtoBuilder {
    private final ProductDto product;

    public ProductDtoBuilder() {
        this.product = new ProductDto();
    }

    public ProductDtoBuilder name(String name) {
        product.setName(name);
        return this;
    }

    public ProductDtoBuilder description(String description) {
        product.setDescription(description);
        return this;
    }

    public ProductDtoBuilder category(CategoryDto category) {
        product.setCategory(category);
        return this;
    }

    public ProductDtoBuilder price(BigDecimal price) {
        product.setPrice(price);
        return this;
    }

    public ProductDto build() {
        return product;
    }
}
