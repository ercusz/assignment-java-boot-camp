package works.wachirawitch.week1.basket.exception;

public class ProductAlreadyInBasket extends RuntimeException{
    public ProductAlreadyInBasket(String name) {
        super(name);
    }
}
