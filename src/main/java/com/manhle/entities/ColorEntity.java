package com.manhle.entities;

import com.manhle.enums.Color;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "color")
public class ColorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private Color colorE;

    @OneToMany(mappedBy = "color")
    private List<ProductDetailEntity> productDetails;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Color getColorE() {
        return colorE;
    }

    public void setColorE(Color colorE) {
        this.colorE = colorE;
    }

    public List<ProductDetailEntity> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(List<ProductDetailEntity> productDetails) {
        this.productDetails = productDetails;
    }

    @Override
    public String toString() {
        return "ColorEntity{" +
                "id=" + id +
                ", colorE=" + colorE +
                '}';
    }
}
