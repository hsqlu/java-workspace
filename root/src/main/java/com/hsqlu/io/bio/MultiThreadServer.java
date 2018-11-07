package com.hsqlu.io.bio;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
import java.util.concurrent.*;

public class MultiThreadServer {
    public static void main(String[] args) throws IOException {
        MultiThreadServer server = new MultiThreadServer();
        server.start();
    }

    private static ThreadFactory builder = new ThreadFactoryBuilder().setNameFormat("Demo Task Executor #%d").build();

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        Socket socket = null;
        ExecutorService executor = new ThreadPoolExecutor(5,
                20,
                10,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<>(1),
                builder);
        for (; ; ) {
            socket = serverSocket.accept();

            executor.execute(new TestHandler(socket));
            if (socket != null) {
                socket.close();
            }
        }
    }

    class TestHandler implements Runnable {
        private Socket socket;

        public TestHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(new Random().nextInt(100));
                socket.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread());
        }
    }

}
