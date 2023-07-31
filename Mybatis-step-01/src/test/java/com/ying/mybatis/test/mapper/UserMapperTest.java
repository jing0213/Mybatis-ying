package com.ying.mybatis.test.mapper;

import com.ying.mybatis.binding.MapperProxyFactory;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: jing213
 * @date: 2023-07-26 22:13
 * @description:
 */
public class UserMapperTest {

    @Test
    public void test(){
        MapperProxyFactory<UserMapper> factory = new MapperProxyFactory<>(UserMapper.class);
        Map<String, String> sqlSession = new HashMap<>();
        //com.ying.mybatis.test.mapper.UserMapper.getUserName
        sqlSession.put("com.ying.mybatis.test.mapper.UserMapper.getUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        UserMapper userMapper = factory.newInstance(sqlSession);
        String res = userMapper.getUserName("666");
        System.out.println(res);
    }
}
