package com.patika.kitapyurdum.controller;

import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.service.PublisherProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/publisher-products")
public class PublisherProductController {

    @Autowired
    private PublisherProductService publisherProductService;

    @GetMapping("/{publisherName}")
    public List<Product> getProductsByPublisherName(@PathVariable String publisherName) {
        return publisherProductService.getProductsByPublisherName(publisherName);
    }

    @GetMapping("/{publisherId}")
    public List<Product> getProductsByPublisherId(@PathVariable Long publisherId) {
        return publisherProductService.getProductsByPublisherId(publisherId);
    }
}
