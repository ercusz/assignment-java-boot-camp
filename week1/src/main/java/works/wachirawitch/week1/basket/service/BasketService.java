package works.wachirawitch.week1.basket.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import works.wachirawitch.week1.basket.entity.Basket;
import works.wachirawitch.week1.basket.exception.ProductAlreadyInBasket;
import works.wachirawitch.week1.product_item.entity.ProductItem;
import works.wachirawitch.week1.user.entity.User;
import works.wachirawitch.week1.user.repository.UserRepository;

@Service
public class BasketService {

    @Autowired
    private UserRepository userRepository;

    public Basket addItemToBasket(User user, ProductItem prodItem) {
        if (!Objects.isNull(user.getBasket())) {
            if (Objects.isNull(user.getBasket().getProductItems())) {
                user.getBasket().setProductItems(new ArrayList<ProductItem>());
                user.getBasket().getProductItems().add(prodItem);
            }
            else {
                if (!isExistItem(prodItem, user.getBasket())) {
                    user.getBasket().getProductItems().add(prodItem);
                }
                else {
                    user.getBasket().getProductItems().add(prodItem);
                }
            }
        } else {
            Basket basket = new Basket();
            user.getBasket().setProductItems(Collections.<ProductItem> emptyList());
            basket.getProductItems().add(prodItem);
            user.setBasket(basket);
        }
        // userRepository.save(user);
        return user.getBasket();
    }

    public Boolean isExistItem(ProductItem prodItem, Basket basket) {
        
        if (!Objects.isNull(basket.getProductItems())) {
            List<ProductItem> prods = basket.getProductItems();
            if (prods.contains(prodItem)) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
        
    }
}
