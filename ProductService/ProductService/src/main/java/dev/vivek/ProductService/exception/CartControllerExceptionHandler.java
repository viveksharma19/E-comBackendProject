package dev.vivek.ProductService.exception;

import dev.vivek.ProductService.controller.CartController;
import dev.vivek.ProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = CartController.class)
public class CartControllerExceptionHandler {
    @ExceptionHandler(CartNotFoundException.class) // exception at controller is thrown
    public ResponseEntity handleCartNotFoundException(CartNotFoundException cartNotFoundException) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                cartNotFoundException.getMessage(),
                404
        );
        // if it is invalid input then it is bad request the code is 400
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }

//    // HOMEWORK
//    @ExceptionHandler(InvalidInputException.class) // exception at controller is thrown
//    public ResponseEntity handleCartControllerInvalidInputExceptionHomework(InvalidInputException invalidInputException) {
//        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
//                invalidInputException.getMessage(),
//                400
//        );
//        // if it is invalid input then it is bad request the code is 400
//        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
//    }
}
