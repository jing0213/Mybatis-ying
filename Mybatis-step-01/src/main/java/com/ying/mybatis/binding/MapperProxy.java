package com.ying.mybatis.binding;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: jing213
 * @date: 2023-07-26 22:03
 * @description:
 */
public class MapperProxy<T> implements InvocationHandler {

    // key: 接口名称+方法名称   value: 具体数据库操作逻辑
    private Map<String,String> sqlSession;
    // 注入mapper接口方便拿到mapper接口的一些东西
    private final Class<T> mapperInterface;

    public MapperProxy(Map<String, String> sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 不代理Object类的方法，toString...
        if (Object.class.equals(method.getDeclaringClass()))
        {
            return method.invoke(this, args);
        } else {
            return "成功代理了方法：" + sqlSession.get(mapperInterface.getName() + "." + method.getName());
        }
    }
}
