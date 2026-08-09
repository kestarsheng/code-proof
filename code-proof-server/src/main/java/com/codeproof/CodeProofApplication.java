package com.codeproof;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 项目启动类
 * CodeProof 源码级简历验证平台
 *
 * @author Liu Yuke
 * @date 2026/08/06
 */
@MapperScan("com.codeproof.**.mapper")
@SpringBootApplication
public class CodeProofApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeProofApplication.class, args);
    }
}
