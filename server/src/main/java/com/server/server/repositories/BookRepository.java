package com.server.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.server.server.models.BookModel;

@Repository
public interface BookRepository extends JpaRepository<BookModel, Long> {
  // String bookNameById = "select b.name from BookModel b where b.idx = :bookId";
  // @Query(value = bookNameById)
  // String getNameById(@Param("bookId") String name);
  //
} 

