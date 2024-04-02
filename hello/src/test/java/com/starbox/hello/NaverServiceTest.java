package com.starbox.hello;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.starbox.hello.services.NaverService;

@SpringBootTest
public class NaverServiceTest {

    @Autowired
    private NaverService naverService;

    @Test
    void testURI() {
      var result = naverService.localSearch("스타벅스");
      System.out.println(result);
    }
}