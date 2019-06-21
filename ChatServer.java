package chatSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ChatServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ServerSocket ss = new ServerSocket(9999);
		
		Socket socket = ss.accept();
		DataInputStream dis =new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			String str = dis.readUTF();
			if (str.equals("exit")) {
				break;
			}
			System.out.println("Client : " + str);
			
			String str2 = scan.nextLine();
			dos.writeUTF(str2);
			dos.flush();
		}
	}

}
