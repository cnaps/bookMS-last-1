package com.msa.BookMS.application.inputPort;

import com.msa.BookMS.application.OutputPort.BookOutPort;
import com.msa.BookMS.application.usecase.MakeUnavailableUsecase;
import com.msa.BookMS.domin.model.Book;
import com.msa.BookMS.domin.model.vo.BookStatus;
import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class MakeUnavailabeInputPort implements MakeUnavailableUsecase {
    private final BookOutPort bookOutPort;

    public BookOutPutDTO makeUnavailable(long bookNo){
        Book loadBook = bookOutPort.loadBook(bookNo);
        Book makeUnavailabeBook = loadBook.makeUnavailabe();
        Book saved = bookOutPort.save(makeUnavailabeBook);
        return BookOutPutDTO.mapToDTO(saved);
    }

}
