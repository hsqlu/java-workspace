package com.hsqlu.io.bio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.util.Random;

public class Handler implements Runnable {
    private Socket socket;
    private Random random = new Random();
    private int busyTime;

    public Handler(Socket socket) {
        this.socket = socket;
        busyTime = random.nextInt(10);
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread());
        try {
            process(socket.getInputStream(), socket.getOutputStream());
            socket.close();
            Thread.sleep(busyTime);
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    private void process(InputStream input, OutputStream output) throws IOException {

        int size = input.available();
        byte[] buffer = new byte[size];
        input.read(buffer);
//            System.out.println(new String(buffer));
        byte[] response = ("HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<html><b>Hello</b></html>"
                + new String(buffer)).getBytes();
//            PrintWriter writer = new PrintWriter(output, true);
            output.write(response);
            output.flush();
    }
}