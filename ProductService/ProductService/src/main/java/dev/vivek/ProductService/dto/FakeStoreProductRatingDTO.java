package dev.vivek.ProductService.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductRatingDTO {
    private double rate;
    private int count;
}

/*
    {
        "rate": 3.9,
        "count": 120
    }
 */