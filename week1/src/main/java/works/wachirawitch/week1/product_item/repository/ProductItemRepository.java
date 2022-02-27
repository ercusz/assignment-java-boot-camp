package works.wachirawitch.week1.product_item.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import works.wachirawitch.week1.product_item.entity.ProductItem;

public interface ProductItemRepository extends JpaRepository<ProductItem, Integer> {
    
}
