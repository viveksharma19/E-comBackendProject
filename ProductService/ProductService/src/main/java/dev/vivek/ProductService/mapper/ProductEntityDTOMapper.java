package dev.vivek.ProductService.mapper;

import dev.vivek.ProductService.dto.ProductResponseDTO;
import dev.vivek.ProductService.entity.Product;

public class ProductEntityDTOMapper {
    public static ProductResponseDTO convertProductEntityToProductResponseDTO (Product product) {
        ProductResponseDTO responseDTO = new ProductResponseDTO();
        responseDTO.setProductId(product.getId());
        responseDTO.setTitle(product.getTitle());
        responseDTO.setPrice(product.getPrice());
        responseDTO.setDescription(product.getDescription());
        responseDTO.setCategory(product.getCategory());
        responseDTO.setImageURL(product.getImageURL());
        responseDTO.setRating(product.getRating());
        return responseDTO;
    }
}
