package cn.itsource.yigou.service.impl;

import cn.itsource.yigou.domain.Product;
import cn.itsource.yigou.mapper.ProductMapper;
import cn.itsource.yigou.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * 商品 服务实现类
 * </p>
 *
 * @author lzctuoxie
 * @since 2019-05-16
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
