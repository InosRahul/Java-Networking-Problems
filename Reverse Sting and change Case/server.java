import java.net.*;
import java.io.*;

class Server{
	public static void main(String args[]) throws Exception{
		DatagramSocket ds = new DatagramSocket(3000);
		byte[] receiveData = new byte[1024];
		byte[] sendData = new byte[1024];
		while(true){
			DatagramPacket dp = new DatagramPacket(receiveData,receiveData.length);
			ds.receive(dp);
			String sent = new String(dp.getData());
			System.out.println("Sentence :s" +sent);
			InetAddress add = dp.getAddress();
			int port = dp.getPort();
			StringBuilder sb = new StringBuilder(sent);
			for(int i=0;i<sb.length();i++){
				char c = sb.charAt(i);
				if(Character.isLowerCase(c)){
					sb.setCharAt(i,Character.toUpperCase(c));
				}
				else{
					sb.setCharAt(i,Character.toLowerCase(c));
				}
			}
			String capt = sb.reverse().toString();
			sendData = capt.getBytes();
			DatagramPacket sp = new DatagramPacket(sendData,sendData.length,add,port);
			ds.send(sp);
		}
	}
}