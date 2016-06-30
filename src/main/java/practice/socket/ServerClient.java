package practice.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author tingfang.liu
 * @since 2016-06-30
 */
public class ServerClient {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(60000);
            while (true) {
                Socket socket = serverSocket.accept();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                String str;
                StringBuilder msg = new StringBuilder();
                while ((str = bufferedReader.readLine()) != null) {
                    System.out.println(str);
                    msg.append(str);
                }
                System.out.println("Receive msg : " + msg.toString());
                PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
                printWriter.write("我收到了!");
                printWriter.flush();

                printWriter.close();
                bufferedReader.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
