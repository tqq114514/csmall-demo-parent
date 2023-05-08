package cn.tedu.csmall.stock.adapter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"cn.tedu.csmall.stock.adapter","cn.tedu.csmall.commons.exception"})
public class CsmallStockWebapiApplication {
    public static void main(String[] args) {
        SpringApplication.run(CsmallStockWebapiApplication.class, args);
    }
}
