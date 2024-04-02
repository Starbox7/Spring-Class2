package com.starbox.hello.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class CarInfoDTO {
  private String name;
  private int age;
  @JsonProperty(value = "car_list", required = true)
  private List<Car> cars = new ArrayList<>();
  
  public static class Car {
    @JsonProperty(value = "car_name", required = true)
    private String carName;
    @JsonProperty(value = "car_number", required = true)
    private String carNumber;
  }
}
