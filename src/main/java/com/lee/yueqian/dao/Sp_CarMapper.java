package com.lee.yueqian.dao;

import com.lee.yueqian.bean.ShopCar;
import com.lee.yueqian.bean.Sp_Car;
import com.lee.yueqian.bean.Sp_CarExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sp_CarMapper {
    int countByExample(Sp_CarExample example);

    int deleteByExample(Sp_CarExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sp_Car record);

    int insertSelective(Sp_Car record);

    List<Sp_Car> selectByExample(Sp_CarExample example);

    Sp_Car selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sp_Car record, @Param("example") Sp_CarExample example);

    int updateByExample(@Param("record") Sp_Car record, @Param("example") Sp_CarExample example);

    int updateByPrimaryKeySelective(Sp_Car record);

    int updateByPrimaryKey(Sp_Car record);

    //增加购物车已有的商品的数量(update)
    int addToShopcar(@Param("username")String username,@Param("shopInfoId")String shopInfoId,@Param("count")String count);

    //直接插入该商品的记录
    int insertToShopcar(@Param("username")String username,@Param("shopInfoId")String shopInfoId,@Param("count")String count);

    //在sp_car表中联合sp_info查询该用户的购物车所有商品
    List<ShopCar> getShopCarList(String userId);

}