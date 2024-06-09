package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.OrderCreateRequest;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.Order;
import com.patika.kitapyurdum.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {

    @Autowired
    private final OrderService orderService;

    @PostMapping("/create")
    public void create(@RequestBody OrderCreateRequest request){
        orderService.create(request);
    }

    @GetMapping
    public List<Order> getAll(){
        return orderService.getOrderList();
    }

    @GetMapping("/{id}")
    public Optional<Customer> getById(@PathVariable Long id){
        return orderService.getById(id);
    }

    @GetMapping("/{email}")
    public Optional<Customer> getByEmail(@PathVariable String email){
        return orderService.getByEmail(email);
    }

}
