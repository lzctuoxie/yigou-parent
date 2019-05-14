package cn.itsource.yigou.service;

import cn.itsource.yigou.domain.Employee;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author lzctuoxie
 * @version v1.0
 * @description: TODO
 * @date 2019/5/14
 * @ClassName:
 */
public interface EmployeeService extends IService<Employee> {

    Employee login(String username, String password);
}
