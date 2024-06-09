package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.enums.AccountType;
import com.patika.kitapyurdum.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private final CustomerService customerService;

    @PostMapping("/save")
    public void save(@RequestBody CustomerSaveRequest request){
        customerService.save(request);
    }

    @PutMapping("/{customerId}")
    public void updateCustomerDetails(@PathVariable Long customerId, @RequestBody CustomerSaveRequest request) {
        customerService.updateCustomerDetails(customerId, request);
    }

    @PutMapping("/{customerId}/account-type")
    public void changeCustomerAccountType(@PathVariable Long customerId, @RequestParam AccountType newAccountType) {
        customerService.changeCustomerAccountType(customerId, newAccountType);
    }

    @GetMapping
    public List<Customer> getAll(){
        return customerService.getCustomerList();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getById(@PathVariable Long id){
        return customerService.getById(id);
    }

    @GetMapping("/{email}")
    public Optional<Customer> getByEmail(@PathVariable String email){
        return customerService.getByEmail(email);
    }


}
