package com.JSXExercise.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws IOException {
        //1.连接服务端(ip, 端口)
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客户端 socket返回 = " + socket.getClass());
        //2.连接上后,生成Socket,通过socket.getOutputStream()
        //得到和socket对象关联的输出流对象
        OutputStream outputStream = socket.getOutputStream();
        //3.通过输出流,写入数据到数据通道
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello, server 字符流");
        bufferedWriter.newLine(); //插入一个换行符,表示写入的内容结束
        bufferedWriter.flush(); //如果使用的是字符流,需要手动刷新,否则数据不会写入数据通道,要求对方使用readLine()
        //设置结束标志
        socket.shutdownOutput();
        //4.获取socket关联的输入流,读取数据,并显示
        InputStream inputStream = socket.getInputStream();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //5.关闭流对象和socket
        bufferedWriter.close();
        bufferedReader.close();
        socket.close();
        System.out.println("客户端退出");
    }
}