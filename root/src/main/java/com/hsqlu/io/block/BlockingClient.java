package com.hsqlu.io.block;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.net.Socket;

public class BlockingClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket();
        socket.connect(new InetSocketAddress(8080));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        writer.write("GET / HTTP/1.1\r\n");
        writer.write("Host: localhost:8080");
        writer.write("Connection: keep-alive");
        writer.write("Upgrade-Insecure-Requests: 1");
        writer.flush();
        socket.close();
    }
}
