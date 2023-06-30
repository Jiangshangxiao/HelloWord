package com.JSXExercise.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {
        //获取本机的InetAddress对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);

        //根据指定主机名获取InetAddress对象
        InetAddress host1 = InetAddress.getByName("姜上晓的R9000");
        System.out.println("host1 = " + host1);

        //根据域名返回InetAddress对象,比如 www.baidu.com对应
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2 = " + host2);

        //通过InetAddress对象,获取对应的地址
        String hostAddress = host2.getHostAddress();
        System.out.println("host2对应的地址 = " + hostAddress);

        //通过InetAddress对象,获取对应的主机名/获取域名
        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名 = " + hostName);
    }
}
