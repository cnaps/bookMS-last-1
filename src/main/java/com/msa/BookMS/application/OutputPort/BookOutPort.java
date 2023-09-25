package com.msa.BookMS.application.OutputPort;

import com.msa.BookMS.domin.model.Book;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookOutPort {
    public Optional<Book> loadBook(long bookNo);

    public Book save(Book book);
}
