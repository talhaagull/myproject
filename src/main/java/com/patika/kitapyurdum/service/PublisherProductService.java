package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PublisherProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getProductsByPublisherName(String publisherName) {
        return productRepository.findByPublisherName(publisherName);
    }

    public List<Product> getProductsByPublisherId(Long publisherId) {
        return productRepository.findByPublisherId(publisherId);
    }

}

