package ru.sergeysemenov.spring_test.enteties;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity()
@Table(name="products")
@Getter
@Setter
public class Product {
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_title")
    private String name;

    @Column(name = "product_price")
    private double price;

    @Column(name = "product_description")
    private String description;

    @ManyToMany
    @JoinTable(
            name="products_categories",
            joinColumns=@JoinColumn(name="product_id"),
            inverseJoinColumns=@JoinColumn(name="category_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH})
    private List<Category> categories;

}
