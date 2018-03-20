package com.knowledgerepository.back.entity;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

    @Column(name = "total_payment")
    private double totalPayment;

    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_count")
    private int productCount;

    @Column(name = "price")
    private double price;





}
