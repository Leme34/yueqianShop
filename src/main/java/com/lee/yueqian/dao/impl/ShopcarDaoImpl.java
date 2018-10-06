package com.lee.yueqian.dao.impl;

import com.lee.yueqian.bean.ShopCar;
import com.lee.yueqian.bean.Sp_Car;
import com.lee.yueqian.bean.Sp_CarExample;
import com.lee.yueqian.dao.Sp_CarMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopcarDaoImpl {

    @Autowired
    Sp_CarMapper shopCarDao;

    //查询该用户的购物车是否已有该商品的记录
    public boolean isAdded(String username,String shopInfoId){
        Sp_CarExample example = new Sp_CarExample();
        Sp_CarExample.Criteria criteria = example.createCriteria();
        criteria.andSpCarUserEqualTo(username);
        criteria.andSpCarIdEqualTo(Integer.parseInt(shopInfoId));
        List<Sp_Car> spCars = shopCarDao.selectByExample(example);
        if(spCars==null||spCars.size()==0){
            return false;
        }else
            return true;
    }

    //修改该商品记录的条数
    public int addToShopcar(String username,String shopInfoId,String count){
        return shopCarDao.addToShopcar(username,shopInfoId,count);
    }

    //直接插入该商品的记录
    public int insertToShopcar(String username,String shopInfoId,String count){
        return shopCarDao.insertToShopcar(username,shopInfoId,count);
    }

    //在sp_car表中联合sp_info查询该用户的购物车所有商品
    public List<ShopCar> getShopCarList(String userId){
        return shopCarDao.getShopCarList(userId);
    }

    //删除购物车中的count个此商品
    public int deleteShopCount(String userId,String shopId,String count){
        if("0".equals(count)) {
            Sp_CarExample example = new Sp_CarExample();
            Sp_CarExample.Criteria criteria = example.createCriteria();
            criteria.andSpCarUserEqualTo(userId);
            criteria.andSpCarIdEqualTo(Integer.parseInt(shopId));
            int effectedRows = shopCarDao.deleteByExample(example);
            return effectedRows;
        }else {
            int effectedRows = shopCarDao.addToShopcar(userId,shopId,count);
            return effectedRows;
        }
    }


}