//package socketprogramming;

import java.io.IOException;
import java.net.UnknownHostException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.net.ServerSocket;

public class Server{
	public static void main(String[] args) throws IOException{
		ServerSocket s = new ServerSocket(8888);
		Socket mysocket = s.accept();
		Scanner s1 = new Scanner(mysocket.getInputStream());
		while(true){
		String number;
		number = s1.nextLine();
		System.out.println(number);
		//temp = number * 10;
		
		PrintStream ps = new PrintStream(mysocket.getOutputStream());
		ps.println("------------------Mensaje recibido-------------------------");
		}
	}
}