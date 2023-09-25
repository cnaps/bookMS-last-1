package com.msa.BookMS.application.usecase;

import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;

import java.util.Optional;

public interface InquiryUsecase {
    public Optional<BookOutPutDTO> getBookInfo(long bookNo);
}
