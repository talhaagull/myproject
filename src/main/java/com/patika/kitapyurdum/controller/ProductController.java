package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody ProductSaveRequest request){
        productService.save(request);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.getAll();
    }
}
