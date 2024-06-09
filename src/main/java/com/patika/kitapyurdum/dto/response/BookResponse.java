package com.patika.kitapyurdum.dto.response;

import lombok.*;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class BookResponse {
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
