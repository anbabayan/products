package com.example.demo.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Service to manage the products.
 *
 */
@Service
public class ProductService {
    public List<Product> products = new ArrayList<>();

    public ProductService() {
        products.add(new Product("1P56", "Product1", 300L));
        products.add(new Product("1P76", "Product2", 700L));
        products.add(new Product("1P34", "Product3", 500L));
    }

    /**
     * Getting all the products.
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Creating a new product.
     *
     * @param product new product to be created
     */
    public ResponseEntity<String> createProduct(Product product) {
        if (product == null) {
            return ResponseEntity.badRequest().body("Product is not provided.");
        }
        products.add(product);
        return ResponseEntity.ok().body("created");
    }

    /**
     * Modifying a product.
     *
     * @param product to be modified
     */
    public ResponseEntity<String> modifyProduct(Product product) {
        if (product == null) {
            return ResponseEntity.badRequest().body("Product is not provided.");
        }

        ResponseEntity<String> response = deleteProduct(product.getProductId());
        if (response.getStatusCode() != HttpStatus.OK) {
            return ResponseEntity.internalServerError().body("Failed to modify the product.");
        } else {
            response = createProduct(product);
            if (response.getStatusCode() != HttpStatus.OK) {
                return ResponseEntity.internalServerError().body("Failed to modify the product.");
            }
        }
        return ResponseEntity.ok().body("The product is modified");
    }

    /**
     * Deleting a product.
     *
     * @param id of the product to be deleted
     */
    public ResponseEntity<String> deleteProduct(String id) {
        if (getById(id) == null) {
            return ResponseEntity.notFound().build();
        } else {
            products.removeIf(product -> product.getProductId().equals(id));
        }
        if (getById(id) == null) {
            return ResponseEntity.ok().body("The product with id " + id + " is deleted");
        } else {
            return ResponseEntity.internalServerError().body("Failed to delete the product with id: " + id);
        }
    }

    /**
     * Purchasing a product.
     *
     * @param id of the product to be purchased
     */
    public ResponseEntity<String> purchase(String id) {
        Product product = getById(id);
        if (product == null) {
            return ResponseEntity.notFound().build();
        } else {
            if (!product.isPurchased()) {
                product.setPurchased(true);
                return ResponseEntity.ok().body("The product is purchased.");
            } else {
                return ResponseEntity.badRequest().body("Product is already purchased.");
            }
        }
    }

    /**
     * Getting the product by id.
     *
     * @param id of the product
     */
    public Product getById(String id) {
        for (Product product : products) {
            if (product.getProductId().equals(id)) {
                return product;
            }
        }
        return null;
    }
}
