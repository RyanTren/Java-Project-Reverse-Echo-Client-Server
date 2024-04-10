### Java Project Reverse Echo Client/Server

# Description of Project:
I developed an echo client that receives user messages and forwards them to the associated reverse echo server. The message is shown to the users when the server sends the reversed message. The user types "end" to the client in order to terminate the client program. The client waits for the server to send the message "dne" after sending the message to the reverse echo server. The client terminates itself by displaying the message "dne" if it receives it.

# Server:
⦁	Listens on a specific port number (default 5000). 
⦁	Accepts incoming client connections. 
⦁	Creates a separate thread for each client to handle them concurrently. 
⦁	Reads messages from the client. 
⦁	Checks for the termination message "end". 
⦁	If received, sends "dne" and closes the connection. 
⦁	Reverses the received message. 
⦁	Sends the reversed message back to the client. 

# Client: 
⦁	Connects to the server hostname and port number. 
⦁	Reads user input from the console. 
⦁	Sends the user input to the server. 
⦁	Receives the server's response (reversed message). 
⦁	Displays the server's response. 
⦁	Checks for the termination message "dne". 
⦁	If received, closes the connection.


# Link for the Video Demonstration: https://youtu.be/FDfhWM94wpc
