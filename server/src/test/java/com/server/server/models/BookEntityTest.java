package com.server.server.models;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.server.server.repositories.BookRepository;

@SpringBootTest
public class BookEntityTest {
  
  @Autowired
  BookRepository bookRepository;

  @Test
  void listenerTest(){
    bookRepository.save(
      BookModel
        .builder()
        .name("hello")
        .build()
    );
  }
}
