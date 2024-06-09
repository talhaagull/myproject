package com.patika.kitapyurdum.dto.request;

import com.patika.kitapyurdum.model.Invoice;
import com.patika.kitapyurdum.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderCreateRequest {
    private String email;
    private List<Product> products;
    private String orderCode;
    private Invoice invoice;

}
