package works.wachirawitch.week1.product.exception;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String name) {
        super(name);
    }
}
