package com.patika.kitapyurdum.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MagazineSaveRequest {
    private String title;
    private String publisher;
    private int issueNumber;
    private int publicationYear;

}
