package dev.vivek.ProductService.controller;

import dev.vivek.ProductService.client.FakeStoreClient;
import dev.vivek.ProductService.dto.FakeStoreCartResponseDTO;
import dev.vivek.ProductService.dto.FakeStoreProductResponseDTO;
import dev.vivek.ProductService.exception.CartNotFoundException;
import dev.vivek.ProductService.exception.InvalidInputException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CartController {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    @GetMapping("/cart/{userId}")    // we are not creating any service class for this
    public ResponseEntity getCartForUser(@PathVariable("userId") int userId) {
        List<FakeStoreCartResponseDTO> cartResponse =
                fakeStoreClient.getCartByUserId(userId);
        if(cartResponse == null) {
            throw new CartNotFoundException("Cart not found for userId " + userId);
        }
        return ResponseEntity.ok(cartResponse);
    }

//    // HOMEWORK
//
//    @GetMapping("/cart/{userId}")    // we are not creating any service class for this
//    public ResponseEntity getCartForUser(@PathVariable("userId") int userId) {
//        if(userId < 1) {
//            throw new InvalidInputException("Homework : Input is invalid for Cart");
//        }
//        List<FakeStoreCartResponseDTO> cartResponse =
//                fakeStoreClient.getCartByUserId(userId);
//        if(cartResponse == null) {
//            throw new CartNotFoundException("Cart not found for userId " + userId);
//        }
//        return ResponseEntity.ok(cartResponse);
//    }

}
