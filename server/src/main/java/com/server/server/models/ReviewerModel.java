package com.server.server.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
// @AllArgsConstructor
// @NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "Reviewer")
public class ReviewerModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column(length = 255, nullable = false, unique = true)
  private String email;

  @Column(length = 255, nullable = false)
  private String nick;

  @Column(updatable = false, nullable = false)
  private LocalDateTime created;
  
  @Column(nullable = false)
  private LocalDateTime updated;

  @ToString.Exclude //무한 호출 방지
  @OneToMany(mappedBy = "reviewer", cascade = CascadeType.PERSIST) //JPA가 자동으로 원치않는 브릿지 테이블을 생성하지 않게 방지
  @Builder.Default //null 방지를 위한 수동 초기화
  private List<ReviewModel> reviews = new ArrayList<>();

  public void addReview(ReviewModel reviewModel){
    reviews.add(reviewModel);
  }
}
