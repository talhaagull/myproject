package com.patika.kitapyurdum.model;

import jakarta.persistence.*;
import lombok.*;
import com.patika.kitapyurdum.model.enums.OrderStatus;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime createDate;
    private String orderCode;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    @ManyToMany
    @JoinTable(
            name = "order_product",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    public Order(List<Product> productList, String orderCode, Invoice invoice) {
        this.createDate = LocalDateTime.now();
        this.productList = productList;
        this.orderCode = orderCode;
        this.orderStatus = OrderStatus.INITIAL;
        this.invoice = invoice;
    }
}
