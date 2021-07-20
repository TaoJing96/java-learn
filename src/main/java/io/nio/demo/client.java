package io.nio.demo;

import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8088);
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String next = scanner.next();
            System.out.println("send:" + next);
            socket.getOutputStream().write(next.getBytes());
        }
    }
}
