package works.wachirawitch.week1.product.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import works.wachirawitch.week1.product.entity.Product;



public interface ProductRepository extends JpaRepository<Product, Integer>{
    Optional<Product> findByName(String name);
}
