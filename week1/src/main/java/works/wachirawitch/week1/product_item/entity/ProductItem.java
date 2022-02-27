package works.wachirawitch.week1.product_item.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import works.wachirawitch.week1.product.entity.Product;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class ProductItem {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    private int qty;
    private double amount;
}
