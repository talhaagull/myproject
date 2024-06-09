package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.model.Invoice;
import com.patika.kitapyurdum.repository.BookRepository;
import com.patika.kitapyurdum.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.UUID;

@Service
@Slf4j
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    public Invoice createInvoice(BigDecimal totalAmount) {
        String invoiceCode = UUID.randomUUID().toString().substring(0, 10).toUpperCase();
        Invoice invoice = new Invoice(invoiceCode, totalAmount);
        return invoiceRepository.save(invoice);
    }
}
