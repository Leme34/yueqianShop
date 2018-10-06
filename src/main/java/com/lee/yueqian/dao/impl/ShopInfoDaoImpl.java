package com.lee.yueqian.dao.impl;

import com.lee.yueqian.bean.ShopCar;
import com.lee.yueqian.bean.Sp_Car;
import com.lee.yueqian.bean.Sp_Info;
import com.lee.yueqian.bean.Sp_InfoExample;
import com.lee.yueqian.dao.Sp_InfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopInfoDaoImpl {

    @Autowired
    Sp_InfoMapper shopInfoMapper;

    //查询所有商品
    public List<Sp_Info> getAllShop(){
        return shopInfoMapper.selectByExample(null);
    }


    //条件为typecode，根据keyword模糊查询
    public List<Sp_Info> search(String typecode,String keyword){
            //转为integer
            int typeId = Integer.parseInt(typecode);
        //处理模糊查询关键字
        keyword = "%" + keyword + "%";

        //创建查询条件对象
        Sp_InfoExample shopInfoExample = new Sp_InfoExample();
        Sp_InfoExample.Criteria criteria = shopInfoExample.createCriteria();
        //条件为typecode
        criteria.andSpTypeEqualTo(typeId);
        //根据keyword模糊查询
        criteria.andSpNameLike(keyword);

        List<Sp_Info> shopInfoList = shopInfoMapper.selectByExample(shopInfoExample);
        return shopInfoList;
    }


    //根据id查商品详细页信息
    public Sp_Info getShopInfo(String id){
        //转为int
        int Id = Integer.parseInt(id);
        return shopInfoMapper.selectByPrimaryKey(Id);
    }

    //查询指定分类id的所有商品
    public List<Sp_Info> getTypeShopInfos(int typeId){
        Sp_InfoExample sp_infoExample = new Sp_InfoExample();
        Sp_InfoExample.Criteria criteria = sp_infoExample.createCriteria();
        criteria.andSpTypeEqualTo(typeId);
        List<Sp_Info> shopInfos = shopInfoMapper.selectByExample(sp_infoExample);
        return  shopInfos;
    }

    //admin新增商品
    public int addGoods(Sp_Info shopInfo){
        return shopInfoMapper.insertSelective(shopInfo);
    }

    //admin删除商品
    public int delGoodsById(String ShopInfoId){
        return shopInfoMapper.deleteByPrimaryKey(Integer.parseInt(ShopInfoId));
    }

    //admin更新商品
    public int updateGoodsById(Sp_Info shopInfo){
        return shopInfoMapper.updateByPrimaryKeySelective(shopInfo);
    }
}
