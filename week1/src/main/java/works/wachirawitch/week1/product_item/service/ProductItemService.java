package works.wachirawitch.week1.product_item.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import works.wachirawitch.week1.product.entity.Product;
import works.wachirawitch.week1.product.exception.ProductNotFoundException;
import works.wachirawitch.week1.product.repository.ProductRepository;
import works.wachirawitch.week1.product_item.entity.ProductItem;

@Service
public class ProductItemService {

    @Autowired
    private ProductRepository productRepository;

    public ProductItem selectProduct(int prodId, int qty) {
        Optional<Product> product = productRepository.findById(prodId);
        if (product.isPresent()) {
            ProductItem productItem = new ProductItem();
            productItem.setProduct(product.get());
            productItem.setQty(qty);
            productItem.setAmount(product.get().getPrice() * qty);
            return productItem;
        }
        throw new ProductNotFoundException(prodId+"");
    }

    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    
}
