package com.patika.kitapyurdum.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Book extends Product {
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
