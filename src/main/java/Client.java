import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("127.0.0.1", 65000);
         try (BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
              PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
              Scanner scanner = new Scanner(System.in)) {
             String input;

             while (true) {
                 System.out.println("Введите индекс числа Фибоначчи...");
                 input = scanner.nextLine();

                 if ("end".equals(input)) break;

                 out.println(input);
                 System.out.println("SERVER: " + in.readLine());
             }
         } catch (IOException e) {
             e.printStackTrace();
         }
    }
}
