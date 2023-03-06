package com.example.gds_backend.controller;

import com.example.gds_backend.model.Product;
import com.example.gds_backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/all_product")
    public Iterable<Product> getAllProcduct(){
        return service.getAllProcduct();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable("id") int id){
        return service.getProductById(id);
    }

    @PostMapping("/save")
    public Product saveEvaluation(@RequestBody Product newProduct){
        return service.saveProduct(newProduct);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product){
        return service.updateProduct(product);
    }

    @DeleteMapping("/{id}")
    public void deleteEvaluationById(@PathVariable("id") int id){
        service.deleteEvaluationById(id);
    }
}
