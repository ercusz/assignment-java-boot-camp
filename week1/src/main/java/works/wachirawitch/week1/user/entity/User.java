package works.wachirawitch.week1.user.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import works.wachirawitch.week1.address.entity.Address;
import works.wachirawitch.week1.basket.entity.Basket;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {
    @Id
    private int id;
    private String email;
    private String tel;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Address address;
    
    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn
    private Basket basket;
}
