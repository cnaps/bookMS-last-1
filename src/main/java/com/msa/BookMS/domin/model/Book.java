package com.msa.BookMS.domin.model;

import com.msa.BookMS.domin.model.vo.*;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long no;

    private String title;

    @Embedded
    private BookDesc desc;

    private Classfication classfication;

    private BookStatus bookStatus;

    private Location location;

    public static Book enterBook(String title,
                                 String author,
                                 String isbn,
                                 String description,
                                 LocalDate publicationDate,
                                 Source source,
                                 Classfication classfication,
                                 Location location){

        BookDesc bookDesc = BookDesc.creatBookDesc(
                author,
                isbn,
                description,
                publicationDate,
                source
                );

        var book = new Book();
        book.setTitle(title);
        book.setDesc(bookDesc);
        book.setClassfication(classfication);
        book.setLocation(location);
        book.setBookStatus(BookStatus.ENTERED);
        return book;
    }

    public Book makeAvailable()
    {
        if (this.getBookStatus().equals(BookStatus.AVAILABLE)) throw new IllegalArgumentException();
        this.setBookStatus(BookStatus.AVAILABLE);
        return this;
    }

    public Book makeUnavailabe()
    {
        if (this.getBookStatus().equals(BookStatus.UNAVAILABLE)) throw new IllegalArgumentException();
        this.setBookStatus(BookStatus.UNAVAILABLE);
        return this;
    }

    public static Book sample(){
        var book = new Book();
        book.setNo(1L);
        book.setTitle("도메인주도로 시작하는 마이크로서비스 개발");
        book.setDesc(BookDesc.sample());
        book.setClassfication(Classfication.COMPUTER);
        book.setBookStatus(BookStatus.AVAILABLE);
        return book;
    }
}
