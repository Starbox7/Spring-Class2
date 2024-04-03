package com.server.server.models;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@Data
@Builder
@Entity
@Table(name = "Review")
public class ReviewModel {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column(length = 255, nullable = false)
  private String review;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "book")
  private BookModel book;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "reviewer")
  private ReviewerModel reviewer;

  @Column(updatable = false, nullable = false)
  private LocalDateTime created;

  @Column(nullable = false)
  private LocalDateTime updated;
}
