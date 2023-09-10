package com.msa.BookMS.application.OutputPort;

import com.msa.BookMS.domin.model.Book;
import org.springframework.stereotype.Repository;

@Repository
public interface BookOutPort {
    public Book loadBook(long bookNo);

    public Book save(Book book);
}
