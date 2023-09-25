package com.msa.BookMS.flamework.japAdapter;

import com.msa.BookMS.application.OutputPort.BookOutPort;
import com.msa.BookMS.domin.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class BookAdapter implements BookOutPort {

    private final BookRepository bookRepository;
    @Override
    public Optional<Book> loadBook(long bookNo) {
        return Optional.of(bookRepository.findById(bookNo).get());
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }
}
