package com.JSXExercise.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author 姜上晓
 * @version 1.0
 * UDP接受端
 */
public class UDPReceiverA {
    public static void main(String[] args) throws IOException {
        //1.创建一个DatagramSocket对象,准备在9999接收数据
        DatagramSocket socket = new DatagramSocket(9999);
        //2.构建一个DatagramPacket对象,准备接受数据
        byte[] buf = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buf, buf.length);
        //3.调用接受方法,将通过网络传输的DatagramPacket对象填充到packet对象
        System.out.println("接收端A 等待接受数据..");
        socket.receive(packet);

        //4.可以把packet进行拆包,取出数据,并显示
        int length = packet.getLength(); //实际接收到的数据字节长度
        byte[] data = packet.getData(); //接收到的数据

        String s = new String(data, 0, length);
        System.out.println(s);

        //5.关闭资源
        socket.close();
        System.out.println("A端退出");
    }
}
