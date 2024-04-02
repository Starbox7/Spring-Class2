package com.starbox.hello.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NaverService {
  @Value("${naver.uri.search.local}")
  private String searchUri;
  @Value("${naver.id}")
  private String clientId;
  @Value("${naver.secret}")
  private String secretId;

  private final RestTemplate restTemplate;
}
