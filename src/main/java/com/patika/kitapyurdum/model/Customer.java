package com.patika.kitapyurdum.model;

import com.patika.kitapyurdum.model.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer credit;
    private String phoneNumber;

    @ElementCollection
    private Set<Address> addresses;

    private Boolean isActive;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;

    @OneToMany
    @JoinTable(
            name = "customer_order_list",
            joinColumns = @JoinColumn(name = "customer_id"),
            inverseJoinColumns = @JoinColumn(name = "order_list_id")
    )
    private List<Order> orderList;
    private BigDecimal totalPoints;
    private LocalDate birthDate;

    public Customer(String name, String surname, String email, String password, Set<Address> addresses) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.addresses = addresses;
    }
}

