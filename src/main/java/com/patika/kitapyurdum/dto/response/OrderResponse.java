package com.patika.kitapyurdum.dto.response;

import com.patika.kitapyurdum.model.Invoice;
import com.patika.kitapyurdum.model.Product;
import lombok.*;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor

@Getter
@Setter
@ToString
@Builder
public class OrderResponse {
    private String email;
    private List<Product> products;
    private String orderCode;
    private Invoice invoice;
}
