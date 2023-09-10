package com.msa.BookMS.flamework.japAdapter;

import com.msa.BookMS.domin.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
}
