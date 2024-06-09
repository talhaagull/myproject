package com.patika.kitapyurdum.dto.response;

import lombok.*;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor

@Getter
@Setter
@ToString
@Builder
public class ProductResponse {
    private String name;
    private BigDecimal amount;
    private String description;
    private String publisherName;
    private int stock;
}