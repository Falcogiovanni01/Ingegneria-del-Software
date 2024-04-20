package Entity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import Database.*;


public class EntityCentralinisti {
private String idCentralinisti ; 
private String nome ; 
private String cognome ; 
private String email ; 
private String idGruppo  ;

public EntityCentralinisti() {
	super() ; 
}
public EntityCentralinisti(String idCentralinista) {
	CentralinistaDAO centralinista = new CentralinistaDAO(idCentralinista) ; 
	this.idCentralinisti= centralinista.getIdCentralinista() ; 
	this.nome=centralinista.getNome() ; 
	this.cognome=centralinista.getCognome() ; 
	this.email = centralinista.getEmail() ; 
	this.idGruppo= centralinista.getIdgruppo() ; 
}
public EntityCentralinisti (CentralinistaDAO  centralinista) {
	this.idCentralinisti= centralinista.getIdCentralinista() ; 
	this.nome=centralinista.getNome() ; 
	this.cognome=centralinista.getCognome() ; 
	this.email = centralinista.getEmail() ; 
	this.idGruppo= centralinista.getIdgruppo() ; 

}

public EntityCentralinisti (String idCentra , String n , String c , String e , String gru) {
	this.idCentralinisti= idCentra ; 
	this.nome= n ; 
	this.cognome=c ; 
	this.email = e ; 
	this.idGruppo= gru ; 
}

public String getIdCentralinisti() {
	return idCentralinisti;
}
public void setIdCentralinisti(String idCentralinisti) {
	this.idCentralinisti = idCentralinisti;
}
public String getNome() {
	return nome;
}
public void setNome(String nome) {
	this.nome = nome;
}
public String getCognome() {
	return cognome;
}
public void setCognome(String cognome) {
	this.cognome = cognome;
}
public String getEmail() {
	return email;
}
public void setEmail(String em) {
	 if (em.contains("@")) {
	        email = em;
	        System.out.println("\n Email inserita correttamente ! \n ") ; 
	    } else {
	        System.out.println("L'email non è valida. Assicurati di inserire un indirizzo email corretto.");
	    }
}
public String getIdGruppo() {
	return idGruppo;
}
public void setIdGruppo(String idGruppo) {
	this.idGruppo = idGruppo;
} 


public void creazioneAppuntamento (String id , Date dat ,Time ora , String note ,String codiceFiscale , String idTelefonata) {
	AppuntamentiDAO c = new AppuntamentiDAO() ; 
	c.creazioneAppuntamento(id,dat, ora, note, codiceFiscale,idTelefonata);
}

public void chiamaNumero (String idLista ) {// IDLISTA
	CentralinistaDAO c = new CentralinistaDAO() ; 
	c.chiamaNumero(idLista);
}

public void registraNote(String id_tel , String not) {
	CentralinistaDAO c = new CentralinistaDAO() ; 
	c.registraNote(id_tel , not) ; 
}


public void aggiungiCentralinista(String idCentr, String idgruppo){ 
	 CentralinistaDAO centr = new CentralinistaDAO(); 
	 centr.aggiungiCentralinista(idCentr, idgruppo); 
	}
public void RimuoviCentralinista(String idCentr) { 
	  CentralinistaDAO centr = new CentralinistaDAO(); 
	  centr.eliminaCentralinista(idCentr); 
	 }





}
