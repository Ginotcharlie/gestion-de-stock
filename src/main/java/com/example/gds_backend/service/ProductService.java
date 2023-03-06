package com.example.gds_backend.service;

import com.example.gds_backend.model.Product;
import com.example.gds_backend.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public Iterable<Product> getAllProcduct(){
        return repository.findAll();
    }

    public Optional<Product> getProductById(int id){
        return repository.findById(id);
    }

    public Product saveProduct(Product newProduct){
        return repository.save(newProduct);
    }

    public Product updateProduct(Product product) {
        Optional<Product> checkProduct = this.getProductById(product.getId());

        if (checkProduct.isPresent()){
            Product ancientProduct = checkProduct.get();
            if (!ancientProduct.getName().equals(product.getName())){
                ancientProduct.setName(product.getName());
            }
            if (ancientProduct.getPrice() != product.getPrice()){
                ancientProduct.setPrice(product.getPrice());
            }
            if (!ancientProduct.getDescription().equals(product.getDescription())){
                ancientProduct.setDescription(product.getDescription());
            }
            return repository.save(ancientProduct);
        } else {
            return null;
        }
    }

    public void deleteEvaluationById(final int id){
        repository.deleteById(id);
    }
}
