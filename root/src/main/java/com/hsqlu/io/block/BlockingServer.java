package com.hsqlu.io.block;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
//import java.net.SocketAddress;

public class BlockingServer {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress(8080));
        do {
            Socket socket = serverSocket.accept();
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            while (true){
                String readLine = reader.readLine();
                if (readLine != null)
                    System.out.println(readLine);
                else
                    break;
            }
            PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
            writer.println("--");
//            writer.flush();
            break;
        } while (true);
    }
}
