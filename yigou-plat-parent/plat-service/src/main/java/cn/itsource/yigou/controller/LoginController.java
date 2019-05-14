package cn.itsource.yigou.controller;

import cn.itsource.yigou.domain.Employee;
import cn.itsource.yigou.service.EmployeeService;
import cn.itsource.yigou.util.AjaxResult;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author lzctuoxie
 * @version v1.0
 * @description: TODO
 * @date 2019/5/11/16:10
 * @ClassName:LoginController
 */
@RestController
public class LoginController {

    @Autowired
    private EmployeeService employeeService;


    /**
     * 前端使用vue，vue建议时间axios发送ajax请求
     * axios发送post请求，参数以json体的形式发送的
     *
     *  http://localhost:8080/login?username=xxx&password=xxx
     *
     *  http://localhost:8080/login
     *  {
     *      "username":"admin",
     *      "password":"admin"
     *  }
     *
     * 后端封装json体，使用@RequestBody
     * @param params
     * @return
     */
    @PostMapping("/login")
    @ApiOperation(value = "登陆接口")
    public AjaxResult login(@RequestBody Map<String,Object> params){
        String username =  (String) params.get("username");
        String password =  (String) params.get("password");

        Employee employee = employeeService.login(username,password);

        if(employee!=null){
            //成功
            return AjaxResult.me();
        }
        return AjaxResult.me().setSuccess(false).setMessage("密码错误或用户名错误");
    }
}
