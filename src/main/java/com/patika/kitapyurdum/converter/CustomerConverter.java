package com.patika.kitapyurdum.converter;

import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.model.Customer;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CustomerConverter {

    public static Customer toCustomer(CustomerSaveRequest request) {
        return new Customer(request.getName(), request.getSurname(), request.getEmail(), request.getPassword(), request.getAddresses());
    }

}
