package com.msa.BookMS.application.usecase;

import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;

public interface MakeAvailableUsecase {
    public BookOutPutDTO available(long bookNo);
}
