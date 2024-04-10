//Name: Ryan Tran

import java.io.*;
import java.net.*;

public class Tran_ReverseEchoServer {

    public static void main(String[] args) throws IOException {
        int portNumber = 5000; // Port number for the server

        try (ServerSocket serverSocket = new ServerSocket(portNumber)) {
            System.out.println("Server is listening on port " + portNumber);

            while (true) {
                Socket clientSocket = serverSocket.accept(); // Wait for a client connection
                System.out.println("Client connected from: " + clientSocket.getInetAddress().getHostName());

                new Thread(new ClientHandler(clientSocket)).start(); // Handle each client in a separate thread
            }
        }
    }
}

class ClientHandler implements Runnable {

    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

            String message;

            while ((message = in.readLine()) != null) {
                if (message.equalsIgnoreCase("end")) {
                    out.println("dne"); // Send termination message
                    break;
                }

                String reversedMessage = new StringBuilder(message).reverse().toString();
                out.println(reversedMessage); // Send reversed message back
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
