package com.lee.yueqian.dao;

import com.lee.yueqian.bean.Sp_Type;
import com.lee.yueqian.bean.Sp_TypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sp_TypeMapper {
    int countByExample(Sp_TypeExample example);

    int deleteByExample(Sp_TypeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sp_Type record);

    int insertSelective(Sp_Type record);

    List<Sp_Type> selectByExample(Sp_TypeExample example);

    Sp_Type selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sp_Type record, @Param("example") Sp_TypeExample example);

    int updateByExample(@Param("record") Sp_Type record, @Param("example") Sp_TypeExample example);

    int updateByPrimaryKeySelective(Sp_Type record);

    int updateByPrimaryKey(Sp_Type record);
}