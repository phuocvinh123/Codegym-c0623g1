package com.cg.service.product;

import com.cg.model.Product;
import com.cg.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {

    @Autowired
    private IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public List<Product> search(String name) {
        return productRepository.findAllByTitle(name);
    }

    @Override
    public List<Product> findAllByTitleOrPriceLessThan(String title, BigDecimal price) {
        return productRepository.findAllByTitleOrPriceLessThan(title, price);
    }
}
