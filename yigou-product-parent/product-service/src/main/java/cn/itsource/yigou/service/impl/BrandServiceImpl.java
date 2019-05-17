package cn.itsource.yigou.service.impl;

import cn.itsource.yigou.domain.Brand;
import cn.itsource.yigou.mapper.BrandMapper;
import cn.itsource.yigou.query.BrandQuery;
import cn.itsource.yigou.service.IBrandService;
import cn.itsource.yigou.util.PageList;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 品牌信息 服务实现类
 * </p>
 *
 * @author lzctuoxie
 * @since 2019-05-16
 */
@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements IBrandService {

    @Override
    public PageList<Brand> getByQuery(BrandQuery query) {
        Page<Brand> page = new Page<>(query.getPage(),query.getSize());
        //核心代码 mybatis-plus的分页
        IPage<Brand> iPage = baseMapper.selectByQuery(page,query);
        //从IPage中提取分页结果封装到自己的PageList中
        return new PageList<Brand>(iPage.getTotal(),iPage.getRecords());
    }
}
