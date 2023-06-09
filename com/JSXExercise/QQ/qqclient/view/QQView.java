package com.JSXExercise.QQ.qqclient.view;

import com.JSXExercise.QQ.qqclient.service.FileClientService;
import com.JSXExercise.QQ.qqclient.service.MessageClientService;
import com.JSXExercise.QQ.qqclient.service.UserClientService;
import com.JSXExercise.QQ.qqserver.Utility.Utility;

/**
 * @author 姜上晓
 * @version 1.0
 * 客户端的菜单界面
 */
public class QQView {

    private boolean loop = true; //控制是否显示菜单
    private String key = ""; //接受用户的键盘输入
    //对象是用于登录服务/注册用户
    private UserClientService userClientService = new UserClientService(); //对象用于登陆服务/注册用户服务
    private MessageClientService messageClientService = new MessageClientService(); //对象用于用户私聊/群发消息
    private FileClientService fileClientService = new FileClientService(); //用于传输文件

    public static void main(String[] args) {
        new QQView().mainMenu();
        System.out.println("客户端退出系统");
    }
    //显示主菜单
    private void mainMenu() {
        while (loop) {
            System.out.println("======欢迎登录网络通信系统======");
            System.out.println("\t\t 1 登录系统");
            System.out.println("\t\t 2 退出系统");
            System.out.print("请输入你的选择: ");

            key = Utility.readString(1);

            //根据用户的输入,来处理不同的逻辑
            switch (key) {
                case "1":
                    System.out.print("请输入用户号: ");
                    String userId = Utility.readString(50);
                    System.out.print("请输入密码: ");
                    String pwd = Utility.readString(50);
                    if (UserClientService.checkUser(userId, pwd)) {
                        System.out.println("======欢迎(用户" + userId + "登陆成功)======");
                        //进入二级菜单
                        while (loop) {
                            System.out.println("\n==========网络通信系统二级菜单(用户" + userId + ")==========");
                            System.out.println("\t\t 1 显示在线用户列表");
                            System.out.println("\t\t 2 群发消息");
                            System.out.println("\t\t 3 私聊消息");
                            System.out.println("\t\t 4 发送文件");
                            System.out.println("\t\t 9 退出系统");
                            System.out.print("请输入你的选择: ");
                            key = Utility.readString(1);
                            switch (key) {
                                case "1":
                                    UserClientService.onLineFriendList();
                                    break;
                                case "2":
                                    System.out.println("请输入相对大家说的话: ");
                                    String s = Utility.readString(100);
                                    //调用一个方法,将消息封装成message对象,发送给服务端
                                    messageClientService.sendMessageTOAll(s, userId);
                                    break;
                                case "3":
                                    System.out.println("请输入想聊天的用户号(在线): ");
                                    String getterId = Utility.readString(50);
                                    System.out.println("请输入想发送给对方的消息: ");
                                    String content = Utility.readString(100);
                                    //编写一个方法,将消息发送给服务端
                                    messageClientService.sendMessageToOne(content, userId, getterId);
                                    break;
                                case "4":
                                    System.out.println("请输入你想把文件发送给哪个用户(在线用户): ");
                                    getterId = Utility.readString(50);
                                    System.out.println("请输入发送文件的路径(例如 D:\\xx.jpg)");
                                    String src = Utility.readString(100);
                                    System.out.println("请输入把文件发送到对方相应的路径(例如 D:\\yy.jpg)");
                                    String dest = Utility.readString(100);
                                    fileClientService.sendFileToOne(src, dest, userId, getterId);
                                    break;
                                case "9":
                                    UserClientService.logout();
                                    loop = false;
                                    break;
                            }
                        }
                    } else {
                        System.out.println("用户名或密码错误,登录失败");
                    }
                    break;
                case "9":
                    loop = false;
                    break;
            }
        }
    }
}
