package works.wachirawitch.week1.product.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProductControllerAdvice {
    
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> productNotFound(ProductNotFoundException e) {
        String msg = String.format("Not found product name with keywords '%s'.", e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(msg);
    }
}
