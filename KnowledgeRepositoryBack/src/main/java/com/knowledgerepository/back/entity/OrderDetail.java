package com.knowledgerepository.back.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order_detail")
public class OrderDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "total_payment")
    private double totalPayment;

    @Column(name = "item_count")
    private int itemCount;

    @Column(name = "shipping_address_id")
    private int shippingAddress;

    @Column(name = "billing_address_id")
    private int billingAddress;

    @Column(name = "order_date")
    private Date date;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "orderDetail", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<OrderItem> orderItem;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public int getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(int shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public int getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(int billingAddress) {
        this.billingAddress = billingAddress;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<OrderItem> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(List<OrderItem> orderItem) {
        this.orderItem = orderItem;
    }
}
