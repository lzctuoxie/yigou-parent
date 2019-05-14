package cn.itsource.yigou.service.impl;

import cn.itsource.yigou.domain.Employee;
import cn.itsource.yigou.mapper.EmployeeMapper;
import cn.itsource.yigou.service.EmployeeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lzctuoxie
 * @version v1.0
 * @description: TODO
 * @date 2019/5/14
 * @ClassName:
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements EmployeeService {
    @Override
    public Employee login(String username, String password) {

        return baseMapper.selectOne(new QueryWrapper<Employee>()
                .eq("username",username )
                .eq("password",password ));
    }
}
