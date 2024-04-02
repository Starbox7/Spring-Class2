package com.starbox.hello.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starbox.hello.dto.GenericDTO;
import com.starbox.hello.dto.ResponseDTO;
import com.starbox.hello.services.NaverService;

import lombok.RequiredArgsConstructor;


@RequestMapping("/naver")
@RequiredArgsConstructor
@RestController
public class NaverController {
  private final NaverService naverService;

  @GetMapping("/local/search")
  public GenericDTO<ResponseDTO> localSearch(@RequestParam String query){
    return naverService.localSearch(query);
  }
}
