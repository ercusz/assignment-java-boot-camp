package works.wachirawitch.week1.basket.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import works.wachirawitch.week1.product_item.entity.ProductItem;
import works.wachirawitch.week1.user.entity.User;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Basket {
    @Id
    @Column(name = "user_id")
    private int id;

    @ManyToMany
    private List<ProductItem> productItems; 
    private double totalAmount;

    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
