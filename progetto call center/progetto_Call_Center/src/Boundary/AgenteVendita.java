package Boundary;

import Controller.Centralino;

import javax.swing.*;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;

public class AgenteVendita extends JFrame{
	
	private JTextField t_id;
	private JTextField t_data;
	private JTextField t_ore;
	private JTextField t_minuti;
	private JTextArea t_note;
	
	private JLabel l_stato;
	
	private JButton b_VisualizzaAppuntamento;
	private JButton b_VisualizzaAppuntamenti;
	private JButton b_ModificaNoteAppuntamento;
	private JButton b_VisualizzaNoteAppuntamentiFissati;
	
	private JPanel pannello_superiore;
	private JPanel pannello_intermedio;
	private JPanel pannello_inferiore;
	private JPanel pannello_pulsanti;
	
	public AgenteVendita(String title, Centralino c) {
		
		super(title);
		
		pannello_superiore = new JPanel();
		pannello_intermedio = new JPanel();
		pannello_inferiore = new JPanel();
		pannello_pulsanti = new JPanel();
		
	    t_id = new JTextField(10);
	    t_data = new JTextField(10);
	    t_ore = new JTextField(2);
	    t_minuti = new JTextField(2);
	    t_note = new JTextArea(3, 10);
	    l_stato = new JLabel();
	    
	    this.setLayout(new GridLayout(3,1));
	    pannello_pulsanti = new JPanel(new GridLayout(2, 2));
	    
	    pannello_superiore.add(new JLabel("ID:"));
	    pannello_superiore.add(t_id);
	    pannello_superiore.add(new JLabel("Data:"));
	    pannello_superiore.add(t_data);
	    
	    this.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		this.add(pannello_superiore);
	    	    
	    pannello_intermedio.add(new JLabel("Ora:"));
	    pannello_intermedio.add(t_ore);
	    pannello_intermedio.add(new JLabel(":"));
	    pannello_intermedio.add(t_minuti);
	    pannello_intermedio.add(new JLabel("Note:"));
	    pannello_intermedio.add(t_note);
	    
		this.add(pannello_intermedio);
		
	    pannello_inferiore.add(new JLabel("Stato:"));
	    pannello_inferiore.add(l_stato);
	    
		this.add(pannello_inferiore);

	    b_VisualizzaAppuntamento = new JButton("Visualizza Appuntamento");
	    b_VisualizzaAppuntamenti = new JButton("Visualizza Tutti Appuntamenti");
	    b_ModificaNoteAppuntamento = new JButton("Modifica Note Appuntamento");
	    b_VisualizzaNoteAppuntamentiFissati = new JButton("Visualizza Note Appuntamenti Fissati");
		
	    b_VisualizzaAppuntamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String err = new String();
				try {
					String id = t_id.getText();
					
					if(t_id.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID dell'appuntamento");
					else {
						c.visualizzaAppuntamenti(id);
						l_stato.setText("Appuntamento importato correttamente");
						return;
					}
				} catch(Exception f){
					err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
			}
			
		});
	    
	    /*
					String ore = t_ore.getText();
					String minuti = t_minuti.getText();
					String ora = ore + ":" + minuti;
					LocalTime time = LocalTime.parse(ora);
					System.out.println("Ora: " + time);
		*/
		
		pannello_pulsanti.add(b_VisualizzaAppuntamento);
		
		b_VisualizzaAppuntamenti.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String err = new String();
				try {
						if(l_stato.getText().trim().isEmpty())
						err = ("Impossibile importare gli appuntamenti");
						else {
							c.visualizzaTuttiAppuntamenti();
							l_stato.setText("Appuntamenti importati correttamente");
							return;
					}
				} catch(Exception f) {
					err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
			}
		});
		
		pannello_pulsanti.add(b_VisualizzaAppuntamenti);
		
		b_ModificaNoteAppuntamento.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String err = new String();
				try {
					String ID = t_id.getText();
					String Note = t_note.getText();
					
					if(t_id.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID dell'appuntamento");
					else if(t_note.getText().trim().isEmpty())
						err = ("Impossibile leggere le note");
					else {
						c.modificaNoteAppuntamenti(ID, Note);
						l_stato.setText("Note dell'appuntamento selezionato modificate correttamente");
						return;
					}
				} catch(Exception f) {
					
					err = ("Dati non validi");
			        f.printStackTrace();

				}
					l_stato.setText(err);
			}
		});
		
		pannello_pulsanti.add(b_ModificaNoteAppuntamento);
		
		b_VisualizzaNoteAppuntamentiFissati.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String err = new String();

				try {					
					if(t_id.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID dell'appuntamento");
				//	else if(t_note.getText().trim().isEmpty())
					//	err = ("Impossibile leggere le note");
					else {
						c.visualizzNoteAppuntamentiFissati();
						l_stato.setText("Note dell'appuntamento selezionato importate correttamente");
						return;
					}
				} catch(Exception f) {
					err = ("Dati non validi");
					f.printStackTrace();
					
				}
					l_stato.setText(err);
			}
		});
		
		pannello_pulsanti.add(b_VisualizzaNoteAppuntamentiFissati);

		this.add(pannello_pulsanti);
		this.pack();

	}
}
