package com.lee.yueqian;

import com.lee.yueqian.bean.Sp_Car;
import com.lee.yueqian.bean.Sp_Info;
import com.lee.yueqian.bean.Sp_InfoExample;
import com.lee.yueqian.bean.Users;
import com.lee.yueqian.dao.Sp_CarMapper;
import com.lee.yueqian.dao.Sp_InfoMapper;
import com.lee.yueqian.dao.UsersMapper;
import com.lee.yueqian.dao.impl.ShopInfoDaoImpl;
import com.lee.yueqian.dao.impl.ShopcarDaoImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class YueqianApplicationTests {

	@Autowired
	UsersMapper usersMapper;
	@Autowired
	Sp_InfoMapper shopInfoMapper;
	@Autowired
	ShopInfoDaoImpl shopInfoDaoImpl;
	@Autowired
	ShopcarDaoImpl shopcarDaoImpl;

	@Autowired
	Sp_CarMapper shopcarDao;

	@Test
	public void contextLoads() {
		String typecode = "1";
		//转为integer
//		int typeId = Integer.parseInt(typecode);
		String keyword = "洁面乳";
		//处理模糊查询关键字
		keyword = "%" + keyword + "%";
//		//创建查询条件对象
//		Sp_InfoExample shopInfoExample = new Sp_InfoExample();
//		Sp_InfoExample.Criteria criteria = shopInfoExample.createCriteria();
//		//条件为typecode
//		criteria.andSpTypeEqualTo(typeId);
//		//根据keyword模糊查询
//		criteria.andSpNameLike(keyword);
//
//		List<Sp_Info> shopInfoList = shopInfoMapper.selectByExample(shopInfoExample);
//		System.out.println(shopInfoList);
		List<Sp_Info> sp_infos = shopInfoDaoImpl.search(typecode, keyword);
		System.out.println(sp_infos);

	}

	@Test
	public void test(){
		String shopInfoId = "51";
		Sp_Info shopInfo = shopInfoDaoImpl.getShopInfo(shopInfoId);
		System.out.println(shopInfo);
	}


}
