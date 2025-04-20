package ru.project.web;

import java.io.IOException;
import java.io.InputStream;

public class Request {
    private InputStream input;
    private String uri;

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
            uri = parseUri(requestString);
            System.out.println(requestString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String parseUri(String requestUri) {
        int index1, index2;
        index1 = requestUri.indexOf(' ');
        if (index1 != -1) {
            index2 = requestUri.indexOf(' ', index1 + 1);
            if (index2 > index1) {
                return requestUri.substring(index1 + 1, index2);
            }
        }
        return null;
    }

    public String getUri() {
        return uri;
    }
}
