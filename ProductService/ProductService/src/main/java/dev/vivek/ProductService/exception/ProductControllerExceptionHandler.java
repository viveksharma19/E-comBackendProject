package dev.vivek.ProductService.exception;

import dev.vivek.ProductService.controller.ProductController;
import dev.vivek.ProductService.dto.ExceptionResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice(basePackageClasses = ProductController.class)
public class ProductControllerExceptionHandler {

//    @ExceptionHandler(ProductNotFoundException.class)
//    public ResponseEntity handleProductNotFoundException(ProductNotFoundException productNotFoundException) {
//        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
//                productNotFoundException.getMessage(),
//                404
//        );
//        // for not found the code is 404
//        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
//    }
//
//    @ExceptionHandler(NoProductPresentException.class)
//    public ResponseEntity handleProductNotFoundException(NoProductPresentException noProductPresentException) {
//        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
//                noProductPresentException.getMessage(),
//                404
//        );
//        // for not found the code is 404
//        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
//    }
//For both these methods the body is exactly the same so we can andle both
// exceptions in a single method. so we change the method name as generic for both the exception
/*
    For both these methods the body is exactly the same so we can andle both exceptions in a single
    method. So we change the method name of one of them as generic for both the exception and in
    @Exceptionhandler(we pass both the classes). Both the exception is handled by single method.
 */
    @ExceptionHandler({ProductNotFoundException.class, NoProductPresentException.class})
    public ResponseEntity handleNoProductException(ProductNotFoundException productNotFoundException) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                productNotFoundException.getMessage(),
                404
        );
        // for not found the code is 404
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(InvalidInputException.class) // exception at controller is thrown
    public ResponseEntity handleInvalidInputException(InvalidInputException invalidInputException) {
        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
                invalidInputException.getMessage(),
                400
        );
        // if it is invalid input then it is bad request the code is 400
        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
    }

//    // HOMEWORK
//    @ExceptionHandler(InvalidInputException.class) // exception at controller is thrown
//    public ResponseEntity handleProductControllerInvalidInputExceptionHomework(InvalidInputException invalidInputException) {
//        ExceptionResponseDTO exceptionResponseDTO = new ExceptionResponseDTO(
//                invalidInputException.getMessage(),
//                400
//        );
//        // if it is invalid input then it is bad request the code is 400
//        return new ResponseEntity<>(exceptionResponseDTO, HttpStatus.BAD_REQUEST);
//    }

}
