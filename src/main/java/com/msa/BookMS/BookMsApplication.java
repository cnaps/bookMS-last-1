package com.msa.BookMS;

import com.msa.BookMS.domin.model.Book;
import com.msa.BookMS.domin.model.vo.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;


@SpringBootApplication
public class BookMsApplication {

	public static void main(String[] args) {
		dominTest();
		SpringApplication.run(BookMsApplication.class, args);
	}

	private static void dominTest() {
		System.out.println("------------도메인 모델 테스트 진행------------");
		System.out.println("도서1 입고");

		Book book = Book.enterBook( "노인과바다",
				"훼밍웨이",
				"2312321",
				"주인공 노인과 바다",
				LocalDate.now(),
				Source.SUPPLY,
				Classfication.LITERATURE,
				Location.PANGYO);
		System.out.println(book);

		System.out.println("도서1 입고 --> 대여가능 처리");

		book.makeAvailable();
		System.out.println(book.getBookStatus());


		System.out.println("샘플도서 생성");

		Book sample = Book.sample();
		System.out.println(sample);
		sample.makeUnavailabe();
		System.out.println(sample.getBookStatus());

	
	}

}
