package com.codeproof.controller;

import com.codeproof.common.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Liu Yuke
 * @date 2026/08/06
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public Result<String> hello() {
        return Result.success("Hello World!CodeProof is running!");
    }
}
