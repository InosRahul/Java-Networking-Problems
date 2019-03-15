import java.net.*;
import java.io.*;
import java.util.*;

class client{
	public static void main(String args[]) throws Exception{
		Socket s = new Socket("127.0.0.1",7878);
		if(s.isConnected()){
			System.out.println("Connected to Server....");
		}
		while(true){
			System.out.println("Enter 2 Values to calculate");
			DataInputStream din = new DataInputStream(s.getInputStream());
			Scanner scan = new Scanner(System.in);
			int value1 = scan.nextInt();
			int value2 = scan.nextInt();
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeInt(value1);
			dout.writeInt(value2);
			int add=0,sub=0,mul=0,div=0,mod=0;
			add = din.readInt();
			sub = din.readInt();
			mul = din.readInt();
			div = din.readInt();
			mod = din.readInt();
			System.out.println("Addition is:" +add);
			System.out.println("Sutraction is:" +sub);
			System.out.println("Multilication is:" +mul);
			System.out.println("Division is:" +div);
			System.out.println("Modulo is:" +mod);
		}
	}
}