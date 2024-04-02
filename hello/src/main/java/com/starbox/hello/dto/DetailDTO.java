package com.starbox.hello.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;


@Data
public class DetailDTO {
    private String name;
    private String email;
    @JsonProperty(value = "my_hobby", required = true)
    private HobbyDto myHobby;

    @Data
    public static class HobbyDto {
        private String name;
        @JsonProperty(value = "use", required = true)
        private boolean isUse;
        private int terms;
    }
}
