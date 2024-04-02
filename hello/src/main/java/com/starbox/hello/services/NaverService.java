package com.starbox.hello.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.starbox.hello.dto.GenericDTO;
import com.starbox.hello.dto.RequestDTO;
import com.starbox.hello.dto.ResponseDTO;

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
  // public NaverService(RestTemplate restTemplate){} 롬복으로 대체 

  public GenericDTO<ResponseDTO> localSearch(String query){
    var reqDto = RequestDTO.builder().query(query).build(); //builder pattern
    var uri = UriComponentsBuilder.fromUriString(searchUri)
      .queryParams(reqDto.naverQueryStrMap())
      .encode()
      .build()
      .toUri();

      // log.info("uri={}", uri);
    var reqEntity = RequestEntity.get(uri)
        .header("X-Naver-Client-Id", clientId)
        .header("X-Naver-Client-Secret", secretId)
        .build();

    var resDto = restTemplate.exchange(reqEntity, ResponseDTO.class);

    var header = GenericDTO.Header.builder()
        .responseCode(resDto.getStatusCode().toString())
        .msg("ok")
        .build();

    var genericDto = GenericDTO.<ResponseDTO>builder()
        .header(header)
        .data(resDto.getBody())
        .build();

    return genericDto;
  }
}
