package com.patika.kitapyurdum.dto.request;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookSaveRequest {
    private String title;
    private Long authorId;
    private String authorName;
    private String authorSurname;
    private String authorBio;
    private String publisherName;
    private BigDecimal amount;
    private String description;
    private int stock;
    private int publicationYear;
}
