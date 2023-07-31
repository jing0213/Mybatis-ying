package com.ying.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author: jing213
 * @date: 2023-07-26 22:09
 * @description:
 */
public class MapperProxyFactory<T> {

    // 注入该对象，方便对该对象代理
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
















