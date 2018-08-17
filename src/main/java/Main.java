import java.io.*;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File( "1" );
        File file2 = new File( "C:/Users/roma/Desktop/Java/lesson3/1", "text.txt" );
        Task3 test = new Task3("1/task3");


        try (FileInputStream in = new FileInputStream("1/text.txt")) {
            byte[] arr = new byte[512];
            int x;
            while ((x = in.read(arr)) != -1) {
                System.out.println(new String(arr, 0, x));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<InputStream> ali = new ArrayList<>();
        ali.add(new FileInputStream("1/2"));
        ali.add(new FileInputStream("1/3"));
        ali.add(new FileInputStream("1/4"));
        ali.add(new FileInputStream("1/5"));
        ali.add(new FileInputStream("1/text.txt"));

        SequenceInputStream in = new SequenceInputStream( Collections.enumeration(ali));
        int x;
        while ((x = in.read()) != - 1) {
            System.out.print((char)x);
        }
        in.close();

    }
}
