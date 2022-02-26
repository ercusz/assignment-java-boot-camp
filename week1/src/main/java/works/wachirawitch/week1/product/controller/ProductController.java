package works.wachirawitch.week1.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import works.wachirawitch.week1.product.entity.Product;
import works.wachirawitch.week1.product.exception.ProductNotFoundException;
import works.wachirawitch.week1.product.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = (List<Product>) productRepository.findAll();
        return ResponseEntity.ok().body(products);
    }

    @GetMapping("product/{name}")
    public ResponseEntity<List<Product>> getProductByName(@PathVariable String name) {
        List<Product> product = productRepository.findByNameContainingIgnoreCase(name);
        if (!product.isEmpty()) {
            return ResponseEntity.ok().body(product);
        }
        throw new ProductNotFoundException(name);
    }
}
