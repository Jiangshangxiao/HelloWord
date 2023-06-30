package com.JSXExercise.homework.homework31;

import com.JSXExercise.upload.StreamUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class HomeworkServer {
    public static void main(String[] args) throws Exception {
        //1.监听9999端口,等待客户端连接,并发送文件的名字
        ServerSocket serverSocket = new ServerSocket(9999);
        //2.等待客户端连接
        System.out.println("服务端再9999端口监听...");
        Socket socket = serverSocket.accept();
        //3.读取客户端发送的要下载的文件名
        InputStream inputStream = socket.getInputStream();
        byte[] b = new byte[1024];
        int len = 0;
        String downLoadFileName = "";
        while ((len = inputStream.read(b)) != -1) {
            downLoadFileName += new String(b, 0, len);
        }
        System.out.println("客户端希望下载的文件名 = " + downLoadFileName);

        String resFileName = "";
        if ("雇用契約書_採用内定通知書(姜上暁)2023_済み".equals(downLoadFileName)) {
            resFileName = "D:\\雇用契約書_採用内定通知書(姜上暁)2023_済み.pdf";
        } else {
            System.out.println("文件不存在");
        }

        //服务器上右两个文件
        //如果客户下载的是高山流水,我们就返回该文件,否则一律返回另外一个
        //4.创建一个输入流,读取文件
        BufferedInputStream bufferedInputStream =
                new BufferedInputStream(new FileInputStream(resFileName));
        //5.使用工具类StreamUtils,读取文件到一个字节数组
        byte[] bytes = StreamUtils.streamToByteArray(bufferedInputStream);

        //6.得到Socket关联的输出流
        BufferedOutputStream bos =
                new BufferedOutputStream(socket.getOutputStream());
        //7.写入到数据通道,返回给客户端
        bos.write(bytes);
        socket.shutdownOutput();

        //关闭相关资源
        bufferedInputStream.close();
        inputStream.close();
        socket.close();
        serverSocket.close();
        System.out.println("服务器端关闭");
    }
}
