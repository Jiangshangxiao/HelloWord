package com.JSXExercise.upload;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 姜上晓
 * @version 1.0
 * 文件上的客户端
 */
public class TCPFileUploadClient {
    public static void main(String[] args) throws Exception {
        //创建客户端连接服务端,得到socket对象
        Socket socket = new Socket(InetAddress.getLocalHost(), 8888);
        //创建读取磁盘文件的输入流
        String filePath = "D:\\xiamu.jpg";
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(filePath));

        //bytes 就是filePath对应的字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        bis.close();
        //通过socket获取到输出流,将bytes数据发送到服务端
        BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
        bos.write(bytes); //将文件对应的字节数据的内容,写入到数据通道
        bos.close();

        socket.shutdownOutput(); //设置写入数据的标志

        //接受从服务端回复的消息
        InputStream inputStream = socket.getInputStream();
        String s = StreamUtils.streamToString(inputStream);
        System.out.println(s);

        //关闭相关的流
        inputStream.close();

        socket.close();

    }
}
