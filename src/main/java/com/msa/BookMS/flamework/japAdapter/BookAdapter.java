package com.msa.BookMS.flamework.japAdapter;

import com.msa.BookMS.application.OutputPort.BookOutPort;
import com.msa.BookMS.domin.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BookAdapter implements BookOutPort {

    private final BookRepository bookRepository;
    @Override
    public Book loadBook(long bookNo) {
        return bookRepository.findById(bookNo).get();
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
