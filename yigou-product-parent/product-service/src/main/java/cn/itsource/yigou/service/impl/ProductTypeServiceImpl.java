package cn.itsource.yigou.service.impl;

import cn.itsource.yigou.domain.ProductType;
import cn.itsource.yigou.mapper.ProductTypeMapper;
import cn.itsource.yigou.service.IProductTypeService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 商品目录 服务实现类
 * </p>
 *
 * 项目中遇到的问题：
 * 后台管理中树形结构展示所有的商品类型，展示无限级别的类型
 * 问题：我们使用的是递归，写一个方法，根据父id查询所有的自己类型
 *      再对所有的子类型遍历，针对于每个子类型再次调用这个方法查询子类型的子类型
 *      知道没有子类型位置跳出递归，这种方式每次都查询数据库，效率很低，资源消耗大，
 *      增加了数据库的压力，用户的体验很不好
 *
 *  解决：
 *  使用循环代替递归，一次性查询出所有的类型，开始遍历，如果是一级类型，直接封装到返回的list中
 *  如果是子类型，添加到对应父类型的children中。由于只查询一次数据库，降低了数据库的压力，并且提高了
 *  效率，增强了用户的体验。
 *
 * @author lzctuoxie
 * @since 2019-05-16
 */
@Service
@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
public class ProductTypeServiceImpl extends ServiceImpl<ProductTypeMapper, ProductType> implements IProductTypeService {

    @Override
    public List<ProductType> loadTreeData() {
        return loadDataTree();
    }

    private List<ProductType> loadDataTree(Long pid){
        //根据父id查询子类型
        List<ProductType> children = baseMapper.selectList(new QueryWrapper<ProductType>().eq("pid", pid));
        //递归出口
        if(children==null || children.size()==0){
            return null;
        }
        for (ProductType productType : children) {
            //对子进行循环，调用自己继续查询子的子类型
            List<ProductType> pt = loadDataTree(productType.getId());
            //将所有的孙子类型放入到子的children属性中
            productType.setChildren(pt);
        }
        return children;
    }

    /**
     * 循环
     * @return
     */
    private List<ProductType> loadDataTree(){

        //查询所有
        List<ProductType> productTypes = baseMapper.selectList(null);
        //放到Map中--大大的降低循环次数
        Map<Long,ProductType> map = new HashMap<>();
        for (ProductType productType : productTypes) {
            map.put(productType.getId(),productType);
        }

        //放所有的一级类型
        List<ProductType> list = new ArrayList<>();
        //子找父
        for (ProductType productType : productTypes) {
            //如果pid为0则自己就是父
            if(productType.getPid()==0){
                list.add(productType);
            }else{
                map.get(productType.getPid()).getChildren().add(productType);
            }
        }
        return list;

    }


}
