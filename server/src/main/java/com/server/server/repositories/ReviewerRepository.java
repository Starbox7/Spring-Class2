package com.server.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.server.models.ReviewerModel;

public interface ReviewerRepository extends JpaRepository<ReviewerModel, Long> {} 