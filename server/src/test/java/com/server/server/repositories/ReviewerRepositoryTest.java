package com.server.server.repositories;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.server.server.models.BookModel;
import com.server.server.models.ReviewModel;
import com.server.server.models.ReviewerModel;

// @ExtendWith(SpringExtension.class)
@SpringBootTest
public class ReviewerRepositoryTest {
  @Autowired
  BookRepository bookRepository;
  @Autowired
  ReviewerRepository reviewerRepository;
  @Autowired
  ReviewRepository reviewRepository;
  
  @Test
  public void reviewTest() {
    ReviewerModel reviewer = ReviewerModel.builder()
      .email("david3@gmail.com")
      .nick("david")
      .created(LocalDateTime.now())
      .updated(LocalDateTime.now())
      .build();

      ReviewerModel reviewerModel = reviewerRepository.save(reviewer);
    // ReviewerModel reviewerModel = reviewerRepository.findById(1L);

    BookModel bookModel = BookModel.builder().name("kavin")
      .created(LocalDateTime.now())
      .updated(LocalDateTime.now())
      .build();
    bookRepository.save(bookModel);

    ReviewModel review = ReviewModel.builder()
      .reviewer(reviewerModel)
      .review("Good Book!")
      .book(bookModel)
      .created(LocalDateTime.now())
      .updated(LocalDateTime.now())
      .build();
      reviewRepository.save(review);
  }
  @Transactional
  @Test
  public void reviewerTest(){
    reviewRepository.findById(1L).ifPresent(reviewModel -> {
      System.out.println(reviewModel.getReview());
    });
  }
}
