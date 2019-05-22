package com.vulpi.starterdev.controller.rest;


import com.vulpi.starterdev.vo.MessageVO;
import lombok.extern.java.Log;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Log
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public ResponseEntity<MessageVO> hello(@RequestParam(value="name", defaultValue="User") String name) {
        log.info("Call Hello");

        MessageVO result = MessageVO.builder()
            .message(String.format("Hello, %s!", name))
            .build();

        return ResponseEntity.ok(result);
    }

}
