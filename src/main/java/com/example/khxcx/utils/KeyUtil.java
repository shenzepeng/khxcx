package com.example.khxcx.utils;

import java.util.Random;

/**
 * @Auther:沈泽鹏
 * @Date: 2019/3/17 08:41
 * @Description: 沈泽鹏写点注释吧
 */
public class KeyUtil {
    /**
     * 生成唯一的主键
     * 格式: 时间+随机数
     * @return
     */
    public static synchronized String genUniqueKey() {
        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }


}
