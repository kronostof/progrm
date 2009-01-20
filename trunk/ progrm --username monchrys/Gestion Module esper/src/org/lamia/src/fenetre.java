package org.lamia.src;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * affiche le fenetre temporaire pour verifier les donn�e re�ut
 * @author Silex
 *
 */
public class fenetre extends JFrame implements ActionListener,MouseMotionListener{
	private JPanel container;
	private JTextField zone_affichage;
	private JButton start;
	private JButton stop;
	private JButton start_streaming;
	private JButton stop_streaming;
	private FlowLayout layout = null ;
	private OuvrirSocket socket;
	private Send send;
	
	
	public  fenetre(OuvrirSocket socket){
		super();
		build();
		this.socket = socket;
		
	}
	
	public void build(){
		this.setTitle("socket");
		this.setSize(500, 350);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setContentPane(getContainer());
	}
		
	public JPanel getContainer(){
		
		layout = new FlowLayout(); 
		layout.setAlignment(FlowLayout.CENTER);
		container = new JPanel() ; 
		container.setLayout(layout); 
		start = new JButton () ;
		start.setPreferredSize(new Dimension(125,25)) ;
		start.setText("Start recording") ;
		start.addActionListener(this);
		container.add(start);
		stop = new JButton () ;
		stop.setPreferredSize(new Dimension(125,25)) ;
		stop.setText("Stop recording") ;
		stop.addActionListener(this);
		container.add(stop);
		start_streaming = new JButton () ;
		start_streaming.setPreferredSize(new Dimension(125,25)) ;
		start_streaming.setText("Start streaming") ;
		start_streaming.addActionListener(this);
		container.add(start_streaming);
		stop_streaming = new JButton () ;
		stop_streaming.setPreferredSize(new Dimension(125,25)) ;
		stop_streaming.setText("Stop streaming") ;
		stop_streaming.addActionListener(this);
		container.add(stop_streaming);
		zone_affichage = new JTextField();
		zone_affichage.setPreferredSize(new Dimension(450,320));
		zone_affichage.addMouseMotionListener(this);
		container.add(zone_affichage);
		return container ;

	}
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == start){
			try {
				send = new Send("ET_REC" +"\n" + "\r", socket);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				send.sending();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		if(e.getSource() == stop){
			try {
				send = new Send("ET_STP" +"\n" + "\r", socket);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				send.sending();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		
			}
		if(e.getSource() == start_streaming){
			try {
				send = new Send("ET_STR" +"\n" + "\r", socket);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				send.sending();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		if(e.getSource() == stop_streaming){
			try {
				send = new Send("ET_EST" +"\n" + "\r", socket);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				send.sending();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
		
	
			
		
		}
	
	public void mouseMoved(MouseEvent e) {
	

		
		 
	}
	public void mouseDragged(MouseEvent e) {
		 
	}

	

}
