package com.msa.BookMS.flamework.web;

import com.msa.BookMS.application.inputPort.AddBookInputPort;
import com.msa.BookMS.application.usecase.AddBookUsecase;
import com.msa.BookMS.application.usecase.InquiryUsecase;
import com.msa.BookMS.flamework.web.dto.BookInfoDTO;
import com.msa.BookMS.flamework.web.dto.BookOutPutDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookController {

    private final AddBookUsecase addBookUsecase;
    private final InquiryUsecase inquiryUsecase;

    @PostMapping("/book")
    public ResponseEntity<BookOutPutDTO> createBook(@RequestBody BookInfoDTO bookInfoDTO) {
        BookOutPutDTO bookOutPutDTO = addBookUsecase.addBook(bookInfoDTO);
        return new ResponseEntity<>(bookOutPutDTO,HttpStatus.CREATED);
    }

    @GetMapping("/book/{no}")
    public ResponseEntity<BookOutPutDTO> getBookByNo(@PathVariable("no") String no){
        return inquiryUsecase.getBookInfo(Long.parseLong(no))
                .map(book -> new ResponseEntity<>(book,HttpStatus.OK))
                .orElseGet(()-> new ResponseEntity<>(HttpStatus.NOT_FOUND));
         }
}
