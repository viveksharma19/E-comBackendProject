package dev.vivek.ProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductQuantityDTO {
    private int productId;
    private int quantity;
}

/*
    {
        "productId": 1,
        "quantity": 4
      }
 */
