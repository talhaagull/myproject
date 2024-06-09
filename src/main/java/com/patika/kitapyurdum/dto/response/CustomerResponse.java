package com.patika.kitapyurdum.dto.response;

import com.patika.kitapyurdum.model.Address;
import lombok.*;

import java.util.Set;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor

@Getter
@Setter
@ToString
@Builder
public class CustomerResponse {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Set<Address> addresses;
}