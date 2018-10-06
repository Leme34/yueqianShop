package com.lee.yueqian.controller.admin;

import com.lee.yueqian.bean.Sp_Info;
import com.lee.yueqian.bean.Sp_Type;
import com.lee.yueqian.component.Commons;
import com.lee.yueqian.dao.impl.ShopInfoDaoImpl;
import com.lee.yueqian.dao.impl.ShopTypeDaoImpl;
import com.lee.yueqian.dao.impl.ShopcarDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 负责跳转页面
 */
@RequestMapping("/admin")
@Controller
public class AdminBaseController {

    @Autowired
    Commons commons;
    @Autowired
    ShopTypeDaoImpl shopTypeDaoImpl;
    @Autowired
    ShopInfoDaoImpl shopInfoDaoImpl;

    //跳转登录页
    @RequestMapping("/login")
    public String init(HttpServletRequest request){
        //把Commons实例对象保存到HttpServletRequest域中使thymeleaf可以调用Commons类中的方法去切换背景
        request.setAttribute("commons",commons);
        return "admin/login";
    }

    //跳转主页
    @RequestMapping("/main")
    public String main(){
        return "admin/pages/index";
    }


    //跳转图表页
    @RequestMapping("/charts")
    public String charts(){
        return "admin/pages/charts";
    }

    //跳转订单table页
    @RequestMapping("/tables")
    public String tables(){
        return "admin/pages/tables";
    }


    //I跳转商品修改页
    @RequestMapping("/editGoods")
    public String toGoods_edit(@RequestParam("shopInfoId") String shopInfoId, ModelMap modelMap){
        Sp_Info shopInfo = shopInfoDaoImpl.getShopInfo(shopInfoId);
        //根据shopInfoId把这条数据放到表单中
        modelMap.addAttribute("shopInfo",shopInfo);
        //查询分类下拉列表
        List<Sp_Type> shopTypes = shopTypeDaoImpl.getAllShopType();
        modelMap.addAttribute("shopTypes",shopTypes);

        return "admin/pages/goods_edit";
    }

}
