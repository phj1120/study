package com.example.extendinjpa.product;

import com.example.extendinjpa.product.entity.Product;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow();

        return product;
    }

    public Product addProduct(Product product) {
        Product save = productRepository.save(product);

        return save;
    }


}
