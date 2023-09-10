package com.msa.BookMS.application.usecase;

import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;

public interface MakeUnavailableUsecase {
    public BookOutPutDTO makeUnavailable(long bookNo);
}
