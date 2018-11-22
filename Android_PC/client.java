//javac MyClass.java -source 1.7 -target 1.7

//package socketprogramming;
import java.io.IOException;
import java.net.UnknownHostException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class client{
	private static boolean isConnected=true;
	
	public static void main (String[] args) throws UnknownHostException, IOException{
		//here we will do client side programming.
		//lets create a socket first
		Socket mysocket = new Socket("10.151.192.89", 8888);
		Scanner myinput = new Scanner(System.in); //for input
		while(isConnected){
		String number =new String("Hola");
		System.out.println("Input text");
		number = myinput.nextLine(); //input number will be saved to number variable
		
		Scanner sc1 = new Scanner(mysocket.getInputStream()); 
		PrintStream ps = new PrintStream(mysocket.getOutputStream());
		ps.println(number);
		ps.println(number);
		//String temp = new String("Hola");
		//temp = sc1.nextLine();
		//System.out.println(temp);
		}
	}
}