package com.msa.BookMS.application.usecase;

import com.msa.BookMS.flamework.web.dto.BookInfoDTO;
import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;

public interface AddBookUsecase {
    public BookOutPutDTO addBook(BookInfoDTO bookInfoDTO);
}
