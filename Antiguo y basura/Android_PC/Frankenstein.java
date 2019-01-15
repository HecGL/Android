//package socketprogramming;

import java.io.IOException;
import java.net.UnknownHostException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.MouseInfo;
import java.io.IOException;
import java.awt.Point;
import java.net.ServerSocket;
import java.io.BufferedReader;
import java.io.Reader;

import java.awt.AWTException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetSocketAddress;


public class Frankenstein {
    private static boolean isConnected = true;
    private static String line;
    private static BufferedReader in = null;
    private static Robot robot;
	private static ServerSocket s = null;
	private static Socket client = null;


    public static void main(String[] args) throws IOException{
      boolean leftpressed = false;
      boolean rightpressed = false;

	  try{
	    	robot = new Robot();
			s = new ServerSocket(8888);
			client = s.accept();
			Scanner s1 = new Scanner(client.getInputStream());
			in = new BufferedReader(new InputStreamReader(client.getInputStream())); //the input stream where data will come from client
		}catch (IOException e) {
			System.out.println("Error in opening Socket");
			System.exit(-1);
		}catch (AWTException e) {
			System.out.println("Error in creating robot instance");
			System.exit(-1);
		}
	  
      while (isConnected) {
        line = in.readLine();
        PrintStream ps = new PrintStream(client.getOutputStream());

        try {
		  line = in.readLine(); //read input from client
          System.out.print("Acabo de recibir: ");
          System.out.println(line); //print whatever we get from client
          in = new BufferedReader(new InputStreamReader(client.getInputStream())); //the input stream where data will come from client

          //if user clicks on next
          if (line.equalsIgnoreCase("next")) {
            //Simulate press and release of key 'n'
            robot.keyPress(KeyEvent.VK_N);
            robot.keyRelease(KeyEvent.VK_N);
          }
          //if user clicks on previous
          else if (line.equalsIgnoreCase("previous")) {
            //Simulate press and release of key 'p'
            robot.keyPress(KeyEvent.VK_P);
            robot.keyRelease(KeyEvent.VK_P);
          }
          //if user clicks on play/pause
          else if (line.equalsIgnoreCase("play")) {
            //Simulate press and release of spacebar
            robot.keyPress(KeyEvent.VK_SPACE);
            robot.keyRelease(KeyEvent.VK_SPACE);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_C);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			
          }
          //input will come in x,y format if user moves mouse on mousepad
          else if (line.contains(",")) {
            float movex = Float.parseFloat(line.split(",")[0]); //extract movement in x direction
            float movey = Float.parseFloat(line.split(",")[1]); //extract movement in y direction
            Point point = MouseInfo.getPointerInfo().getLocation(); //Get current mouse position
            float nowx = point.x;
            float nowy = point.y;
            robot.mouseMove((int)(nowx + movex), (int)(nowy + movey)); //Move mouse pointer to new location
          }
          //if user taps on mousepad to simulate a left click
          else if (line.contains("left_click")) {
            //Simulate press and release of mouse button 1(makes sure correct button is pressed based on user's dexterity)
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
          }
          //Exit if user ends the connection
          else if (line.equalsIgnoreCase("exit")) {
            //isConnected = false;
            //Close server and client socket
			robot.keyPress(KeyEvent.VK_F1);
			robot.keyRelease(KeyEvent.VK_F1);
          }
		  else if (line.equalsIgnoreCase("Adios")||line.equalsIgnoreCase("adios")) {
            isConnected = false;
            //Close server and client socket
            s.close();
            client.close();
          }
        }   catch (IOException e) {
          System.out.println("Read failed");
          System.exit(-1);
        }
		finally {
			System.out.println("Mu bien");
			if(line.equalsIgnoreCase("Adios")){
			System.out.println("Ta luego");
			System.exit(0);
			}
		}
	  }
    }
}