package com.msa.BookMS.application.inputPort;

import com.msa.BookMS.application.OutputPort.BookOutPort;
import com.msa.BookMS.application.usecase.MakeAvailableUsecase;
import com.msa.BookMS.domin.model.Book;
import com.msa.BookMS.domin.model.vo.BookStatus;
import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class MakeAvailabeInputPort implements MakeAvailableUsecase {
    private final BookOutPort bookOutPort;

    public BookOutPutDTO available(long bookNo){
        Book loadBook = bookOutPort.loadBook(bookNo);

        Book makeAvailableBook = loadBook.makeAvailable();
        Book saved = bookOutPort.save(makeAvailableBook);
        return BookOutPutDTO.mapToDTO(saved);
    }
}
