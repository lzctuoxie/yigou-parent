package cn.itsource.yigou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author lzctuoxie
 * @version v1.0
 * @description: TODO
 * @date 2019/5/11/16:08
 * @ClassName:PlatApplication
 */
@SpringBootApplication
@EnableEurekaClient
public class PlatApplication {

    public static void main(String[] args) {
        SpringApplication.run(PlatApplication.class,args);
    }

}
