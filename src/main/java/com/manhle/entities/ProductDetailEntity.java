package com.manhle.entities;

import com.manhle.enums.Color;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "productdetail")
public class ProductDetailEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int quantity;

    private int price;

    @OneToOne(cascade = CascadeType.ALL)
    @MapsId
    @JoinColumn(name = "product_id")
    private ProductEntity product;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "size_id")
    private SizeEntity size;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "color_id")
    private ColorEntity color;

    public SizeEntity getSize() {
        return size;
    }

    public void setSize(SizeEntity size) {
        this.size = size;
    }

    public ColorEntity getColor() {
        return color;
    }

    public void setColor(ColorEntity color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "ProductDetailEntity{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", price=" + price +
                ", size=" + size.toString() +
                ", color=" + color.toString() +
                '}';
    }
}
