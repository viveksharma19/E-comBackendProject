package dev.vivek.ProductService.service;

import dev.vivek.ProductService.client.FakeStoreClient;
import dev.vivek.ProductService.dto.FakeStoreProductResponseDTO;
import dev.vivek.ProductService.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FakeStoreProductServiceImpl implements ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;
    @Override
    public List<FakeStoreProductResponseDTO> getAllProducts() {
        List<FakeStoreProductResponseDTO> fakeStoreProducts = fakeStoreClient.getAllProducts();
        return fakeStoreProducts;
    }

    @Override
    public Product getProduct(int productId) {
        return null;
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Product updatedProduct, int productId) {
        return null;
    }

    @Override
    public boolean deleteProduct(int productId) {
        return false;
    }
}
