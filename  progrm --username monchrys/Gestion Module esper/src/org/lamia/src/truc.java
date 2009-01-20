package org.lamia.src;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;


public class truc extends Thread{

	DatagramPacket dataRecieved;
	private DatagramSocket socket;
	private byte[] buff = new byte[2000];
	
	public truc() {
		try {
			socket = new DatagramSocket(5555,InetAddress.getByName("192.168.0.1"));
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		dataRecieved = new DatagramPacket(buff,2000);
}
	

	
        public void run(){
        while(true){
                try {
                	//System.out.println("avant" + socket.getLocalPort() + "  |  " + socket.getInetAddress() + " <" + socket.getRemoteSocketAddress() + " >");
                	socket.receive(dataRecieved);
                        System.out.println(dataRecieved.toString());
                        sleep(2000);
                        } catch ( Exception e) { e.printStackTrace(); }
                        }
    }
 
  

}


