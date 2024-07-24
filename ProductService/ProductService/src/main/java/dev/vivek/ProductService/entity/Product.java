package dev.vivek.ProductService.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private int id;
    private String title; // title is the name basically
    private double price;
    private String description;
    private String category; // see this is the category object. If I have product it should contain category object but for now I will use category name only
    private String imageURL;
    private double rating;
}
