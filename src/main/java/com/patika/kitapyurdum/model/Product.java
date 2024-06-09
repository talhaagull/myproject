package com.patika.kitapyurdum.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal amount;
    private String description;
    private int stock;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return stock == product.stock &&
                Objects.equals(name, product.name) &&
                Objects.equals(amount, product.amount) &&
                Objects.equals(description, product.description) &&
                Objects.equals(publisher, product.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, amount, description, publisher, stock);
    }
}
