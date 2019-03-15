import java.net.*;
import java.util.*;
import java.io.*;

class server{
	public static void main(String args[]) throws Exception{
		int count=1;
		System.out.println("Server is Running........");
		ServerSocket ss = new ServerSocket(7878);
		while(true){
			new RevThread(ss.accept(),count).start();
			System.out.println(count+"Client Connected");
			count++;
		}
	}
}

class RevThread extends Thread{
	Socket s = null;
	int n;
	public RevThread(Socket socket,int count){
		s = socket;
		n = count;
		
	}
	public void run(){
		try{
			while(true){
				System.out.println("receiving from client");
				DataInputStream din = new DataInputStream(s.getInputStream());
				int value1 = din.readInt();
				int value2 = din.readInt();
				System.out.println("Processing from client" +n);
				int add=0,sub=0,mul=0,div=0,mod=0;
				add = value1 + value2;
				sub = value1 - value2;
				mul = value1 * value2;
				div = value1 / value2;
				mod = value1 % value2;
				System.out.println("Sending to client:" +n);
				DataOutputStream dout = new DataOutputStream(s.getOutputStream());
				dout.writeInt(add);
				dout.writeInt(sub);
				dout.writeInt(mul);
				dout.writeInt(div);
				dout.writeInt(mod);
			}
		}
		catch(IOException e){
			System.out.println(e);
		}
	}
}