package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.OrderCreateRequest;
import com.patika.kitapyurdum.model.Order;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class OrderConverter {

    public static Order toOrder(OrderCreateRequest request) {
        return new Order(request.getProducts(), request.getOrderCode(), request.getInvoice());
    }

}
