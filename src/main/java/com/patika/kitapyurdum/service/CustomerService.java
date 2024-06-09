package com.patika.kitapyurdum.service;

import com.patika.kitapyurdum.converter.CustomerConverter;
import com.patika.kitapyurdum.dto.request.CustomerSaveRequest;
import com.patika.kitapyurdum.repository.CustomerRepository;
import com.patika.kitapyurdum.model.Customer;
import com.patika.kitapyurdum.model.enums.AccountType;
import com.patika.kitapyurdum.utils.HashUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void save(CustomerSaveRequest request) {
        Optional<Customer> existingCustomer = customerRepository.findByEmail(request.getEmail());

        if (existingCustomer.isPresent()) {
            throw new IllegalArgumentException("Email is already used by another customer.");
        }

        String hashedPassword = HashUtil.hashPassword(request.getPassword());
        request.setPassword(hashedPassword);
        Customer customer = CustomerConverter.toCustomer(request);
        customer.setTotalPoints(BigDecimal.ZERO);
        customerRepository.save(customer);
    }

    public void updateCustomerDetails(Long customerId, CustomerSaveRequest request) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        customer.setAddresses(request.getAddresses());
        customer.setName(request.getName());
        customer.setPassword(request.getPassword());
        customer.setSurname(request.getSurname());
        customer.setEmail(request.getEmail());

        customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public List<Customer> getCustomerList(){
        return customerRepository.findAll();
    }

    public Optional<Customer> findCustomerByEmail(String email) {
        return customerRepository.findByEmail(email);
    }

    public void changeAccountType(String email, AccountType accountType){
        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);

        foundCustomer.ifPresent(customer -> {
            customer.setAccountType(accountType);
            customerRepository.save(customer);
        });
    }

    public void changeAccountTypeByCredit(String email) {
        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);

        if (foundCustomer.isPresent()) {
            Customer customer = foundCustomer.get();
            BigDecimal totalPoints = customer.getTotalPoints();

            if (totalPoints != null && totalPoints.compareTo(BigDecimal.ZERO) > 0) {
                if (totalPoints.compareTo(new BigDecimal("4000")) >= 0) {
                    customer.setAccountType(AccountType.PLATINUM);
                } else if (totalPoints.compareTo(new BigDecimal("2000")) >= 0) {
                    customer.setAccountType(AccountType.GOLD);
                } else if (totalPoints.compareTo(new BigDecimal("1000")) >= 0) {
                    customer.setAccountType(AccountType.SILVER);
                } else {
                    customer.setAccountType(AccountType.STANDART);
                }
            } else {
                customer.setAccountType(AccountType.STANDART);
            }
            customerRepository.save(customer);
        }
    }

    public void changeCustomerAccountType(Long customerId, AccountType newAccountType) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new RuntimeException("Customer not found with id: " + customerId));

        customer.setAccountType(newAccountType);

        customerRepository.save(customer);
    }

    public Optional<Customer> getById(Long id) {
        return customerRepository.findById(id);
    }

    public Optional<Customer> getByEmail(String email) {
        Optional<Customer> foundCustomer = customerRepository.findByEmail(email);

        if (foundCustomer.isEmpty()){
            throw new RuntimeException("customer bulunamadı. email: " + email);
        }

        return customerRepository.findByEmail(email);
    }

    public Optional<Customer> findById(Long customerId) {
        return customerRepository.findById(customerId);
    }
}


