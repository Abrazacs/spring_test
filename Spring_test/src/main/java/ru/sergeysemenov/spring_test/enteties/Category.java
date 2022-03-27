package ru.sergeysemenov.spring_test.enteties;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
@Getter
@Setter
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @ManyToMany
    @JoinTable(
            name="products_categories",
            joinColumns=@JoinColumn(name="category_id"),
            inverseJoinColumns=@JoinColumn(name="product_id")
    )
    @Cascade({org.hibernate.annotations.CascadeType.DELETE, org.hibernate.annotations.CascadeType.DETACH})
    private List<Product> products;

}
