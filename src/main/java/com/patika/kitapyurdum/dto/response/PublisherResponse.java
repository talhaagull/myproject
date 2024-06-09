package com.patika.kitapyurdum.dto.response;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
public class PublisherResponse {
    private String name;
    private LocalDate localDate;
}
