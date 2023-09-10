package com.msa.BookMS.application.usecase;

import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;

public interface InquiryUsecase {
    public BookOutPutDTO getBookInfo(long bookNo);
}
