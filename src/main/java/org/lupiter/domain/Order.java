package org.lupiter.domain;


import javax.enterprise.inject.Model;
import java.io.Serializable;
import java.math.BigDecimal;

@Model
public class Order  {

     private int id;
     private Product product;
     private BigDecimal quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }
}

