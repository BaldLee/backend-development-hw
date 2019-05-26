package com.hw.task4.container;

import java.io.BufferedWriter;

import java.io.IOException;

import java.io.OutputStreamWriter;

import java.net.Socket;

public class container {
    public static void main(String[] args) {try {
        Socket socket = new Socket("127.0.0.1", 9999);           
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));   
               String str = "你好，这是我的第一个socket";       
           bufferedWriter.write(str);            //刷新输入流       
        //     bufferedWriter.flush();            //关闭socket的输出流     
        //       socket.shutdownOutput();   
        //     }catch (IOException e)
        // {e.printStackTrace();        }

    }
}
