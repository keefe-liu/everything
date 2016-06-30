package practice.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author tingfang.liu
 * @since 2016-06-30
 */
public class SocketClient {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("127.0.0.1", 60000);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(
                    socket.getInputStream()));
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(System.in));
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream());
            printWriter.write("Hello Server!\n");
            printWriter.write(bufferedReader1.readLine());
            printWriter.write("Bye!\n");
            printWriter.flush();
            System.out.println(bufferedReader.readLine());

            printWriter.close();
            bufferedReader.close();
            bufferedReader1.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
