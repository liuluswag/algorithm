package com.liulu.proxy;

import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * JDK动态代理的使用方法
 * 1）代理对象需要实现InvocationHandler接口，调用代理方法时会转向执行invoke()方法
 * 2）生成代理对象需要使用Proxy对象中的newProxyInstance()方法，返回对象强转成传入的其中的一个接口，然后调用接口方法即可实现代理
 * 特点
 * 目标对象强制需要实现一个接口，否则无法使用JDK动态代理
 */

public class XiaoMing {
    public static void main(String[] args) {
        //实例化一个红酒销售商
        RedWineFactory redWineFactory = new RedWineFactory();
        //实例化代理对象，传入红酒销售商引用控制对其的访问
        SellProxyFactory sellProxyFactory = new SellProxyFactory(redWineFactory);
        //实例化代理对象，该对象可以代理售卖红酒
        SellWine sellWithProxy = (SellWine)
                Proxy.newProxyInstance(redWineFactory.getClass().getClassLoader(),
                redWineFactory.getClass().getInterfaces(),
                sellProxyFactory);
        //代理售卖红酒
        sellWithProxy.sellWine(1999.99);
    }
}
