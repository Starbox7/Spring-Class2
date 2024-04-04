package com.server.server.models;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.server.server.repositories.ReviewerRepository;

@SpringBootTest
public class ReviewerModelTest {
  @Autowired
  ReviewerRepository reviewerRepository;

  @Test
  void createReviewer(){
      reviewerRepository.save(ReviewerModel
        .builder()
        .email("null@null.net")
        .nick("null")
        .build());
  }
}
