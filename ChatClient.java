package chatSocket;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		// TODO Auto-generated method stub
		Socket Csocket = new Socket("localhost", 9999);
		
		DataInputStream in = new DataInputStream(Csocket.getInputStream());
		DataOutputStream ou = new DataOutputStream(Csocket.getOutputStream());
		
		Scanner  scan = new Scanner(System.in);
		
		while(true) {
			String str = scan.nextLine();
			ou.writeUTF(str);
			ou.flush();
			if(str.equals("exit")) {
				break;
			}
			String str2 = in.readUTF();
			System.out.println("Server : " + str2);
		}
		
		in.close();
		ou.close();
		Csocket.close();
	}

}
