package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.ProductConverter;
import com.patika.kitapyurdum.dto.request.ProductSaveRequest;
import com.patika.kitapyurdum.dto.response.ProductResponse;
import com.patika.kitapyurdum.repository.ProductRepository;
import  com.patika.kitapyurdum.model.Product;
import  com.patika.kitapyurdum.model.Publisher;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final PublisherService publisherService;

    @Autowired
    public ProductService(ProductRepository productRepository, PublisherService publisherService) {
        this.productRepository = productRepository;
        this.publisherService = publisherService;
    }

    public void save(ProductSaveRequest request) {
        Optional<Publisher> publisher = publisherService.getByName(request.getPublisherName());
        if (publisher.isEmpty()) {
            log.info("publisher bulamadım : " + request.getPublisherName());
            throw new RuntimeException("publisher bulamadım");
        }
        Product product = ProductConverter.toProduct(request, publisher.get());
        productRepository.save(product);
        log.info("Product Service: saved -> " + product);
    }

    public List<Product> getAll() {
        return productRepository.findAll();
    }

}
