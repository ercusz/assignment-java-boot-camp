package works.wachirawitch.week1.product_item.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import works.wachirawitch.week1.basket.exception.ProductAlreadyInBasket;


@RestControllerAdvice
public class ProductItemControllerAdvice {
    @ExceptionHandler(ProductAlreadyInBasket.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.CONFLICT)
    public ResponseEntity<String> productAlreadyInBasket(ProductAlreadyInBasket e) {
        String msg = String.format("Your product name '%s' is already in your basket.", e.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(msg);
    }
}
