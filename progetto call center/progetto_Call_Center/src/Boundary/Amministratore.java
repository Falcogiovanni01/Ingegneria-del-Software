package Boundary;

import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Amministratore extends JFrame{
	
	private JTextField t_IDLista;
	private JTextField t_Numero;
    private JTextField t_IDGruppo;
    private JTextField t_Centralinista;
    private JTextArea t_DescrizioneGruppo;

	private JLabel l_stato;

    private JButton b_CreaLista;
    private JButton b_RimuoviLista;
    private JButton b_CreaGruppo;
    private JButton b_RimuoviGruppo;
    private JButton b_AssegnaLista;
    private JButton b_AggiungiUtente;
    private JButton b_RimozioneUtente;
    private JButton b_AggiungiCentralinista;
    private JButton b_RimozioneCentralinista;
    
    private JPanel p_controllo;
    
    public Amministratore(String title, Centralino c) {
        
    	super(title);
    	
    	p_controllo = new JPanel();
	    t_IDLista = new JTextField(10);
	    t_Numero = new JTextField(10);
	    t_IDGruppo = new JTextField(10);
	    t_Centralinista = new JTextField(10);
	    t_DescrizioneGruppo = new JTextArea(3, 10);
	    l_stato = new JLabel();
	    
	    p_controllo.add(new JLabel("ID lista:"));
	    p_controllo.add(t_IDLista);
	    p_controllo.add(new JLabel("Numero utente:"));
	    p_controllo.add(t_Numero);
	    p_controllo.add(new JLabel("ID gruppo:"));
	    p_controllo.add(t_IDGruppo);
	    p_controllo.add(new JLabel("ID centralinista:"));
	    p_controllo.add(t_Centralinista);
	    p_controllo.add(new JLabel("Descrizione gruppo:"));
	    p_controllo.add(t_DescrizioneGruppo);
	    p_controllo.add(new JLabel("Stato:"));
	    p_controllo.add(l_stato);
	    
	    b_CreaLista = new JButton("Crea lista");
	    b_RimuoviLista = new JButton("Rimuovi lista");
	    b_CreaGruppo = new JButton("Crea gruppo");
	    b_RimuoviGruppo = new JButton("Rimuovi gruppo");
	    b_AssegnaLista = new JButton("Assegna lista");
	    b_AggiungiUtente = new JButton("Aggiungi utente");
	    b_RimozioneUtente = new JButton("Rimuovi utente");
	    b_AggiungiCentralinista = new JButton("Aggiungi centralinista");
	    b_RimozioneCentralinista = new JButton("Rimuovi centralinista");

        b_CreaLista.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idlista = t_IDLista.getText();
                    String numero = t_Numero.getText();
                    
                    if(t_IDLista.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID della lista");
					else if(t_Numero.getText().trim().isEmpty())
						err = ("Impossibile leggere il numero telefonico");
					else {
	                    c.CreazioneLista(idlista, numero);
						l_stato.setText("Lista creata correttamente");
						return;
					}
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });
        
		p_controllo.add(b_CreaLista);

        b_RimuoviLista.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idlista = t_IDLista.getText();
                    
                    if (t_IDLista.getText().trim().isEmpty())
                        err = ("Impossibile leggere l'ID della lista");
                    else {
                    	c.RimozioneLista(idlista);
                    	l_stato.setText("Lista rimossa correttamente");
						return;
                    }
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });
        
		p_controllo.add(b_RimuoviLista);

        b_CreaGruppo.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idgruppo = t_IDGruppo.getText();
                    String descrizione = t_DescrizioneGruppo.getText();
                    
                    if (t_IDGruppo.getText().trim().isEmpty())
                        err = ("Impossibile leggere l'ID del gruppo");
                    else {
                    	c.CreazioneGruppo(idgruppo, descrizione);
                    	l_stato.setText("Gruppo creato correttamente");
						return;
					}
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });
        
		p_controllo.add(b_CreaGruppo);

        b_RimuoviGruppo.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idgruppo = t_IDGruppo.getText();
                    
                    if (t_IDGruppo.getText().trim().isEmpty())
                        err = ("Impossibile leggere l'ID del gruppo");
                    else {
                        c.RimozioneGruppo(idgruppo);
                        l_stato.setText("Gruppo rimosso correttamente");
						return;
                    }
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });
        
		p_controllo.add(b_RimuoviGruppo);

        b_AssegnaLista.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idgruppo = t_IDGruppo.getText();
                    String idlista = t_IDLista.getText();
                    
                    if(t_IDLista.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID della lista");
					else if(t_IDGruppo.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID del gruppo");
					else {
	                    c.AssegnaLista(idlista, idgruppo);
						l_stato.setText("Lista assegnata correttamente");
						return;
					}
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });

		p_controllo.add(b_AssegnaLista);

        b_AggiungiUtente.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idlista = t_IDLista.getText();
                    String numero = t_Numero.getText();
                    
                    if(t_IDLista.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID della lista");
					else if(t_Numero.getText().trim().isEmpty())
						err = ("Impossibile leggere il numero dell'utente");
					else {
	                    c.AggiungiUtente(idlista, numero);
						l_stato.setText("Utente aggiunto correttamente");
						return;
					}
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });
        
		p_controllo.add(b_AggiungiUtente);

        b_RimozioneUtente.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idlista = t_IDLista.getText();
                    String numero = t_Numero.getText();
                    
                    if(t_IDLista.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID della lista");
					else if(t_Numero.getText().trim().isEmpty())
						err = ("Impossibile leggere il numero dell'utente");
					else {
	                    c.RimozioneUtente(idlista, numero);
						l_stato.setText("Utente rimosso correttamente");
						return;
					}
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });
        
		p_controllo.add(b_RimozioneUtente);

        b_AggiungiCentralinista.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String idgruppo = t_IDGruppo.getText();
                    String Centr = t_Centralinista.getText();
                    
                    if(t_IDGruppo.getText().trim().isEmpty())
						err = ("Impossibile leggere l'ID del gruppo");
					else if(t_Centralinista.getText().trim().isEmpty())
						err = ("Impossibile leggere il numero del centralinista");
					else {
	                    c.aggiungiCentralinista(Centr, idgruppo);
						l_stato.setText("Centralinista aggiunto correttamente");
						return;
					}
                } catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });
        
		p_controllo.add(b_AggiungiCentralinista);

        b_RimozioneCentralinista.addActionListener(new ActionListener() {
        	@Override
            public void actionPerformed(ActionEvent e) {
            	String err = new String();
                try {
                    String Centr = t_Centralinista.getText();
                    
                    if (t_Centralinista.getText().trim().isEmpty())
                        err = ("Impossibile leggere l'ID del centralinista");
                    else {
                        c.rimozioneCentralinista(Centr);
                        l_stato.setText("Centralinista rimosso correttamente");
						return;
                    }
                }catch (Exception f) {
                	err = ("Dati non validi");
			        f.printStackTrace();
				}
				 l_stato.setText(err);
            }
        });

		p_controllo.add(b_RimozioneCentralinista);

        this.setContentPane(p_controllo);
        this.pack();
    }

}


