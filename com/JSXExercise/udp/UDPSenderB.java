package com.JSXExercise.udp;

import java.io.IOException;
import java.net.*;

/**
 * @author 姜上晓
 * @version 1.0
 * UDP发送端
 */
public class UDPSenderB {
    public static void main(String[] args) throws IOException {
        //1.创建DatagramSocket 对象,准备发送和接收数据
        DatagramSocket socket = new DatagramSocket(9998);

        //2.将需要发送的数据,封装到DatagramPacket对象
        byte[] data = "hello 明天去吃火锅".getBytes();
        DatagramPacket datagramPacket =
                new DatagramPacket(data, data.length, InetAddress.getLocalHost(), 9999);
        socket.send(datagramPacket);

        //关闭资源
        socket.close();
        System.out.println("B端退出");
    }
}
