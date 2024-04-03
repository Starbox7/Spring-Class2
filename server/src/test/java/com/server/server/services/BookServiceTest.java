package com.server.server.services;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.server.server.models.BookModel;
import com.server.server.repositories.BookRepository;

@SpringBootTest
public class BookServiceTest {

  @Autowired
  BookService bookService;
  @Autowired
  BookRepository bookRepository;

  @Test
  public void saveTest(){
    BookModel bookModel = BookModel.builder().name("kavin")
      .created(LocalDateTime.now())
      .updated(LocalDateTime.now())
      .build();
    bookRepository.save(bookModel);

    System.out.println(bookModel);
  }

  @Test
  public void getById() {
    System.out.println(bookService.findById(1L));
  }
}
