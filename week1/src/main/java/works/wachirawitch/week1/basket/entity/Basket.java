package works.wachirawitch.week1.basket.entity;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @ElementCollection
    private List<ProductItem> productItems; 
    private double totalAmount;

    @JsonIgnore
    @OneToOne
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;
}
