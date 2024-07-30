package dev.vivek.ProductService.service;

import dev.vivek.ProductService.client.FakeStoreClient;
import dev.vivek.ProductService.dto.FakeStoreProductResponseDTO;
import dev.vivek.ProductService.entity.Product;
import dev.vivek.ProductService.exception.NoProductPresentException;
import dev.vivek.ProductService.exception.ProductNotFoundException;
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
        if(fakeStoreProducts == null) {
            throw new NoProductPresentException("No  products are found");
        }
        return fakeStoreProducts;
    }

    @Override
    public FakeStoreProductResponseDTO getProduct(int productId) throws ProductNotFoundException {
        FakeStoreProductResponseDTO fakeStoreProductResponseDTO = fakeStoreClient.getProductById(productId);
        if(fakeStoreProductResponseDTO == null) {
            // you should not throw generic exception rather you should throw custom exception
            throw new ProductNotFoundException("Product not found with id : " + productId);
        }
        return fakeStoreProductResponseDTO;
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
