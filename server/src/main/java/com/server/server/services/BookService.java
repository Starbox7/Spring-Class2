package com.server.server.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.server.server.models.BookModel;
import com.server.server.repositories.BookRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BookService {
  private final BookRepository bookRepository;

  public BookModel save(BookModel bookModel){
    return bookRepository.save(bookModel);
  }

  public List<BookModel> findAll() {
    return bookRepository.findAll();
  }

  public BookModel findById(Long idx){
    Optional<BookModel> optional = bookRepository.findById(idx);
    if(optional.isPresent()){
      return optional.get();
    }
    return null;
  }
}
