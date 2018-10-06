package com.lee.yueqian.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lee.yueqian.bean.ShopCar;
import com.lee.yueqian.bean.Sp_Info;
import com.lee.yueqian.bean.Sp_Type;
import com.lee.yueqian.dao.impl.ShopInfoDaoImpl;
import com.lee.yueqian.dao.impl.ShopTypeDaoImpl;
import com.lee.yueqian.dao.impl.ShopcarDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.List;

/**
 * 商品相关操作
 */
@Controller
public class ShopController {

    @Autowired
    ShopInfoDaoImpl shopInfoDaoImpl;
    @Autowired
    ShopTypeDaoImpl shopTypeDaoImpl;
    @Autowired
    ShopcarDaoImpl shopcarDaoImpl;

    /**
     * 主页商品展示操作
     */
    @RequestMapping(value = {"/","/index","index.html"})
    public String index(@RequestParam(value = "pageNum",defaultValue = "1") int pageNum ,
                        ModelMap modelMap){
        //会使以下sql语句执行分页查询(拦截器实现的)
        PageHelper.startPage(pageNum,12);
        //查询商品列表
        List<Sp_Info> shopInfos = shopInfoDaoImpl.getAllShop();
        //查出来的分页结果包装Page对象,只需要把pageInfo对象交给页面就行了(通过Model传递)
        PageInfo<Sp_Info> pageInfo = new PageInfo<>(shopInfos,5);
        modelMap.addAttribute("pageInfo",pageInfo);


        //查询主页分类下拉列表
        List<Sp_Type> shopTypes = shopTypeDaoImpl.getAllShopType();
        modelMap.addAttribute("shopTypes",shopTypes);

        return "index";
    }


    /**
     * 从商品列表点击跳转商品详细页操作
     */
    @RequestMapping("/shopdetail")
    public String shopdetail(@RequestParam("id") String id , ModelMap modelMap){
        Sp_Info shopInfo = shopInfoDaoImpl.getShopInfo(id);
        //放入请求域
        modelMap.addAttribute("shopInfo",shopInfo);
        return "shop_deatil";
    }


    /**
     * 各个分类商品页面
     */
    @RequestMapping("/index/{typeId}")
    public String typePage(@RequestParam(value = "pageNum",defaultValue = "1")int pageNum ,
                           @PathVariable("typeId")String typeid ,
                           ModelMap modelMap){
        int typeId = Integer.parseInt(typeid);
        //会使以下sql语句执行分页查询(拦截器实现的)
        PageHelper.startPage(pageNum,12);
        List<Sp_Info> shopInfos = shopInfoDaoImpl.getTypeShopInfos(typeId);
        PageInfo<Sp_Info> pageInfo = new PageInfo<>(shopInfos,5);
        modelMap.addAttribute("pageInfo",pageInfo);

        //查询主页分类下拉列表
        List<Sp_Type> shopTypes = shopTypeDaoImpl.getAllShopType();
        modelMap.addAttribute("shopTypes",shopTypes);
        //返回当前分类
        Sp_Type spType = shopTypes.get(typeId-1);
        modelMap.addAttribute("spType",spType.getTypeName());
        modelMap.addAttribute("spTypeId",spType.getId());
        return "type_index";
    }


    /**
     * 商品详细页加入购物车
     * 1、先查询该用户的购物车是否已有该商品的记录，若有则修改该记录的条数
     * 2、若无则直接插入该商品的记录
     */
    @RequestMapping("/addToShopcar")
    public String addToShopcar(@RequestParam("shopId")String shopId,
                               @RequestParam("count")String count,
                               HttpSession httpSession,ModelMap modelMap){
        String username = (String) httpSession.getAttribute("username");
        //若未登录则跳转登录
        if(username==null){
            modelMap.addAttribute("msg","请先登录");
            return "login";
        }else if (shopcarDaoImpl.isAdded(username,shopId)){ //若已有该商品的记录
            //则修改该记录的条数(+count条)
            shopcarDaoImpl.addToShopcar(username,shopId,count);
            //重定向购物车页
            return "redirect:/shopcar";
        }else{ //否则无该商品的记录,直接插入该商品的记录
            shopcarDaoImpl.insertToShopcar(username,shopId,count);
            //重定向购物车页
            return "redirect:/shopcar";
        }
    }

    /**
     * 跳转购物车页
     */
    @RequestMapping("/shopcar")
    public String shopcar(HttpSession httpSession,ModelMap modelMap){
        String username = (String) httpSession.getAttribute("username");
        //若未登录则跳转登录
        if(username==null){
            modelMap.addAttribute("msg","请先登录");
            return "login";
        }else{ //根据id查询购物车列表
            List<ShopCar> shopCarList = shopcarDaoImpl.getShopCarList(username);
            //若长度为0则放入null
            if(shopCarList.size()==0) {
                shopCarList = null;
                modelMap.addAttribute("shopCarList", shopCarList);
                //跳转购物车列表页
                return "shopcar";
            }else {
                modelMap.addAttribute("shopCarList", shopCarList);
                //遍历列表的每个对象，计算总件数(shopNum)和总价格(totalPrice)
                int shopNum = 0;
                float totalPrice = 0;
                for (ShopCar shopCar : shopCarList) {
                    totalPrice += Float.parseFloat(shopCar.getNewPrice()) * Integer.parseInt(shopCar.getNumber());
                    shopNum += Integer.parseInt(shopCar.getNumber());
                }
                modelMap.addAttribute("totalPrice", new BigDecimal(totalPrice).setScale(2,4)); //保留2位数
                modelMap.addAttribute("shopNum", shopNum);
                //跳转购物车列表页
                return "shopcar";
            }
        }

    }

    /**
     * 删除购物车中的count个此商品并重定向购物车页
     */
    @RequestMapping("/delFromShopcar")
    public String delFromShopcar(@RequestParam("shopInfoId")String shopInfoId,
                                 @RequestParam(value = "count",defaultValue = "")String count, //获取删除数量,若为null则是删除全部此商品
                                 HttpSession httpSession,ModelMap modelMap){
        String username = (String) httpSession.getAttribute("username");
        //若session还未过期
        if(username==null) {
            modelMap.addAttribute("msg", "长时间未操作,请重新登录");
            return "login";
        }else if(count==null||"".equals(count)){//若没有传count则删除所有跳转登录页
            shopcarDaoImpl.deleteShopCount(username, shopInfoId,"0");
            System.out.println("从购物车删除"+shopInfoId+"类的商品");
            //防止刷新重复删除，使用重定向
            return "redirect:/shopcar";
        }else{//否则删除count个此商品并跳转登录页
            shopcarDaoImpl.deleteShopCount(username, shopInfoId,"-1");
            return "redirect:/shopcar";
        }

    }
}
