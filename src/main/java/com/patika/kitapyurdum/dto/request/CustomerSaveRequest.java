package com.patika.kitapyurdum.dto.request;

import com.patika.kitapyurdum.model.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerSaveRequest {
    private String name;
    private String surname;
    private String email;
    private String password;
    private Set<Address> addresses;
}
