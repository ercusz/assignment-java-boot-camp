package works.wachirawitch.week1.basket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import works.wachirawitch.week1.basket.entity.Basket;

public interface BasketRepository extends JpaRepository<Basket, Integer>{
    
}
