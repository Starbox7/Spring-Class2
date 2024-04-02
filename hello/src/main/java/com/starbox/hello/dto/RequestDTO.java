package com.starbox.hello.dto;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import lombok.Builder;
import lombok.Data;

@Data
@Builder //객체 생성시 new 없이 생성, 스프링에서 별도의 new 객체는 지양할것
public class RequestDTO {
  private String query;
  @Builder.Default
  private int display = 1;
  @Builder.Default
  private int start = 1;
  @Builder.Default
  private String sort = "random";

  public MultiValueMap<String, String> naverQueryStrMap() {
    var map = new LinkedMultiValueMap<String, String>();
    map.add("query", query);
    map.add("display", String.valueOf(display));
    map.add("start", String.valueOf(start));
    map.add("sort", sort);

    return map;
  }
}
