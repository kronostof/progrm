package org.calibration;

import java.awt.Color;
   import java.awt.Graphics;
import java.awt.Polygon;

import javax.swing.JPanel;
 
   public class Eyes extends JPanel
   {
     int PosX;
     int PosY;
     int haut_X = 640;
     int haut_y = 150;
     int bas_X = 640;
     int bas_y = 1024-150;
     int gauche_X = 150;
     int gauche_y = 512;
     int droite_X = 1280-150;
     int droite_y = 512;
     
     boolean affiche_fleche_bas = false;
     boolean affiche_fleche_haut = false;
     boolean affiche_fleche_gauche = false;
     boolean affiche_fleche_droite = false;
     
	 
	 public Eyes(){
 
	 }
	 
	 public Eyes(int PosX, int PosY){
		 this.PosX = PosX;
		 this.PosY = PosY; 
	 }
	 
	 public void setPos(int PosX, int PosY){
		 this.PosX = PosX;
		 this.PosY = PosY; 
		 
	 }
     public void paintComponent( Graphics g )
     {
        super.paintComponent( g ); 

        this.setBackground( Color.LIGHT_GRAY );

        g.setColor( Color.WHITE );
        int x1 = PosX-45;
        int y1 = PosY-27;
        g.fillOval( x1, y1, 90, 54 );
        
        g.setColor( Color.WHITE );
        int x2 = PosX-45+2*90;
        int y2 = PosY-27;
        g.fillOval( x2, y2, 90, 54 );
        
        
       /*
        * j'ai ajouté ce code pour se localiser un peut dans l'ecran
        *  g.fillRect(haut_X, haut_y, 2, 2);
        g.fillRect(bas_X, bas_y, 2, 2);
        g.fillRect(droite_X, droite_y, 2, 2);
        g.fillRect(gauche_X, gauche_y, 2, 2);*/
        
        
        if (affiche_fleche_bas){
        	g.setColor( Color.WHITE );
            int xValues[] = {bas_X, bas_X-50, bas_X-20, bas_X-20, bas_X+20, bas_X+20, bas_X+50, bas_X};           
            int yValues[] = {bas_y, bas_y+50, bas_y+50, bas_y+100, bas_y+100, bas_y+50, bas_y+50, bas_y};           
            Polygon polygon1 = new Polygon( xValues, yValues, 8 );
            g.fillPolygon( polygon1 );
        }
        if (affiche_fleche_droite){
        	g.setColor( Color.WHITE );
            int xValues2[] = {droite_X, droite_X+50, droite_X+50, droite_X+100, droite_X+100, droite_X+50, droite_X+50, droite_X};           
            int yValues2[] = {droite_y, droite_y-50, droite_y-20, droite_y-20, droite_y+20, droite_y+20,droite_y+50, droite_y};           
            Polygon polygon2 = new Polygon( xValues2, yValues2, 8 );
            g.fillPolygon( polygon2 );
        	
        }
        if (affiche_fleche_haut){
        	g.setColor( Color.WHITE );
            int xValues3[] = {haut_X, haut_X-50, haut_X-20, haut_X-20, haut_X+20, haut_X+20, haut_X+50, haut_X};           
            int yValues3[] = {haut_y, haut_y-50, haut_y-50,haut_y-100, haut_y-100, haut_y-50, haut_y-50,haut_y};           
            Polygon polygon3 = new Polygon( xValues3, yValues3, 8 );
            g.fillPolygon( polygon3 );
        	
        }
        if (affiche_fleche_gauche){
        	g.setColor( Color.WHITE );
            int xValues4[] = {gauche_X, gauche_X-50, gauche_X-50, gauche_X-100, gauche_X-100, gauche_X-50, gauche_X-50, gauche_X};           
            int yValues4[] = {gauche_y, gauche_y-50, gauche_y-20, gauche_y-20, gauche_y+20, gauche_y+20,gauche_y+50, gauche_y};           
            Polygon polygon4 = new Polygon( xValues4, yValues4, 8 );
            g.fillPolygon( polygon4 );
        }
        
     } 
 } 
