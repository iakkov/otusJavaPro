package ru.project.web;

import java.io.IOException;
import java.io.InputStream;

public class Request {
    private InputStream input;

    public Request(InputStream input) {
        this.input = input;
    }

    public void parse() {
        try {
            StringBuilder sb = new StringBuilder(4096);
            int n;
            byte[] buffer = new byte[4096];
            try {
                n = input.read(buffer);
            } catch (IOException e) {
                e.printStackTrace();
                n = -1;
            }
            for (int i = 0; i < n; i++) {
                sb.append((char) buffer[i]);
            }
            String requestString = sb.toString();
            System.out.println(requestString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
