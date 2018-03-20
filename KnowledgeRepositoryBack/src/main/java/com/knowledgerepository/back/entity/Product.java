package com.knowledgerepository.back.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.util.UUID;

@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "code")
    @NotBlank(message = "Product code is required")
    private String code;

    @Column(name = "name")
    @NotBlank(message = "Product name is required")
    private String name;

    @Column(name = "brand")
    @NotBlank(message = "Product brand is required")
    private String brand;

    @Column(name = "description")
    @NotBlank(message = "Product description is required")
    private String description;

    @Column(name = "price")
    @Min(value = 1, message = "Price must be atleast 1")
    private double price;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;

    @Column(name = "category_id")
    @JsonIgnore
    private int category;

    @Column(name = "supplier_id")
    @JsonIgnore
    private int supplier;

    @Column(name = "purchases", nullable = false, columnDefinition = "int default 0")
    private int purchases;

    @Column(name = "views", nullable = false, columnDefinition = "int default 0")
    private int views;

    @Transient
    private MultipartFile file;


    public Product() {

        this.code = "PRD" + UUID.randomUUID().toString().substring(26).toUpperCase();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public int getSupplier() {
        return supplier;
    }

    public void setSupplier(int supplier) {
        this.supplier = supplier;
    }

    public int getPurchases() {
        return purchases;
    }

    public void setPurchases(int purchases) {
        this.purchases = purchases;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
