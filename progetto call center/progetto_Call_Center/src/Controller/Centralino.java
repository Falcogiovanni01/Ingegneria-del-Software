/*package Controller;

import Database.*;
import Entity.*;

import java.util.ArrayList;

public class Centralino {
	private EntityUtente utente ; 
	private EntityLista lista ; 
	private EntityAgentiVendita agente; 
	private EntityTelefonate telefonata; 
	private EntityAppuntamenti appuntamento; 
	
	public Centralino() {
		this.utente=new EntityUtente() ; 
		this.lista= new EntityLista () ; 
		this.agente = new EntityAgentiVendita(); 
		this.telefonata = new EntityTelefonate(); 
		this.appuntamento = new EntityAppuntamenti(); 
	}
	
	// FUNZIONI AMMINISTRATORE : 

	public void AggiungiUtente(String idLista, String numero) {
		EntityLista lista= new EntityLista(idLista); // ERRORE ? DI VOLTA IN VOLTA NON CREA SEMPRE UNA NUOVA LISTA ? 
		lista.AggiungiUtente(numero);
	}
	
	public void CreazioneLista(String id, ArrayList<String> numeri) {
		ListaDAO listaDAO= new ListaDAO(id);
		listaDAO.insert();
		while(numeri.listIterator().hasNext()) {
			AggiungiUtente(id,numeri.listIterator().next());
		}
	}
	
	
	
	
	// ----- FUNZIONI AGENTE VENDITA 
	public void visualizzaAppuntamenti(String id) {
		agente.visualizzaAppuntamenti(id); // ho messo in AppuntamentiDAO un costrutto che controlla se l'id non c'è
	}
	
	public void visualizzaTuttiAppuntamenti() {
		agente.visualizzaTuttiAppuntamenti();
	}
	public void modificaNoteAppuntamenti (String id , String note) {
		agente.modificaNoteAppuntamenti(id, note);
		}
	
	public void visualizzNoteAppuntamentiFissati () {
	
		agente.visualizzNoteAppuntamentiFissati(); 
	}
	
	
	
	
	
	// funzioni TELEFONATA ( lascio in sospeso mi servirebbe la parte del centralinista!)
}


/*
 * 
public class Centralino {
	private static Centralino instance=null;  // vuole utilizzare il Singleton ? 
	private Centralino() {
		super();
	}
	public static Centralino getInstanceCentralino() {
		if(instance==null) instance= new Centralino();
		return instance;
	}
	
	public void AggiungiUtente(String idLista, String numero) {
		EntityLista lista= new EntityLista(idLista);
		lista.AggiungiUtente(numero);
	}
	
	public void CreazioneLista(String id, ArrayList<String> numeri) {
		ListaDAO listaDAO= new ListaDAO(id);
		listaDAO.insert();
		while(numeri.listIterator().hasNext()) {
			AggiungiUtente(id,numeri.listIterator().next());
		}
	}
}
*/


package Controller;

import Entity.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.sql.SQLException;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import org.junit.Test;

import Database.DBConnectionManager;
import Database.ListaDAO;

public class Centralino {
	private static Centralino instance = null; // vuole utilizzare il Singleton ?

	public  Centralino() {
		super();
	}

	public static Centralino getInstanceCentralino() {
		if (instance == null)
			instance = new Centralino();
		return instance;
	}

	// FUNZIONI AMMINISTRATORE :
	public void AggiungiUtente(String idLista, String numero) {
		EntityLista lista = new EntityLista(idLista); 
		lista.AggiungiUtente(numero, idLista);
	}

	public void RimozioneUtente(String numero , String idLista) {
		EntityLista lista = new EntityLista(idLista);
		lista.RimuoviUtente(numero  , idLista);
	}

	public void CreazioneLista(String id, String numeri) {
		EntityLista lista = new EntityLista();
		lista.CreazioneLista(id, numeri);
	}

	public void RimozioneLista(String id) {
		EntityLista lista = new EntityLista(id);
	lista.RimozioneLista(id);
	}
	public void aggiungiCentralinista(String idCentr, String idgruppo){ 
		  EntityCentralinisti centralinista = new EntityCentralinisti(); 
		  centralinista.aggiungiCentralinista(idCentr, idgruppo); 
		 }

	public void CreazioneGruppo(String id, String Descrizione) {
		EntityGruppiCentralinisti gruppo = new EntityGruppiCentralinisti();
		gruppo.CreazioneGruppo(id, Descrizione);
	}

	public void RimozioneGruppo(String id) {
		EntityGruppiCentralinisti gruppo = new EntityGruppiCentralinisti(id);
		gruppo.RimozioneGruppo(id);
	}

	public void chiamaNumero(String idCentralinista , String idLista) {
		EntityCentralinisti centralinista = new EntityCentralinisti(idCentralinista) ; 
		centralinista.chiamaNumero(idLista);
	}
	                                      
	// ----- FUNZIONI AGENTE VENDITA
	public void visualizzaAppuntamenti(String id_Appuntamento) {
		EntityAgentiVendita agente = new EntityAgentiVendita();
		agente.visualizzaAppuntamenti(id_Appuntamento); 
		}

	public void visualizzaTuttiAppuntamenti() {
		EntityAgentiVendita agente = new EntityAgentiVendita();
		agente.visualizzaTuttiAppuntamenti();
	}

	public void modificaNoteAppuntamenti(String id_Appuntamento, String note) {
		EntityAgentiVendita agente = new EntityAgentiVendita();
		agente.modificaNoteAppuntamenti(id_Appuntamento, note);
	}

	public void visualizzNoteAppuntamentiFissati() {
		EntityAgentiVendita agente = new EntityAgentiVendita();
		agente.visualizzNoteAppuntamentiFissati();
	}
	
	public void rimozioneCentralinista(String idCentr){ 
		  EntityCentralinisti centralinista = new EntityCentralinisti(); 
		 centralinista.RimuoviCentralinista(idCentr); 
		 }

	public void AssegnaLista(String idLista, String idgruppo){ 
		  EntityLista lista = new EntityLista(); 
		  lista.AssegnaLista(idLista, idgruppo); 
		 }
	public void registrazioneNote(String id , String note) {
		EntityCentralinisti cel = new EntityCentralinisti() ; 
		cel.registraNote(id, note);
		
	}
	// se lo provi scrivere la data nel seguente modo : anno-mese-giorno . ci vogliono i "-" non "/"
	public void creaAppuntamento(String id_app,String d_a,String or_a,String  note_a , String cf , String idTel) {
		EntityCentralinisti cel = new EntityCentralinisti() ;
			
	       // CONVERSIONE STRINGA IN TIME
	       SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
	        Date date;
	        try {
	            date = sdf1.parse(or_a);
	        } catch (ParseException e) {
	            e.printStackTrace();
	            return; // Gestisci l'eccezione come desideri
	        }

	        Time time = new Time(date.getTime());
// conversione data
Date data1 = java.sql.Date.valueOf(d_a);
		
	cel.creazioneAppuntamento(id_app, data1, time, note_a, cf, idTel);
	}
	
	public void registrazioneEsito ( String id_tel , String esito ) {
		EntityTelefonate t = new EntityTelefonate() ; 
		t.registrazioneEsito(id_tel, esito);
	}
	
	
}



 