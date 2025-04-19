package ru.project.web;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = serverSocket.accept();

        byte[] buffer = new byte[4096];
        while(true) {
            int n = socket.getInputStream().read(buffer);
            String message = new String(buffer, 0, n);
            System.out.print(message);
            if (message.equals("/shutdown")) {
                break;
            }
        }
            socket.close();
            serverSocket.close();
        }
    }