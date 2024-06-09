package com.patika.kitapyurdum.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductSaveRequest {
    private String name;
    private BigDecimal amount;
    private String description;
    private String publisherName;
    private int stock;
}
