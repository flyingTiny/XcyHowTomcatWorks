package ex01.pyrmont;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNext()) {
                String fileName = scanner.next();
                Socket socket = new Socket("127.0.0.1", 8080);
                OutputStream os = socket.getOutputStream();
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out.println("GET " + fileName + " HTTP/1.1");
                StringBuffer sb = new StringBuffer(8096);
                boolean loop = true;
                while (loop) {
                    if (in.ready()) {
                        System.out.println("in ready");
                        int i = 0;
                        while (i != -1) {
                            i = in.read();
                            sb.append((char) i);
                        }
                        loop = false;
                    }
                    Thread.currentThread().sleep(50);
                }
                System.out.println(sb.toString());
            }
        }
    }
}
