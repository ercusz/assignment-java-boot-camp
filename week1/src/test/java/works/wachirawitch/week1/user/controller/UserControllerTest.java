package works.wachirawitch.week1.user.controller;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import works.wachirawitch.week1.address.entity.Address;
import works.wachirawitch.week1.basket.entity.Basket;
import works.wachirawitch.week1.user.entity.User;
import works.wachirawitch.week1.user.repository.UserRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @MockBean
    private UserRepository userRepository;

    @Test
    @DisplayName("Success case, return all users data")
    void testGetUsers() {
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
        // userRepository.save(user);

        when(userRepository.findAll())
        .thenReturn(List.of(user));

        ResponseEntity<List<User>> result = testRestTemplate
        .exchange("/api/users", 
            HttpMethod.GET, 
            null, 
            new ParameterizedTypeReference<List<User>>() {}
        );

        assertNotNull(result.getBody());
    }
}
