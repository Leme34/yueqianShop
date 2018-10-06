package com.lee.yueqian.controller.admin;

import com.lee.yueqian.bean.Sp_Car;
import com.lee.yueqian.bean.Sp_Info;
import com.lee.yueqian.bean.Sp_Type;
import com.lee.yueqian.dao.impl.ShopInfoDaoImpl;
import com.lee.yueqian.dao.impl.ShopTypeDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 商品增加功能
 */

@Controller
@RequestMapping("/admin")
public class GoodsController {
    @Autowired
    ShopTypeDaoImpl shopTypeDaoImpl;
    @Autowired
    ShopInfoDaoImpl shopInfoDaoImpl;

    //新增商品(图片太大会报错)
    @PostMapping("/addGoods")
    public String addShop(@RequestParam("shopName") String shopName,
                          @RequestParam("shopDesc") String shopDesc,
                          @RequestParam("shopNum") String shopNum,
                          @RequestParam("shopcategory") String shopcategory,
                          @RequestParam("oldPrice") String oldPrice, @RequestParam("newPrice") String newPrice,
                          @RequestParam("imgFile") MultipartFile imgFile) {
        System.out.println("OriginalFilename"+imgFile.getOriginalFilename());
        //图片改名,保存到服务器本地
        String fileName = FileFunc(imgFile);
        System.out.println("fileName:"+fileName);
        //封装对象
        Sp_Info shopInfo = new Sp_Info();
        shopInfo.setSpName(shopName);
        shopInfo.setSpInfo(shopDesc);
        shopInfo.setSpType(Integer.parseInt(shopcategory));
        shopInfo.setOldPrice(oldPrice);
        shopInfo.setNewPrice(newPrice);
        shopInfo.setSpImg(fileName);
        //添加到数据库sp_car表
        shopInfoDaoImpl.addGoods(shopInfo);

        return "redirect:/admin/main";
    }



    //返回处理后的文件名(文字长度太长会使排版混乱)
    private String FileFunc(@RequestParam("imgFile") MultipartFile imgFile) {
        //根据时间为图片改名防止重复
        String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + imgFile.getOriginalFilename();
        //根据操作系统，拼装路径保存到服务器本地
        String os = System.getProperty("os.name");
        String separator = System.getProperty("file.separator");
        String filePath;
        if (os.toLowerCase().startsWith("win")) {
            filePath = "D:/ideaWorkPlace/yueqian/src/main/resources/static/item_images/" + fileName;
        } else {
            filePath = "/home/yueqian/src/main/resources/static/item_images/".replace("/", separator) + fileName;
        }
        //开始复制
        try {
            InputStream is = imgFile.getInputStream();
            FileOutputStream fos = new FileOutputStream(filePath);
            byte[] buf = new byte[1024];
            int len;
            while ((len=is.read(buf))!=-1){
                fos.write(buf,0,len);
            }
            fos.close();
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }


    //展示所有商品(可管理)列表
    @RequestMapping("/allGoods")
    public String goods_manage(ModelMap modelMap){
        //查出所有商品
        List<Sp_Info> shopInfos = shopInfoDaoImpl.getAllShop();
        modelMap.addAttribute("shopInfos",shopInfos);
        //查询主页分类下拉列表
        List<Sp_Type> shopTypes = shopTypeDaoImpl.getAllShopType();
        modelMap.addAttribute("shopTypes",shopTypes);
        return "admin/pages/goodslist";

    }


    //修改商品操作
    @PutMapping("/editGoods")
    public String goods_edit(Sp_Info shopInfo){
        System.out.println(shopInfo);
        //更新商品(未付款的订单修改操作后会失效)
        shopInfoDaoImpl.updateGoodsById(shopInfo);
        return "redirect:/admin/allGoods";
    }

    //删除商品
    @RequestMapping("/delGoods")
    public String goods_del(@RequestParam("shopInfoId") String shopInfoId, ModelMap modelMap){
        //删除商品(未付款的订单下架操作后会失效)
        shopInfoDaoImpl.delGoodsById(shopInfoId);
        //删除对应的图片(图片前提路径没改过)
//        String spImg = shopInfoDaoImpl.getShopInfo(shopInfoId).getSpImg();
//        Sp_Info shopInfo = shopInfoDaoImpl.getShopInfo(shopInfoId);
//        System.out.println(shopInfo);
//        String spImg = shopInfo.getSpImg();
//        try {
//            new File(spImg).delete();
//        }catch (Exception e){
//            e.printStackTrace();
//        }

        return "redirect:/admin/allGoods";
    }


}
