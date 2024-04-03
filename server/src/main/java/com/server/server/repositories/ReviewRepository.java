package com.server.server.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.server.server.models.ReviewModel;

public interface ReviewRepository extends JpaRepository<ReviewModel, Long>{}