package com.JSXExercise.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 姜上晓
 * @version 1.0
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {
        //1.在本机的9999端口监听,等待连接
        //要求在本机没有其他服务在监听9999
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("服务端,在9999端口监听,等待连接...");
        //2.当没有客户端连接9999端口时,程序会阻塞,等待连接
        //如果右客户端连接,则会返回Socket对象,程序继续
        Socket socket = serverSocket.accept();

        System.out.println("服务端,socket = " + socket.getClass());
        //3.通过socket.getInputStream() 读取客户端写入到数据通道和数据
        InputStream inputStream = socket.getInputStream();
        //4.IO读取
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String s = bufferedReader.readLine();
        System.out.println(s);
        //4.获取socket相关联的输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream));
        bufferedWriter.write("hello client 字符流");
        bufferedWriter.newLine(); //插入一个换行符,表示回复内容结束
        bufferedWriter.flush(); //手动flush
        socket.shutdownOutput();
        //关闭流和socket
        bufferedReader.close();
        bufferedWriter.close();
        socket.close();
        serverSocket.close();
    }
}
