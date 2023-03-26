package com.stepan.myebay.services;

import com.stepan.myebay.models.Product;
import com.stepan.myebay.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private List<Product> products = new ArrayList<>();
    private Long ID = 0l;

    {
        products.add(new Product(++ID, "PlayStation 5", "simple description", 67000, "Moscow", "Tomas"));
        products.add(new Product(++ID, "Ifone 11 ", "simple description", 86000, "Volgograd", "Anna"));
    }

    public List<Product> listProducts(String title){
        if(title!=null) return productRepository.findByTitle(title);
        // если ненашли товар по title вернем просто всё
        return productRepository.findAll();
    }

    public void saveProduct(Product product){
        log.info("Saving new {}", product);
        productRepository.save(product);
    }

    public void deleteById(Long id){
        productRepository.deleteById(id);
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id).orElse(null);
    }
}
