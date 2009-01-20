package org.asma;
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


public class affichage extends JFrame implements ActionListener,MouseMotionListener{
	private JPanel container = null;//Déclaration de l'objet JPanel
	private JPanel tableau = null;//Déclaration de l'objet JPanel
	private FlowLayout layout = null ;//Déclaration de notre layout
	private JLabel texte = null;//Déclaration de l'objet JLabel
	private JButton bouton = null;//Déclaration du bouton
	private JButton bouton2 = null;//Déclaration du bouton
	private JButton bouton3 = null;//Déclaration du bouton
	private int nombre = 0; //Déclaration du chiffre
	private int X = 0, Y = 0; //Déclaration du chiffre
	private String shape = null;
	private Graphics g;

	
	public affichage(){
		super();
		build();//On initialise notre fenêtre
		}
		private void build(){
		this.setTitle("Suivi moi"); //On donne un titre à l'application
		this.setSize(500,350); //On donne une taille à notre fenêtre
		this.setLocationRelativeTo(null); //On centre la fenêtre sur l'écran
		this.setResizable(false) ; //On interdit la redimensionnement de la fenêtre
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //On dit à l'application de sefermer
		//lors du clic sur la croix
		this.setContentPane(getContainer());
		}
		private JPanel getContainer(){
			layout = new FlowLayout(); //Instanciation du layout
			layout.setAlignment(FlowLayout.CENTER);//On centre les composants
			container = new JPanel() ; //On crée notre objet
			container.setLayout(layout); //On applique le layout
			//texte = new JLabel() ;//On crée notre objet
			//texte.setPreferredSize(new Dimension(250,25)) ;//On lui donne une taille
			//texte.setText(""); //On lui donne un texte
			//container.add(texte);//On l'ajoute au container
			bouton = new JButton () ;//Création du bouton
			bouton.setPreferredSize(new Dimension(125,25)) ;//On lui donne une taille
			bouton.setText("SQUARE") ;//On lui donne un texte
			bouton.addActionListener(this);//On ajoute la fenêtre en tant qu'écouteur du bouton
			container.add(bouton);//On l'ajoute à la fenêtre
			bouton2 = new JButton () ;//Création du bouton
			bouton2.setPreferredSize(new Dimension(125,25)) ;//On lui donne une taille
			bouton2.setText("CIRCLE") ;//On lui donne un texte
			bouton2.addActionListener(this);//On ajoute la fenêtre en tant qu'écouteur du bouton
			container.add(bouton2);//On l'ajoute à la fenêtre
			bouton3 = new JButton () ;//Création du bouton
			bouton3.setPreferredSize(new Dimension(125,25)) ;//On lui donne une taille
			bouton3.setText("OVALE") ;//On lui donne un texte
			bouton3.addActionListener(this);//On ajoute la fenêtre en tant qu'écouteur du bouton
			container.add(bouton3);//On l'ajoute à la fenêtre
			tableau = new JPanel();
			tableau.setBackground(Color.WHITE);
			tableau.setPreferredSize(new Dimension(450,320));
			tableau.addMouseMotionListener(this);
			container.add(tableau);
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
		    	g = e.getComponent().getGraphics();
		    	g.setColor(Color.CYAN);
		    	g.drawOval(X, Y, 40, 40);
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
																																																																																																																																																																																																																																																										