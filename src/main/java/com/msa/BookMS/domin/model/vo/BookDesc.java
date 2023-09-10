package com.msa.BookMS.domin.model.vo;

import lombok.*;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class BookDesc {
    private String description;
    private String author;
    private String isbn;
    private LocalDate publicationDate;
    private Source source;

    public static BookDesc creatBookDesc(String author,
                                         String isbn,
                                         String description,
                                         LocalDate publicationDate,
                                         Source source){
        var bookDesc = new BookDesc();
        bookDesc.setAuthor(author);
        bookDesc.setIsbn(isbn);
        bookDesc.setDescription(description);
        bookDesc.setPublicationDate(publicationDate);
        bookDesc.setSource(source);
        return bookDesc;
    }
    public static BookDesc sample(){
        return BookDesc.creatBookDesc("마틴파울러",
                "123456789",
                "엔터프라이즈 아키텍처 패턴을 설명",
                LocalDate.now(),
                Source.SUPPLY);
    }
}
