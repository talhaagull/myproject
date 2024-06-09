package com.patika.kitapyurdum.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String invoiceCode;
    private LocalDateTime issueDate;
    private BigDecimal totalAmount;

    public Invoice(String invoiceCode, BigDecimal totalAmount) {
        this.invoiceCode = invoiceCode;
        this.issueDate = LocalDateTime.now();
        this.totalAmount = totalAmount;
    }
}
