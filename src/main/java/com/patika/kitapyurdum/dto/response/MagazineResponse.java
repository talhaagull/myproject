package com.patika.kitapyurdum.dto.response;

import lombok.*;
import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class MagazineResponse {
    private String title;
    private String publisher;
    private int issueNumber;
    private int publicationYear;
}