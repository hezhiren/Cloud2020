package cn.hezhiren.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author : hezr
 * @description :
 * @date : 2020/04/30
 **/
@Configuration
public class ApplicaitonContextConfig {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

}
