package exercise.thread;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import static java.lang.System.out;

/**
 * Created by tingfang.liu on 2016/4/12.
 */
public class PipeStreamConnection {

    private static class ReadData {
        public void read(PipedInputStream pipedInputStream) {
            out.println("start read ");
            byte[] bytes = new byte[20];
            try {
                int read = pipedInputStream.read(bytes);
                while (read != -1) {
                    String data = new String(bytes, 0, read);
                    out.print(data + " ");
                    read = pipedInputStream.read(bytes);
                }
                out.println("end read ");
                pipedInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static class WriteData {
        public void write(PipedOutputStream pipedOutputStream) {
            out.println("start write ");
            try {
                for (int i = 0; i < 300; i++) {
                    String data = "" + (i + 1);
                    pipedOutputStream.write(data.getBytes());
                    out.print(data + " ");
                }
                out.println("end write ");
                pipedOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        PipedInputStream pipedInputStream = new PipedInputStream();
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        // pipedInputStream.connect(pipedOutputStream);
        pipedOutputStream.connect(pipedInputStream);
        Thread readThread = new Thread(() -> {
            new ReadData().read(pipedInputStream);
        });
        Thread writeThread = new Thread(() -> {
            new WriteData().write(pipedOutputStream);
        });
        writeThread.start();
        Thread.sleep(100);
        readThread.start();
    }
}
