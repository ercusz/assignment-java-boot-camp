package works.wachirawitch.week1.product_item.exception;

public class ProductNotEnough extends RuntimeException{
    public ProductNotEnough(String name) {
        super(name);
    }
}
