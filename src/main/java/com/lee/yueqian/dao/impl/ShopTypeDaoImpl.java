package com.lee.yueqian.dao.impl;

import com.lee.yueqian.bean.Sp_Type;
import com.lee.yueqian.dao.Sp_TypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopTypeDaoImpl {
    @Autowired
    Sp_TypeMapper shopTypeMapper;

    //查询主页下拉列表
    public List<Sp_Type> getAllShopType(){
        return shopTypeMapper.selectByExample(null);
    }

}
