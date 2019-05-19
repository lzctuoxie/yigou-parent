package cn.itsource.yigou.controller;

import cn.itsource.yigou.util.RedisUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lzctuoxie
 * @version v1.0
 * @description: TODO
 * @date 2019/5/17
 * @ClassName:
 */
@RestController
public class RedisController {


    /**
     * 添加数据到redis中
     * @param key
     * @param value
     */
    @PostMapping("/redis")
    public void set(String key,String value){
        RedisUtils.INSTANCE.set(key,value);
    }


    /**
     * 根据key获取value
     * @param key
     * @return
     */
    @GetMapping("/redis")
    public void get(String key){
        RedisUtils.INSTANCE.get(key);
    }

}
