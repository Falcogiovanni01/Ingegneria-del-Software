
package Boundary;

import Controller.Centralino;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Centralinista extends JFrame {

	private JTextField t_lista;
	private JTextField t_numeroTelefonico;
	private JTextField t_idAppuntamento;
	private JTextField t_dataAppuntamento;
	private JTextField t_oreAppuntamento;
	private JTextField t_minutiAppuntamento;
	private JTextField t_idTelefonata; 
	private JTextField t_codiceFiscale ; 
	private JTextField t_dataTelefonata;
	private JTextField t_oreTelefonata;
	private JTextField t_minutiTelefonata;
	private JTextField t_esitoTelefonata;
	private JTextArea t_NoteTelefonata;
	private JTextArea t_NoteAppuntamento;
	private JTextField t_idCentralinista ; 

	private JButton b_chiamata;
	private JButton b_registraEsito;
	private JButton b_creaAppuntamento;
	private JButton b_registraNote ; 
	
	private JLabel l_stato;
	  
	private JPanel pannello_superiore;
	private JPanel pannello_intermedario_appuntamento;
	private JPanel pannello_intermedario_telefonata;
	private JPanel pannello_intermedario;	
	private JPanel pannello_pulsanti;	

  public Centralinista(String title, Centralino c) {
	  
	  super(title);
    
	  pannello_superiore = new JPanel();
	  pannello_intermedario_appuntamento = new JPanel();
	  pannello_intermedario_telefonata = new JPanel();	  
	  pannello_intermedario = new JPanel();	  
	  pannello_pulsanti = new JPanel();	  
    
	  t_lista = new JTextField(10);
	  t_numeroTelefonico = new JTextField(10);
	  t_idAppuntamento = new JTextField(10);
	  t_dataAppuntamento = new JTextField(10);
	  t_oreAppuntamento = new JTextField(2);
	  t_minutiAppuntamento = new JTextField(2);
	  t_idTelefonata = new JTextField(10);
	  t_dataTelefonata = new JTextField(10);
	  t_oreTelefonata = new JTextField(2);
	  t_minutiTelefonata = new JTextField(2);
	  t_esitoTelefonata = new JTextField(10);
	  l_stato = new JLabel();
	  t_NoteTelefonata = new JTextArea(3, 10);
	  t_NoteAppuntamento = new JTextArea(3, 10);
	  t_idCentralinista = new JTextField(5) ; 
	  t_codiceFiscale = new JTextField(16)  ; 
	  this.setLayout(new GridLayout(5,1));

	  pannello_superiore.add(new JLabel("Lista:"));
	  pannello_superiore.add(t_lista);
	  pannello_superiore.add(new JLabel ("id centralinista:")) ; 
	  pannello_superiore.add(t_idCentralinista); 
	  pannello_superiore.add(new JLabel("Numero telefonico:"));
	  pannello_superiore.add(t_numeroTelefonico);
	  
	  this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
	  this.add(pannello_superiore);
	  
	  pannello_intermedario_appuntamento.add(new JLabel("ID appuntamento:"));
	  pannello_intermedario_appuntamento.add(t_idAppuntamento);
	  pannello_intermedario_appuntamento.add(new JLabel("Data appuntamento:"));
	  pannello_intermedario_appuntamento.add(t_dataAppuntamento);
	  pannello_intermedario_appuntamento.add(new JLabel("Ora appuntamento:"));
	  pannello_intermedario_appuntamento.add(t_oreAppuntamento);
	  pannello_intermedario_appuntamento.add(new JLabel(":"));
	  pannello_intermedario_appuntamento.add(t_minutiAppuntamento);
	  pannello_intermedario_appuntamento.add(new JLabel("Note appuntamento:"));
	  pannello_intermedario_appuntamento.add(t_NoteAppuntamento);
	  pannello_intermedario_appuntamento.add(new JLabel ("Codice fiscale:"));
	  pannello_intermedario_appuntamento.add(t_codiceFiscale); 
	  this.add(pannello_intermedario_appuntamento);
	  
	  pannello_intermedario_telefonata.add(new JLabel("ID telefonata:"));
	  pannello_intermedario_telefonata.add(t_idTelefonata);
/*	  pannello_intermedario_telefonata.add(new JLabel("Data telefonata:"));
	  pannello_intermedario_telefonata.add(t_dataTelefonata);
	  pannello_intermedario_telefonata.add(new JLabel("Ora telefonata:"));
	  pannello_intermedario_telefonata.add(t_oreTelefonata);
	  pannello_intermedario_telefonata.add(new JLabel(":"));
	  pannello_intermedario_telefonata.add(t_minutiTelefonata);*/
	  pannello_intermedario_telefonata.add(new JLabel("Esito telefonata:"));
	  pannello_intermedario_telefonata.add(t_esitoTelefonata);
	  pannello_intermedario_telefonata.add(new JLabel("Note telefonata:"));
	  pannello_intermedario_telefonata.add(t_NoteTelefonata);
	  
	  this.add(pannello_intermedario_telefonata);
	  
	  pannello_intermedario.add(new JLabel("Stato:"));
	  pannello_intermedario.add(l_stato);
	  
	  this.add(pannello_intermedario);

	  b_chiamata = new JButton("Chiama Numero");
	  b_registraEsito = new JButton("Registra Esito");
	  b_creaAppuntamento = new JButton("Crea Appuntamento");
	  b_registraNote = new JButton("Registra Note") ; 
	  
	  b_chiamata.addActionListener(new ActionListener() { // id centralinista e lista
		  @Override
		  public void actionPerformed(ActionEvent e) {
			  String err = new String();
			  try {
				  String lista = t_lista.getText();
				  //String numero_telefonico = t_numeroTelefonico.getText();
				  String cent = t_idCentralinista.getText() ; 
				  if (lista.trim().isEmpty()) {
					 err = ("Impossibile leggere la lista di appartenenza");
				  } else if (cent.trim().isEmpty()) {
					  err = ("Impossibile leggere il numero da chiamare");
				  } else {
					  c.chiamaNumero(lista, cent);
					  l_stato.setText("Chiamata completata con successo");
					  return; 
				  }
			  } catch (Exception f) {
				  err = ("Dati non validi");
				  f.printStackTrace();
			  }

			  l_stato.setText(err);
		  }
	  });

	  pannello_pulsanti.add(b_chiamata);
        
	    b_registraEsito.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  String err = new String();
	    	  try {
	        	String id = t_idTelefonata.getText();
	      	        	String t = t_esitoTelefonata.getText();
	 			
 			
	 			if (t_idTelefonata.getText().trim().isEmpty()) {
	 	            err = ("Impossibile leggere l'ID della telefonata");
	 	             } else if (t_esitoTelefonata.getText().trim().isEmpty()) {
	 	 	            err = ("Impossibile leggere l'esito");
	 	 	      
	 	 	      } else {
	 	 	    	c.registrazioneEsito(id,t);
	 	 	    	l_stato.setText("Chiamata registrata con successo");
	 	            return; 
	 	          }
	    	  }catch(Exception f) {
	    		  err = ("Dati non validi");
	    		  f.printStackTrace();
	    	  }
	    	 l_stato.setText(err);
	        }
	    });
	    
	    pannello_pulsanti.add(b_registraEsito);
	
	  
	    
	    b_creaAppuntamento.addActionListener(new ActionListener() {
	      @Override
	      public void actionPerformed(ActionEvent e) {
	    	  String err = new String();
	    	  try {
	     		String id_a = t_idAppuntamento.getText();
	        	String d_a = t_dataAppuntamento.getText();
	        	
	        	String ore = t_oreAppuntamento.getText();
				String minuti = t_minutiAppuntamento.getText();
				String secondi = "0" ; 
				String o_a = ore + ":" + minuti + ":"+secondi;			
				String n_a = t_NoteAppuntamento.getText();
				String cod = t_codiceFiscale.getText(); 
				String t_tel= t_idTelefonata.getText(); 
	        	
	        	if (t_idAppuntamento.getText().trim().isEmpty()) {
	 	            err = ("Impossibile leggere l'ID dell'appuntamento");
	 	          } else if (t_dataAppuntamento.getText().trim().isEmpty()) {
	 	            err = ("Impossibile leggere la data");
	 	          } else if (t_oreAppuntamento.getText().trim().isEmpty() && t_minutiAppuntamento.getText().trim().isEmpty()) {
	 	 	            err = ("Impossibile leggere l'ora");
	 	 	      } else if (t_NoteAppuntamento.getText().trim().isEmpty()) {
	 	 	            err = ("Impossibile leggere le note");
	 	 	      } else {
	 	 	    	c.creaAppuntamento(id_a, d_a, o_a, n_a , cod , t_tel  ); // CODICE FISCALE E ID TELEFONATA
	 	 	    	
	 	 	    	l_stato.setText("Appuntamento creato con successo");
	 	            return; 
	 	          }
	        	} catch(Exception f) {
	        		 err = ("Dati non validi");
	       		  f.printStackTrace();
	        	}
	       	 l_stato.setText(err);
	        	}
	        });
	    
	    pannello_pulsanti.add(b_creaAppuntamento);
	
	    this.add(pannello_pulsanti);
	    this.pack();
	    }
	}  
		
