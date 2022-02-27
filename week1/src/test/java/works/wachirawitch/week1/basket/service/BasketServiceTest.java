package works.wachirawitch.week1.basket.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import works.wachirawitch.week1.address.entity.Address;
import works.wachirawitch.week1.basket.entity.Basket;
import works.wachirawitch.week1.product.entity.Product;
import works.wachirawitch.week1.product.repository.ProductRepository;
import works.wachirawitch.week1.product_item.entity.ProductItem;
import works.wachirawitch.week1.product_item.service.ProductItemService;
import works.wachirawitch.week1.user.entity.User;

@ExtendWith(MockitoExtension.class)
public class BasketServiceTest {

    @Mock
    ProductRepository productRepository;

    @Test
    void testAddItemToBasket() {
        // Arrange
        Product product = new Product();
        product.setId(1);
		product.setName("adidas ORIGINALS NMD R1 Shoes");
		product.setPrice(4999.99);
		product.setQty(1000);
		product.setSize(
			new ArrayList<String>(
				Arrays.asList("Black 6 UK",
				"Black 8 UK",
				"Black 10 UK",
				"Black 11 UK",
				"Black 12 UK",
				"Black 13 UK")
			)
		);
		product.setDesc("cool sneaker");
		product.setBrand("adidas");

        Product product2 = new Product();
        product2.setId(2);
		product2.setName("adidas Ultraboost Shoes");
		product2.setPrice(6999.99);
		product2.setQty(100);
		product2.setSize(new ArrayList<String>(Arrays.asList("Black 10 UK", "Black 11 UK")));
		product2.setDesc("100% genuine");
		product2.setBrand("adidas");

        User user = new User();
        user.setEmail("hello@world.xyz");
        user.setTel("+66812345679");
        
        Address address = new Address();
        address.setAddressData("123/4 ABC DEFG");
        address.setProvince("Krung Thep Maha Nakhon");
        address.setState("Anywhere");
        address.setZipCode("12345");
        Basket basket = new Basket();
        basket.setUser(user);
        address.setUser(user);
        user.setAddress(address);
        user.setBasket(basket);

        when(productRepository.findById(0)).thenReturn(Optional.of(product));
        when(productRepository.findById(1)).thenReturn(Optional.of(product2));
        
        // Act
        ProductItemService productItemService = new ProductItemService();
        productItemService.setProductRepository(productRepository);
        ProductItem prodItem = productItemService.selectProduct(0, 20);
        ProductItem prodItem2 = productItemService.selectProduct(1, 60);

        BasketService basketService = new BasketService();
        Basket result = basketService.addItemToBasket(user, prodItem);
        result = basketService.addItemToBasket(user, prodItem2);

        // Assert
        assertEquals(2, result.getProductItems().size());
        assertEquals(product, result.getProductItems().get(0).getProduct());
        assertEquals(product2, result.getProductItems().get(1).getProduct());
    }
}
