package works.wachirawitch.week1.product.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.assertj.core.internal.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ImplementationDefinition.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import works.wachirawitch.week1.product.entity.Product;
import works.wachirawitch.week1.product.repository.ProductRepository;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductControllerTest {

    @Autowired
    TestRestTemplate testRestTemplate;

    @MockBean
    private ProductRepository productRepository;

    @Test
    @DisplayName("Success case, find product name that contain keyword='adidas' then return list of products")
    void testGetProductByName() {

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

        when(productRepository.findByNameContainingIgnoreCase("adidas"))
        .thenReturn(List.of(product));

        ResponseEntity<List<Product>> result = testRestTemplate
        .exchange("/api/product/adidas", 
            HttpMethod.GET, 
            null, 
            new ParameterizedTypeReference<List<Product>>() {}
        );
        if (result.getBody() != null) {
            result.getBody().forEach(_product -> {
                assertTrue(_product.getName().contains("adidas"));
            });
        }
        
    }

    @Test
    @DisplayName("Success case, get all products then return all products data")
    void testGetProducts() {

    }
}
