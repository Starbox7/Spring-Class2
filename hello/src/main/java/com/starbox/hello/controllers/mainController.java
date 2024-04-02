package com.starbox.hello.controllers;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.starbox.hello.dto.CarInfoDTO;
import com.starbox.hello.dto.DetailDTO;
import com.starbox.hello.dto.UserInfoDTO;

import lombok.extern.slf4j.Slf4j;





@Slf4j //log
@RequestMapping(value = "/apis")
@RestController
public class mainController {
  @GetMapping(value = "/hello")
  public String hello() {
      return "hello";
  }

  //pathvariable test
  @GetMapping(path = "path/{name}/100/{age}")
  public String checkName(@PathVariable(name = "name") String nameID, @PathVariable int age){ //같으면 생략 가능 
    return nameID;
  }
  
  //queryparam test 
  //http://127.0.0.1:80/apis/info?id=test1&pw=test2
  @GetMapping(path = "/info")
  public String login(@RequestParam(name = "id", required = false) String idx, @RequestParam String pw) { //이 또한 이름이 같으면 명시 생략 가능
      return "user info" + idx + ":" + pw;
  }

  //queryparam test 
  //apis/info?id=1&pw=1234&name=kim&nick=777
  @GetMapping(path = "/info/all")
  public String loginAll(@RequestParam Map<String, String> params) {
    var buffer = new StringBuilder();
    params.entrySet().forEach(e -> {
      //system out
      if(e.getKey().equals("id")){
        String id = e.getValue();
      }

      buffer.append(e.getKey() + ":" + e.getValue());
    });
      return buffer.toString();
  }
  @GetMapping("/info/all/obj")
  public String loginOne(UserInfoDTO info) {
    return info.toString();
  }

  /**
   * __Post Section__
   * 
   * /user/{id}/info?nick=david
   * data body;
   * 
   * {
	"name" : "david",
	"email" : "david@gmail.com",
	"my_hobby" : {
		"name" : "football" ,
		"use" : true,
		"terms" : 29
	}
}
   */
  @PostMapping("/user/{id}/info")
  public DetailDTO postTest(
    @PathVariable(name = "id") String myId, 
    @RequestParam String nick, 
    @RequestBody DetailDTO detailDTO
    ){
      log.info("myId - {} nick - {} ", myId, nick);
      var name = detailDTO.getMyHobby().getName();
      detailDTO.setEmail(myId);
      detailDTO.setName(nick);

      return detailDTO;
  }
  
  /**
   * Put Section
   */
  @PutMapping("/user/car")
  public CarInfoDTO putTest(@RequestBody CarInfoDTO carInfoDTO ) {
      
      return carInfoDTO;
  }
}


