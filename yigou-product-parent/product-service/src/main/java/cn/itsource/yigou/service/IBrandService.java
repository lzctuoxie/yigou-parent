package cn.itsource.yigou.service;

import cn.itsource.yigou.domain.Brand;
import cn.itsource.yigou.query.BrandQuery;
import cn.itsource.yigou.util.PageList;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 品牌信息 服务类
 * </p>
 *
 * @author lzctuoxie
 * @since 2019-05-16
 */
public interface IBrandService extends IService<Brand> {
    PageList<Brand> getByQuery(BrandQuery query);
}
