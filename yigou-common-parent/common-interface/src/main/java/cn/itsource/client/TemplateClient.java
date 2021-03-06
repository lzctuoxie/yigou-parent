package cn.itsource.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@FeignClient("YIGOU-COMMON")
public interface TemplateClient {

    @PostMapping("/page")
    void createStaticPage(@RequestBody Map<String,Object> params);

}