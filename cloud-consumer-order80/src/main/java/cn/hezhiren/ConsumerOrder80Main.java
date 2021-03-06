package cn.hezhiren;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author : hezr
 * @description :
 * @date : 2020/04/30
 **/
@SpringBootApplication
@EnableEurekaClient
public class ConsumerOrder80Main {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerOrder80Main.class, args);
    }
}
