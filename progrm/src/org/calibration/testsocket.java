package org.calibration;
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
    UserInterface UI = new UserInterface(socket);
    UI.setVisible(true);
    /*fenetre f = new fenetre(socket);
    f.setVisible(true);*/
    /*Calibration  m = new Calibration (socket);
    m.run();*/
    //VerificationCadre  v = new VerificationCadre (socket);
    //v.run(); 
    
    
    
    
    //fenetreCalibration f1 = new fenetreCalibration();
	//CalibrationScreen cs = new CalibrationScreen(640, 512);
	//f1.add(cs);
	//f1.cs.removeAll();
	//m.sleep(5000);
    //f1.getComponent(0).hide();
    //CalibrationScreen c = new CalibrationScreen(64, 51);
	//f1.add(c);
    //f1.cs.setPosXY(64, 51);
    //f1.show();
    //f1.setVisible(true);
    
    
	
 		
 }


 

}	
