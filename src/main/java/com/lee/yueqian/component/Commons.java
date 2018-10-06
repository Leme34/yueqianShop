package com.lee.yueqian.component;

import com.lee.yueqian.utils.UUID;
import org.springframework.stereotype.Component;

/**
 * thymeleaf引用的方法类
 */
@Component  //注入ioc容器
public class Commons {

    /**
     * 获取随机数
     *
     * @param max
     * @param str
     * @return
     */
    public static String random(int max, String str) {
        return UUID.random(1, max) + str;
    }

}
