package works.wachirawitch.week1.entity;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private int id;
    private String name;
    private double price;
    private int qty;
    private ArrayList<String> size;
    private String desc; 
    private String brand;
}
