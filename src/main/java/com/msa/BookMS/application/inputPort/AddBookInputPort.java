package com.msa.BookMS.application.inputPort;

import com.msa.BookMS.application.OutputPort.BookOutPort;
import com.msa.BookMS.application.usecase.AddBookUsecase;
import com.msa.BookMS.domin.model.Book;
import com.msa.BookMS.flamework.web.dto.BookInfoDTO;
import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;
import com.msa.BookMS.domin.model.vo.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class AddBookInputPort implements AddBookUsecase {

    private final BookOutPort bookOutPort;
    @Override
    public BookOutPutDTO addBook(BookInfoDTO bookInfoDTO) {

        Book addBook = Book.enterBook(
                        bookInfoDTO.getTitle(),
                        bookInfoDTO.getAuthor(),
                        bookInfoDTO.getIsbn(),
                        bookInfoDTO.getDescription(),
                        bookInfoDTO.getPublicationDate(),
                        Source.valueOf(bookInfoDTO.getSource()),
                        Classfication.valueOf(bookInfoDTO.getClassfication()),
                        Location.valueOf(bookInfoDTO.getLocation())
                        );

        Book saved = bookOutPort.save(addBook);

        return BookOutPutDTO.mapToDTO(saved);
    }
}
