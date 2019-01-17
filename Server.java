import java.net.*;
import java.io.*;

public class Server {
    public static void main(String[] args) throws IOException, InterruptedException {

        ServerSocket serverSocket = new ServerSocket(8000);
        int count = 0;


        while(true) {
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client Accepted " + (++count));

            BufferedWriter writer =
                new BufferedWriter(new OutputStreamWriter(
                        clientSocket.getOutputStream()));

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        clientSocket.getInputStream()));

            String request = reader.readLine();
            Thread.sleep(3000);

            System.out.println(request);
            String response = count + ". Your message length is " +
                    request.length() + "\n";

            writer.write(response);
            writer.flush();

            writer.close();
            reader.close();
            clientSocket.close();
        }


    }
}
