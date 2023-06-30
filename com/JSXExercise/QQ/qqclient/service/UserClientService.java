package com.JSXExercise.QQ.qqclient.service;

import com.JSXExercise.QQ.qqcommon.Message;
import com.JSXExercise.QQ.qqcommon.MessageType;
import com.JSXExercise.QQ.qqcommon.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author 姜上晓
 * @version 1.0
 * 该类完成用户登录验证和用户注册等功能
 */
public class UserClientService {

    //因为可能再其他地方使用user信息,因此做成成员属性
    private static User u = new User();
    //因为Socket再其他地方也可能使用,因此做成属性
    private static Socket socket;
    //根据userId和pwd到服务器验证该用户是否合法
    public static boolean checkUser(String userId, String pwd) {
        boolean b = false;
        //创建User对象
        u.setUserId(userId);
        u.setPasswd(pwd);
        try {
            //链接到服务端,发送u对象
            socket = new Socket(InetAddress.getByName("127.0.0.1"), 9999);
            ObjectOutputStream oos =
                    new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u); //发送User对象

            //读取从服务器回复的Message对象
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms =(Message) ois.readObject();
            if (ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)) { //登录ok



                //创建一个和服务器端保持通信的线程 -> 创建一个类 ClientConnectServiceThread
                ClientConnectServerThread clientConnectServerThread =
                        new ClientConnectServerThread(socket);
                //启动客户端线程
                clientConnectServerThread.start();
                //为了后面客户端的扩展,将线程放入到集合中管理
                ManageClientConnectServerThread.addClientConnectServerThread(userId, clientConnectServerThread);

                b = true;

            } else {
                //如果登录失败,就不能启动和服务器通信的线程,关闭socket
                socket.close();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return b;
    }

    //向服务器端请求在线用户列表
    public static void onLineFriendList() {

        //发送一Message, 类型MESSAGE_GET_ONLINE_FRIEND
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_GET_ONLINE_FRIEND);
        message.setSender(u.getUserId());
        //发送给服务器
        //先得到当前线程的Socket对应的ObjectOutputStream对象
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(u.getUserId()).getSocket().getOutputStream());
            oos.writeObject(message); //发送一个Message对象,向服务器端要求在线好友列表
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //编写方法,退出客户端,并给服务端发送一个退出系统的message对象
    public static void logout() {
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
        message.setSender(u.getUserId()); //指定是哪个客户端

        //发送message
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(message);
            System.out.println(u.getUserId() + " 退出系统");
            System.exit(0); //结束进程
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
