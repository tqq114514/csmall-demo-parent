package cn.tedu.csmall.business;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.tedu.csmall.commons.exception","cn.tedu.csmall.business"})
public class CsmallBusinessApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsmallBusinessApplication.class, args);
    }
}
