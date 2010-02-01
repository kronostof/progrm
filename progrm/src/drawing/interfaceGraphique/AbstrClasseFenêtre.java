///*
// * To change this template, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package drawing.interfaceGraphique;
//
//import java.awt.Dimension;
//import java.awt.GraphicsConfiguration;
//import java.awt.Insets;
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import javax.swing.*;
//import javax.swing.JFrame;
////import logo2.controleur.Controler;
////import logo2.vue.FeuilleDessin;
////import logo2.vue.frame.InterfFenêtre;
//
//
//
///**
// *
// * @author chris
// */
//public abstract class AbstrClasseFenêtre extends JFrame implements ActionListener{
//
//    static GraphicsConfiguration gc;
//
//    public ArrayList<FeuilleDessin> listeDeFeuille = null;
//
//    public static ArrayList<AbstrClasseFenêtre> listeDeFenetre = new ArrayList<AbstrClasseFenêtre>(5);
//
//
//    String id,nom;
//    Dimension dimension;
//
//
//    public AbstrClasseFenêtre() {
//        listeDeFeuille = new ArrayList<FeuilleDessin>(2);
//    }
//
//    public void signalScoreDesEquipe() {
//        System.out.println("flatch");//throw new UnsupportedOperationException("Not yet implemented");
//    }
//
//
//
//    void addButton(JComponent p, String name, String tooltiptext, String imageName) {
//	  JButton b;
//	  if ((imageName == null) || (imageName.equals(""))) {
//              b = (JButton) p.add(new JButton(name));
//	  }
//	  else {
//		   java.net.URL u = this.getClass().getResource(imageName);
//	       if (u != null){
//			  ImageIcon im = new ImageIcon (u);
//
//			  b = (JButton) p.add(new JButton(im));
//		   } else
//				  b = (JButton) p.add(new JButton(name));
//		   b.setActionCommand(name);
//	  }
//      	  b.setToolTipText(tooltiptext);
//	  b.setBorder(BorderFactory.createRaisedBevelBorder());
//	  b.setMargin(new Insets(0,0,0,0));
//	  b.addActionListener(this);
//	}
//
//
//    /*
//     void quitter()
//  	{
//  		System.exit(0);
//  	}
//    */
//}
