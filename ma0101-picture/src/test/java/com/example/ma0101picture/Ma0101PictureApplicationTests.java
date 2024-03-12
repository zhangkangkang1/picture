package com.example.ma0101picture;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class Ma0101PictureApplicationTests {

    @Test
    void contextLoads() {
//        StringUtil.isNotE
//        String str = "zk";
//        String[] split = str.split(",");
//        System.out.println(split);
//        for (int i = 0; i < split.length; i++) {
//            System.out.println(split[i]);
//        }


        String  str  = "pdf";
        String st = "PDF";

        ArrayList<UserDao> list = new ArrayList<>();
        UserDao userDao = new UserDao();
        userDao.setUserName("zk");
        userDao.setId("123456");
        userDao.setPwd("zk");

        UserDao userDao1 = new UserDao();
        userDao1.setUserName("zk");
        userDao1.setId("123456");
        userDao1.setPwd("zk");
        list.add(userDao);
        list.add(userDao1);
        //属性集合
        List<Object> distinctList = list.stream()
                .map(obj -> obj.getId())
                .distinct()
                .collect(Collectors.toList());

        System.out.println(distinctList);

        //全集合 案例分析
        List<UserDao> collect = list.stream().distinct().collect(Collectors.toList());
        System.out.println(collect);

        String  strr = "今天天气怎么样";
        String  strrr= "";
        String a = "";
        List<String> list11 = new ArrayList<>();
        list11.add("11");
        list11.add("111");
        list11.add("1111");
        list11.add("11111");
        for (int i = 0; i < list11.size(); i++) {
            strrr += "#fileId#" + list11.get(i);
        }
        System.err.println(strr + strrr);
    }

}
