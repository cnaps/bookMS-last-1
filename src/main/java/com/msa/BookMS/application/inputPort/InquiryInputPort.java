package com.msa.BookMS.application.inputPort;

import com.msa.BookMS.application.OutputPort.BookOutPort;
import com.msa.BookMS.application.usecase.InquiryUsecase;
import com.msa.BookMS.domin.model.Book;
import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class InquiryInputPort implements InquiryUsecase {

    private final BookOutPort bookOutPort;
    @Override
    public BookOutPutDTO getBookInfo(long bookNo) {
        Book loadBook = bookOutPort.loadBook(bookNo);
        return BookOutPutDTO.mapToDTO(loadBook);
    }
}
