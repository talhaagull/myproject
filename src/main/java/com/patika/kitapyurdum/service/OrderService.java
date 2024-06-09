package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.OrderConverter;
import com.patika.kitapyurdum.dto.request.OrderCreateRequest;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.Invoice;
import com.patika.kitapyurdum.model.Order;
import com.patika.kitapyurdum.model.Product;
import com.patika.kitapyurdum.producer.NotificationProducer;
import com.patika.kitapyurdum.repository.CustomerRepository;
import com.patika.kitapyurdum.repository.MagazineRepository;
import com.patika.kitapyurdum.repository.OrderRepository;
import com.patika.kitapyurdum.utils.OrderCodeGenerator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;
    private final InvoiceService invoiceService;
    private final ProductService productService;
    private final NotificationProducer notificationProducer;

    @Autowired
    public OrderService(OrderRepository orderRepository, CustomerRepository customerRepository, CustomerService customerService, InvoiceService invoiceService, ProductService productService, NotificationProducer notificationProducer) {
        this.orderRepository = orderRepository;
        this.customerRepository = customerRepository;
        this.customerService = customerService;
        this.invoiceService = invoiceService;
        this.productService = productService;
        this.notificationProducer = notificationProducer;
    }

    @Transactional
    public Order create(OrderCreateRequest request) {
        Optional<Customer> customerOpt = customerRepository.findByEmail(request.getEmail());

        if (customerOpt.isPresent()) {
            Customer customer = customerOpt.get();
            BigDecimal totalAmount = request.getProducts().stream()
                    .map(Product::getAmount)
                    .reduce(BigDecimal.ZERO, BigDecimal::add);

            BigDecimal pointsEarned = totalAmount.multiply(BigDecimal.valueOf(0.02));
            customer.setTotalPoints(customer.getTotalPoints().add(pointsEarned));

            customerService.changeAccountTypeByCredit(request.getEmail());

            String orderCode = OrderCodeGenerator.generateOrderCode();
            Invoice invoice = invoiceService.createInvoice(totalAmount);

            Order order = OrderConverter.toOrder(request);
            order.setOrderCode(orderCode);
            order.setInvoice(invoice);
            customer.getOrderList().add(order);

            customerRepository.save(customer);
            return orderRepository.save(order);
        } else {
            throw new IllegalArgumentException("Customer not found with email: " + request.getEmail());
        }
    }

    public List<Order> getOrderList() {
        return orderRepository.findAll();
    }

    public List<Order> listOrdersByEmail(String email) {
        Optional<Customer> customerOpt = customerRepository.findByEmail(email);

        return customerOpt.map(Customer::getOrderList).orElseGet(List::of);
    }

    public Optional<Customer> getById(Long id) {
        return Optional.of(customerRepository.getById(id));
    }

    public Optional<Customer> getByEmail(String email) {
        return customerRepository.findByEmail(email);
    }
}
