/* licence GPL 2*/
package org.EFFACERasma;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/*
public class affichage extends JFrame implements ActionListener,MouseMotionListener{
	private JPanel container = null;//D�claration de l'objet JPanel
	private JPanel tableau = null;//D�claration de l'objet JPanel
	private FlowLayout layout = null ;//D�claration de notre layout
	private JLabel texte = null;//D�claration de l'objet JLabel
	private JButton bouton = null;//D�claration du bouton
	private JButton bouton2 = null;//D�claration du bouton
	private JButton bouton3 = null;//D�claration du bouton
	private int nombre = 0; //D�claration du chiffre
	private int X = 0, Y = 0; //D�claration du chiffre
	private String shape = "";
	private Graphics g;
	cercle cercercle;
	
	public affichage(){
		super("Suivi moi");
		build();//On initialise notre fen�tre
		}
	
		private void build(){
		//this.setTitle("Suivi moi"); //On donne un titre � l'application
		this.setDefaultLookAndFeelDecorated(true);
		this.setUndecorated(false);
		this.setExtendedState(this.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit � l'application de sefermer
		this.setContentPane(getContainer());
		}
		private JPanel getContainer(){
			layout = new FlowLayout(); //Instanciation du layout
			layout.setAlignment(FlowLayout.CENTER);//On centre les composants
			container = new JPanel() ; //On cr�e notre objet
			container.setLayout(layout); //On applique le layout
			//texte = new JLabel() ;//On cr�e notre objet
			//texte.setPreferredSize(new Dimension(250,25)) ;//On lui donne une taille
			//texte.setText(""); //On lui donne un texte
			//container.add(texte);//On l'ajoute au container
			bouton = new JButton () ;//Cr�ation du bouton
			bouton.setPreferredSize(new Dimension(125,25)) ;//On lui donne une taille
			bouton.setText("SQUARE") ;//On lui donne un texte
			bouton.addActionListener(this);//On ajoute la fen�tre en tant qu'�couteur du bouton
			container.add(bouton);//On l'ajoute � la fen�tre
			bouton2 = new JButton () ;//Cr�ation du bouton
			bouton2.setPreferredSize(new Dimension(125,25)) ;//On lui donne une taille
			bouton2.setText("CIRCLE") ;//On lui donne un texte
			bouton2.addActionListener(this);//On ajoute la fen�tre en tant qu'�couteur du bouton
			container.add(bouton2);//On l'ajoute � la fen�tre
			bouton3 = new JButton () ;//Cr�ation du bouton
			bouton3.setPreferredSize(new Dimension(125,25)) ;//On lui donne une taille
			bouton3.setText("OVALE") ;//On lui donne un texte
			bouton3.addActionListener(this);//On ajoute la fen�tre en tant qu'�couteur du bouton
			container.add(bouton3);//On l'ajoute � la fen�tre
			tableau = new JPanel();
			tableau.setBackground(Color.WHITE);
			tableau.setPreferredSize(container.getMaximumSize());
			tableau.addMouseMotionListener(this);
			container.add(tableau);
			
			
			cercercle = new cercle(5,5,5,5,container);
			return container ;
			}
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bouton){
		    tableau.repaint();
			shape = new String(bouton.getText());
			}
			else {
				if(e.getSource() == bouton2){
					tableau.repaint();
					shape = new String(bouton2.getText());	
				}
				
				else {
					if(e.getSource() == bouton3){
						tableau.repaint();
						shape = new String(bouton3.getText());
					}
				}	
			}
				
				
			
			}
		
		public void mouseMoved(MouseEvent e) {
			X = e.getX();
			Y = e.getY();
			if ( shape.equals(bouton.getText()) ){
				g = e.getComponent().getGraphics();
				g.setColor(Color.MAGENTA);
				g.drawRect(X, Y, 40, 40);
				
				
			}
		    else if ( shape.equals(bouton2.getText()) ){
		    	cercercle.setcomponent(e.getComponent().getGraphics());
		    	cercercle.setPosition(X,Y);
				cercercle.draw();
		    }
		    else if ( shape.equals(bouton3.getText()) ){
		    	g = e.getComponent().getGraphics();
		    	g.setColor(Color.ORANGE);
		    	g.drawOval(X, Y, 40, 50);
		    }
		    else
		    	tableau.repaint();

			
			 
		}
		public void mouseDragged(MouseEvent e) {
			 
		}

}
*/