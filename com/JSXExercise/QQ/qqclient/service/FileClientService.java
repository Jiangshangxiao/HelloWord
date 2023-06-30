package com.JSXExercise.QQ.qqclient.service;

import com.JSXExercise.QQ.qqcommon.Message;
import com.JSXExercise.QQ.qqcommon.MessageType;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author 姜上晓
 * @version 1.0
 * 该类/对象完成文件传输服务
 */
public class FileClientService {
    /**
     *
     * @param src 源文件
     * @param dest 把该文件传输到对方的哪个目录
     * @param sendId 发送用户id
     * @param getterId 接受用户id
     */
    public void sendFileToOne(String src, String dest, String sendId, String getterId) {
        //读取src文件 --> message
        Message message = new Message();
        message.setMesType(MessageType.MESSAGE_FILE_MES);
        message.setSender(sendId);
        message.setGetter(getterId);
        message.setSrc(src);
        message.setDest(dest);

        //将文件进行读取
        FileInputStream fileInputStream = null;
        byte[] fileBytes = new byte[(int) new File(src).length()];

        try {
            fileInputStream = new FileInputStream(src);
            fileInputStream.read(fileBytes); //将src文件读入到程序的字节数组
            //将文件对应的字节数组设置message
            message.setFileBytes(fileBytes);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            //关闭
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        //提示信息
        System.out.println("\n" + sendId + "给" + getterId + " 发送文件: " + src
                + " 到对方的电脑目录" + dest);

        //发送
        try {
            ObjectOutputStream oos =
                    new ObjectOutputStream(ManageClientConnectServerThread.getClientConnectServerThread(sendId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
