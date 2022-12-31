package ru.onetwo33.persist;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import ru.onetwo33.persist.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    List<Product> findProductByNameLike(String name);

    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
}
