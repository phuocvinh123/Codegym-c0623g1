package com.cg.repository;

import com.cg.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByTitle(String title);

    List<Product> findAllByTitleOrPriceLessThan(String title, BigDecimal price);
}
