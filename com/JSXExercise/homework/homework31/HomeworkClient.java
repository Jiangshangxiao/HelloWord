package com.JSXExercise.homework.homework31;

import com.JSXExercise.upload.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class HomeworkClient {
    public static void main(String[] args) throws Exception {
        //1.接受用户输入,指定下载文件名
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入下载文件名");
        String downloadFileName = scanner.next();

        //2.客户端连接服务端准备发送
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        //3.获取和Socket关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write(downloadFileName.getBytes());
        //设置写入结束的标记
        socket.shutdownOutput();

        //4.读取服务端返回的文件(字节数据)
        BufferedInputStream bis =
                new BufferedInputStream(socket.getInputStream());
        byte[] bytes = StreamUtils.streamToByteArray(bis);
        //5.得到一个输出流,准备将bytes写入到磁盘文件
        String filePath = "D:\\" + downloadFileName + "1.pdf";
        BufferedOutputStream bos =
                new BufferedOutputStream(new FileOutputStream(filePath));
        bos.write(bytes);

        //关闭相关资源
        bos.close();
        bis.close();
        socket.close();

        System.out.println("客户端下载完毕,客户端退出");
    }
}
