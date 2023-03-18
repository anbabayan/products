package com.example.demo.api;

import com.example.demo.components.Product;
import com.example.demo.components.ServerUsage;
import com.example.demo.services.ProductService;
import com.example.demo.services.ServerUsageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Web resource to manage the products.
 */
@RestController
@RequestMapping(path = "api/v1/product")
@CrossOrigin
public class ProductWebResource {
    private ProductService productService;
    private ServerUsageService serverUsageService;

    @Autowired
    ProductWebResource(ProductService productService, ServerUsageService serverUsageService) {
        this.productService = productService;
        this.serverUsageService = serverUsageService;
    }

    @RequestMapping("/serverUsage")
    @ResponseBody
    public ResponseEntity<String> execute() {
        LocalDateTime date = LocalDateTime.now();
//        String serverName = request.getHeader("X-Server-Name");
//        String host = request.getHeader("Host");
//        String RealIP = request.getHeader("X-Real-IP");
//        String forwardedFor = request.getHeader("X-Forwarded-For");
//        String upstreamServer = request.getHeader("X-Upstream-Server");
        final ServerUsage serverUsage= new ServerUsage("localhost:8082", date.toString());
        serverUsageService.save(serverUsage);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Product product) {
        return productService.createProduct(product);
    }

    @PutMapping("/purchase")
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
