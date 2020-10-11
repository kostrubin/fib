import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket servSocket = new ServerSocket(65000);

        while (true) {

            try (Socket socket = servSocket.accept();
                 PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                String input;
                while ((input = in.readLine()) != null) {
                    if ("end".equals(input)) break;

                    int index = 0;

                    try {
                        index = Integer.parseInt(input);
                    } catch (NumberFormatException e) {
                        out.println("Пожалуйста, введите число");
                    }

                    int res = fib(index);

                    out.println("Запрашиваемое число: " + res);

                }
            } catch (IOException ex) {
                ex.printStackTrace(System.out);
            }
        }
    }

    private static int fib(int i) {
        if (i == 1) return 1;
        if (i == 2) return 1;
        return fib(i - 1) + fib(i - 2);
    }
}
