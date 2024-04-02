package com.starbox.hello.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//auto constructor
@AllArgsConstructor
@NoArgsConstructor 
@Data
@Builder
public class ResponseDTO {
  private String lastBuildDate;
  private int total;
  private int start;
  private int display;
  private List<Item> items = new ArrayList<>();

  @AllArgsConstructor
  @NoArgsConstructor 
  @Data
  @Builder
  public static class Item {
    private String title;
    private String link;
    private String category;
    private String description;
    private String telephone;
    private String address;
    private String roadAddress;
    private String mapx;
    private String mapy;
  }
}
