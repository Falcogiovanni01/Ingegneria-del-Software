package Main;

import Controller.* ; 
import Boundary.*;

import java.awt.GridLayout;

import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Centralino c = new Centralino();
		 
		 AgenteVendita frame_av = new AgenteVendita("Agente Vendita", c);
	        frame_av.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame_av.setSize(500,250);
	        frame_av.setLocation(100, 400);
	        frame_av.setVisible(true);
	        
	     Centralinista frame_c = new Centralinista("Centralinista", c);
	        frame_c.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame_c.setSize(1000,300);
	        frame_c.setLocation(300, 50);
	        frame_c.setVisible(true);
	     
	     Amministratore frame_a = new Amministratore("Amministratore", c);
	        frame_a.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame_a.setSize(500,300);
	        frame_a.setLayout(new GridLayout(0, 2));
	        frame_a.setLocation(700, 400);
	        frame_a.setVisible(true);
	}

}
