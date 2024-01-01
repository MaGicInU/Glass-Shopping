package com.prathi.shopping.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prathi.shopping.entities.Products;

//ProductController.java
@RestController
@RequestMapping("/api/products")
public class ProductController {
 @Autowired
 private ProductRepository productRepository;

 @GetMapping
 public ResponseEntity<List<Product>> getAllProducts() {
     List<Product> products = productRepository.findAll();
     return ResponseEntity.ok(products);
 }

 @GetMapping("/api/products/{id}")
 public ResponseEntity<Product> getProductById(@PathVariable Long id) {
     Optional<Product> product = productRepository.findById(id);
     return product.map(ResponseEntity::ok)
                   .orElse(ResponseEntity.notFound().build());
 }
}
