package com.JSXExercise.QQ.qqclient.service;

import com.JSXExercise.QQ.qqcommon.Message;
import com.JSXExercise.QQ.qqcommon.MessageType;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 姜上晓
 * @version 1.0
 * 该类/对象,提供和消息相关的服务方法
 */
public class MessageClientService {

    /**
     *
     * @param content 内容
     * @param senderId 发送者
     */
    public void sendMessageTOAll(String content, String senderId) {
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_TO_ALL_MES);
        message.setSender(senderId);
        message.setContent(content);
        message.setSendTime(new java.util.Date().toString()); //设置message的发送时间
        System.out.println(senderId + " 对大家说: " + content);
        //发送个服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param content 发送的内容
     * @param senderId 发送用户id
     * @param getterId 接受用户id
     */
    public void sendMessageToOne(String content, String senderId, String getterId) {
        //构建message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_COMM_MES);
        message.setSender(senderId);
        message.setGetter(getterId);
        message.setContent(content);
        message.setSendTime(new java.util.Date().toString()); //设置message的发送时间
        System.out.println(senderId + " 对 " + getterId + " 说 " + content);
        //发送个服务端
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
