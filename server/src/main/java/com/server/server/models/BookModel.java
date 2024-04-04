package com.server.server.models;

import java.time.LocalDateTime;

import com.server.server.models.listener.DatePersistListener;
import com.server.server.models.listener.Iauditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@EntityListeners(value = DatePersistListener.class)
@Table(name = "Book")
public class BookModel  implements Iauditable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long idx;

  @Column(length = 255, nullable = false)
  private String name;

  @Column(updatable = false, nullable = false)
  private LocalDateTime created;

  @Column(nullable = false)
  private LocalDateTime updated;

  

  // @PrePersist //사전 작업 or @PostPersist
  // public void prePersist(){
  //   log.info("pre persist...");
  //   this.created = LocalDateTime.now();
  //   this.updated = LocalDateTime.now();
  // }

  // @PostPersist
  // public void postPersist() {
  //   log.info("post persist...");
  // }
}
