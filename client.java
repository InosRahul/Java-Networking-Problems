import java.net.*;
import java.io.*;

class client{
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket ds = new DatagramSocket();
		
		InetAddress add = InetAddress.getByName("localhost");
		
		byte[] sendData = new byte[1024];
		byte[] receiveData = new byte[1024];
		String sentence = br.readLine();
		sendData = sentence.getBytes();
		
		DatagramPacket dp = new DatagramPacket(sendData,sendData.length,add,3000);
		ds.send(dp);
		
		DatagramPacket rs = new DatagramPacket(receiveData,receiveData.length);
		ds.receive(rs);
		String newSent = new String(rs.getData());
		System.out.println("From server:" +newSent);
		ds.close();
	}
}