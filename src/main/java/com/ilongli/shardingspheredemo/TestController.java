package com.ilongli.shardingspheredemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ilongli
 * @date 2023/1/31 11:56
 */
@RestController
public class TestController {

    @GetMapping("")
    public String index() {
        return "ok";
    }



}
