package com.starbox.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;

//제너릭 타입 능돌적인 타입 주입, 타입 미정 타입, 외부 타입 결정
@Builder
@Data
public class GenericDTO<T> {
  private Header header;
  private T data;

  @Builder
  @Data
  public static class Header {
    @JsonProperty(value = "response_code", required = true) //default : false
    private String responseCode;
    private String msg;
  }
}
