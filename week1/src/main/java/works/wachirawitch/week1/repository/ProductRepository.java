package works.wachirawitch.week1.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import works.wachirawitch.week1.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
    Optional<Product> findByName(String name);
}
