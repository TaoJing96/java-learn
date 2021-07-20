package io.bio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.List;

public class server {
    private static List<Socket> socketList = new LinkedList<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket socket = new ServerSocket();
        socket.bind(new InetSocketAddress("127.0.0.1", 8088));
        byte[] bytes = new byte[512];
        System.out.println("server start...");
        while (true) {
            Socket accept = socket.accept();//阻塞 只有打你个一个client来连接才会读取数据
            if (accept == null) {
                System.out.println("no conn");
                Thread.sleep(1000);
            } else {
                System.out.println("get conn:" + accept.getLocalAddress().toString());
                socketList.add(accept);
            }
            //遍历socketList
            for (Socket socket1 : socketList) {
                int read = socket1.getInputStream().read(bytes);//阻塞
                if (read <= 0) {
                    System.out.println("no data");
                } else {
                    System.out.println("get data from:" + socket1.getLocalAddress().toString() + " data:" + new String(bytes));
                }
            }
        }
    }
}
