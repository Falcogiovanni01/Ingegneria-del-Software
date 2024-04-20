package Entity;
import java.sql.Time;

import Database.AppuntamentiDAO;

import java.util.Date; 


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class EntityAppuntamenti {

	private String idAppuntamento ; 
	private Date data ; 
	private Time ore ;
	private String note  ; 
	private String codiceFiscale ; 
	private String idTelefonata ;
	
	public EntityAppuntamenti() {
		super() ; 
	}
	public EntityAppuntamenti(String idAppuntamento) {
		
		AppuntamentiDAO appuntamento = new AppuntamentiDAO(idAppuntamento) ; 
		this.idAppuntamento=appuntamento.getID()  ; 
		this.data=appuntamento.getData()  ; 
		this.ore=appuntamento.getOra() ; 
		this.note=appuntamento.getNote(); 
		this.codiceFiscale=appuntamento.getId_codice_fiscale() ; 
		this.idTelefonata=appuntamento.getId_telefonata(); 
	}
	
	public EntityAppuntamenti(AppuntamentiDAO appuntamento) {
		this.idAppuntamento=appuntamento.getID()  ; 
		this.data=appuntamento.getData()  ; 
		this.ore=appuntamento.getOra() ; 
		this.note=appuntamento.getNote(); 
		this.codiceFiscale=appuntamento.getId_codice_fiscale() ; 
		this.idTelefonata=appuntamento.getId_telefonata(); 
	}
	
	public EntityAppuntamenti(String id, Date dat, Time ora, String n, String c, String t) {
	    this.idAppuntamento=id; 
	    this.data=dat; 
	    this.ore=ora; 
	    this.note=n; 
	    this.codiceFiscale=c; 
	    this.idTelefonata=t; 
	  }

	public String getIdAppuntamento() {
		return idAppuntamento;
	}
	public void setIdAppuntamento(String id) {
		idAppuntamento = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(String data) {
		 String pattern = "dd/MM/yyyy"; 
	       SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	       Date giorno = new Date() ;
	       try {
	            giorno = sdf.parse(data);
	           System.out.println("Data: " + data);
	       } catch (ParseException e) {
	           e.printStackTrace();       }
		this.data = giorno;
	}
	public Time getOre() {
		return ore;
	}
	public void setOre(Time ore) {
		this.ore = ore;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		if(codiceFiscale.length()==16) {
      this.codiceFiscale = codiceFiscale;
		}
		else {
			System.out.println("Codice fiscale inserito non valido") ; 
			
		}
	}
	public String getIdTelefonata() {
		return idTelefonata;
	}
	public void setIdTelefonata(String idTelefonata) {
		this.idTelefonata = idTelefonata;
	}
	
	
	
	
	
}
