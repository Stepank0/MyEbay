package com.stepan.myebay.controller;

import com.stepan.myebay.models.Product;
import com.stepan.myebay.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private final ProductService productService;

    @GetMapping("/")
    public String products(@RequestParam(name = "title", required = false) String title, Model model){
        model.addAttribute("products", productService.listProducts(title));
        return "products";
    }

    @GetMapping("/product/{id}")
    public String productInfo(@PathVariable Long id, Model model){
        model.addAttribute("product", productService.getProductById(id));
        return "product_info";
    }

    @PostMapping("/product/create")
    public String create(Product product){
        productService.saveProduct(product);
        return "redirect:/";
    }

    @PostMapping("/product/delete/{id}")
    public String deleteById(@PathVariable Long id){
        productService.deleteById(id);
        return "redirect:/";
    }

}
