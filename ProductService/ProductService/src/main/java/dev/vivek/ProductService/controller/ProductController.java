package dev.vivek.ProductService.controller;

import dev.vivek.ProductService.client.FakeStoreClient;
import dev.vivek.ProductService.dto.FakeStoreProductResponseDTO;
import dev.vivek.ProductService.dto.ProductResponseDTO;
import dev.vivek.ProductService.entity.Product;
import dev.vivek.ProductService.exception.InvalidInputException;
import dev.vivek.ProductService.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService; // This is known as field injection because I am injection via field

    @GetMapping("/product")
    public ResponseEntity getAllProducts() {
        List<FakeStoreProductResponseDTO> products = productService.getAllProducts();
        // should you return the product Itself back to the UI ? No You should return a DTO. So
        // I will create a new DTO class called ProductResponseDTO.
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity getProductById(@PathVariable("id") int id) {
        if(id < 1) {
            throw new InvalidInputException("Input is not correct");
        }
        FakeStoreProductResponseDTO product = productService.getProduct(id);
        return ResponseEntity.ok(product);
    }


//    //  HOMEWORK
//    @Autowired
//    FakeStoreClient fakeStoreClient;
//
//    @GetMapping("/product/{productId}")  // Homework api
//    public ResponseEntity getProductId(@PathVariable("productId") int productId) {
//        if(productId < 1) {
//            throw new InvalidInputException("Homework : Input is invalid for Product");
//        }
//        FakeStoreProductResponseDTO product = fakeStoreClient.getProductById(productId);
//        return ResponseEntity.ok(product);
//    }

}
