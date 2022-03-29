package ru.sergeysemenov.spring_test.enteties;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity()
@Table(name = "cartrecords")
@Getter
@Setter
public class CartRecord {

    @Id
    @Column(name = "record_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long recordId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "product_qty")
    private int productQty;

//    @Column(name = "product_id")
//    private Long productId;


    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;



}
