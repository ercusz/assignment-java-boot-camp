package works.wachirawitch.week1.basket.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import works.wachirawitch.week1.basket.entity.Basket;
import works.wachirawitch.week1.basket.service.BasketService;
import works.wachirawitch.week1.product_item.entity.ProductItem;
import works.wachirawitch.week1.product_item.service.ProductItemService;
import works.wachirawitch.week1.user.entity.User;

@RestController
@RequestMapping("/api")
public class BasketController {

    @Autowired
    ProductItemService productItemService;
    @Autowired
    BasketService basketService;

    @PostMapping("/basket/add/{id}")
    public ResponseEntity<Basket> addProductToBasket(@PathVariable int id, @RequestParam int qty, User user) {
        ProductItem prodItem = productItemService.selectProduct(id, qty);
        Basket basket = basketService.addItemToBasket(user, prodItem);
        return ResponseEntity.ok().body(basket);
    }

}
