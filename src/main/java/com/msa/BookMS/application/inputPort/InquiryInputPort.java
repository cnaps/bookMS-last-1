package com.msa.BookMS.application.inputPort;

import com.msa.BookMS.application.OutputPort.BookOutPort;
import com.msa.BookMS.application.usecase.InquiryUsecase;
import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
public class InquiryInputPort implements InquiryUsecase {

    private final BookOutPort bookOutPort;
    @Override
    public Optional<BookOutPutDTO> getBookInfo(long bookNo) {
        return bookOutPort.loadBook(bookNo)
                .map(book -> BookOutPutDTO.mapToDTO(book));
    }
}
