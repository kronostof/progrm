package org.lamia.src;
import java.net.InetAddress;

public class testsocket
{
  final static int taille = 1024;
  static byte buffer[] = new byte[taille];
  static	int length; //= a.length();
  static InetAddress serveur;   

 public static void main(String argv[]) throws Exception
 {
	 
    OuvrirSocket socket = new OuvrirSocket();
    fenetre f = new fenetre(socket);
    f.setVisible(true);
   /// RecevoirData  m = new RecevoirData (socket);

 		
 }


 

}	
