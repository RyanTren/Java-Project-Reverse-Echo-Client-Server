//Name: Ryan Tran

import java.io.*;
import java.net.*;

public class Tran_EchoClient {

    public static void main(String[] args) throws IOException {
        String hostname = "localHost"; // Server hostname (replace with actual server hostname if running on different machines)
        int portNumber = 5000; // Port number to connect to

        System.out.println("[Ryan Tran | Using Reverse Echo Server & Client]");
        System.out.print("Enter input: ");

        try (Socket clientSocket = new Socket(hostname, portNumber);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {

            String message;

            while ((message = stdIn.readLine()) != null) {
                out.println(message); // Send message to server

                String response = in.readLine();
                System.out.println("Server: " + response); // Display server response

                System.out.print("Enter input: ");

                if (response.equalsIgnoreCase("dne")) {
                    break;
                }
            }
        }
    }
}
