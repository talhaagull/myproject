package com.patika.kitapyurdum.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private LocalDate createDate;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> products;
}
