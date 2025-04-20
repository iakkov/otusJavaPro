package ru.project.web;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private int port;
    private boolean shutdown = false;

    public HttpServer(int port) {
        this.port = port;
    }

    public void await() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Сервер запущен на порту " + port);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        while (!shutdown) {
            try (Socket socket = serverSocket.accept();
                 InputStream input = socket.getInputStream();
                 OutputStream output = socket.getOutputStream()){
                System.out.println("Получен входящий запрос");
                byte[] buffer = new byte[4096];
                while (true) {
                    int n = socket.getInputStream().read(buffer);
                    String message = new String(buffer, 0, n);
                    System.out.print(message);
                    if (message.equals("/shutdown")) {
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        HttpServer httpServer = new HttpServer(8189);
        try {
            httpServer.await();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}