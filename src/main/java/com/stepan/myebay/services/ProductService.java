package com.stepan.myebay.services;

import com.stepan.myebay.models.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();
    private Long ID = 0l;

    {
        products.add(new Product(++ID, "PlayStation 5", "simple description", 67000, "Moscow", "Tomas"));
        products.add(new Product(++ID, "Ifone 11 ", "simple description", 86000, "Volgograd", "Anna"));
    }

    public List<Product> list(){return products;}

    public void saveProduct(Product product){
        product.setId(++ID);
        products.add(product);
    }

    public void deleteById(Long id){
        products.removeIf(product -> product.getId().equals(id));
    }

    public Product getProductById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) return  product;
        }
        return null;
    }
}
