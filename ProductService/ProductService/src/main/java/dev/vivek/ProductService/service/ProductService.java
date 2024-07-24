package dev.vivek.ProductService.service;

import dev.vivek.ProductService.dto.FakeStoreProductResponseDTO;
import dev.vivek.ProductService.entity.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    List<FakeStoreProductResponseDTO> getAllProducts();
    Product getProduct(int productId);
    Product createProduct(Product product);
    Product updateProduct(Product updatedProduct, int productId);
    boolean deleteProduct(int productId);
}
