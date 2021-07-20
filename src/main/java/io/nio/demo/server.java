package io.nio.demo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

//https://blog.csdn.net/tonywenxin1985/article/details/80515079
public class server {
    private static List<SocketChannel> socketChannelList = new LinkedList<>();
    public static void main(String[] args) throws IOException, InterruptedException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(512);
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress("127.0.0.1", 8088));
        serverSocketChannel.configureBlocking(false);//非阻塞
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();//非阻塞情况下会立即返回
            if (socketChannel != null) {
                System.out.println("get conn:" + socketChannel.getLocalAddress().toString());
                socketChannelList.add(socketChannel);
            } else {
                System.out.println("no conn");
            }
            for (SocketChannel channel : socketChannelList) {
                int read = channel.read(byteBuffer);
                byteBuffer.flip();//写转读
                if (read <= 0) {
                    System.out.println("no data");
                } else {
                    System.out.println("get data from:" + channel.getLocalAddress().toString() + " data:" + new String(byteBuffer.array()));
                }
            }
            Thread.sleep(1000);
        }
    }
}
