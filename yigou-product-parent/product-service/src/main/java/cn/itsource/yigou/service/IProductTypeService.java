package cn.itsource.yigou.service;

import cn.itsource.yigou.domain.ProductType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 商品目录 服务类
 * </p>
 *
 * @author lzctuoxie
 * @since 2019-05-16
 */
public interface IProductTypeService extends IService<ProductType> {
    //加载树形数据
    List<ProductType> loadTreeData();

    void generateStaticPage();
}
