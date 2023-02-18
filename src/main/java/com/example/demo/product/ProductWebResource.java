package com.example.demo.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web resource to manage the products.
 */
@RestController
@RequestMapping(path = "api/v1/product")
@CrossOrigin
public class ProductWebResource {
    private ProductService productService;

    @Autowired
    ProductWebResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PostMapping("/purchase")
    public ResponseEntity<String> purchase(@RequestParam String id) {
        return productService.purchase(id);
    }

    @PutMapping("/modify")
    public ResponseEntity<String> modify(@RequestBody Product product) {
        return productService.modifyProduct(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> delete(@RequestParam String id) {
        return productService.deleteProduct(id);
    }
}
