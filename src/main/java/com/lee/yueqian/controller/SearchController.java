package com.lee.yueqian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.yueqian.bean.Sp_Info;
import com.lee.yueqian.bean.Sp_Type;
import com.lee.yueqian.dao.impl.ShopInfoDaoImpl;
import com.lee.yueqian.dao.impl.ShopTypeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 处理搜索操作
 */
@Controller
public class SearchController {

    @Autowired
    ShopInfoDaoImpl shopInfoDaoImpl;

    @Autowired
    ShopTypeDaoImpl shopTypeDaoImpl;

    @RequestMapping("/search")
    public String search(@RequestParam("typecode")String typecode,
                         @RequestParam("keyword")String keyword,
                         @RequestParam(value = "pageNum",defaultValue = "1")int pageNum,
                         ModelMap modelMap){
        //处理分页
        PageHelper.startPage(pageNum,12);

        //条件为typecode，根据keyword模糊查询
        List<Sp_Info> search_shopInfos = shopInfoDaoImpl.search(typecode, keyword);

        System.out.println(search_shopInfos);

        PageInfo<Sp_Info> pageInfo = new PageInfo<>(search_shopInfos,5);
        //放入请求域
        modelMap.addAttribute("pageInfo",pageInfo);


        //查询主页分类下拉列表
        List<Sp_Type> shopTypes = shopTypeDaoImpl.getAllShopType();
        modelMap.addAttribute("shopTypes",shopTypes);

        //typecode转为typeId
        int typeId = Integer.parseInt(typecode);

        //把typecode和keyword传到前端拼装下一页的href
        modelMap.addAttribute("typeId",typeId);
        modelMap.addAttribute("keyword",keyword);


        return "search_page";
    }

}
