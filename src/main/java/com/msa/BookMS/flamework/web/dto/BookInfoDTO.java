package com.msa.BookMS.flamework.web.dto;

import lombok.Getter;

import javax.persistence.Embedded;
import javax.persistence.Id;
import java.time.LocalDate;

@Getter
public class BookInfoDTO {

    private String title;

    private String description;

    private String author;

    private String isbn;

    private LocalDate publicationDate;
    private String source;
    private String classfication;
    private String location;

}
