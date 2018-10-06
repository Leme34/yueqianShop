package com.lee.yueqian.dao;

import com.lee.yueqian.bean.Sp_Info;
import com.lee.yueqian.bean.Sp_InfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface Sp_InfoMapper {
    int countByExample(Sp_InfoExample example);

    int deleteByExample(Sp_InfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Sp_Info record);

    int insertSelective(Sp_Info record);

    List<Sp_Info> selectByExample(Sp_InfoExample example);

    Sp_Info selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Sp_Info record, @Param("example") Sp_InfoExample example);

    int updateByExample(@Param("record") Sp_Info record, @Param("example") Sp_InfoExample example);

    int updateByPrimaryKeySelective(Sp_Info record);

    int updateByPrimaryKey(Sp_Info record);
}