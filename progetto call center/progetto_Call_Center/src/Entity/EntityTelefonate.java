package Entity;
import Database.AppuntamentiDAO;
import Database.TelefonateDAO ; 
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
public class EntityTelefonate {

private String IdTelefonata ; 
private Date data ;
private LocalTime ora ; 
private String note ; 
private String Esito  ;
private String id_centralinista ; 
private String numero ;

public  EntityTelefonate() {
	super()  ; 
}
public EntityTelefonate (String id  ,Date dat, LocalTime ore , String not , String esito , String centralinista , String tel) {
	this.IdTelefonata=id ; 
	this.data=dat  ; 
	this.ora=ore  ; 
	this.note=not ; 
	this.Esito= esito ; 
	this.id_centralinista=centralinista ; 
	this.numero=tel ; 
}
public EntityTelefonate(TelefonateDAO tel) {
	this.IdTelefonata=tel.getIdTelefonata() ; 
	this.data=tel.getData()  ; 
	this.ora=tel.getOra()  ; 
	this.note=tel.getNote() ; 
	this.Esito=tel.getEsito() ; 
	this.id_centralinista=tel.getId_centralinista() ; 
	this.numero=tel.getIdTelefonata() ; 
}

public EntityTelefonate(String id) {
	TelefonateDAO tel = new TelefonateDAO(id) ;
	this.IdTelefonata=tel.getIdTelefonata() ; 
	this.data=tel.getData()  ; 
	this.ora=tel.getOra()  ; 
	this.note=tel.getNote() ; 
	this.Esito=tel.getEsito() ; 
	this.id_centralinista=tel.getId_centralinista() ; 
	this.numero=tel.getIdTelefonata() ; 
}

public String getIdTelefonata() {
	return IdTelefonata;
}
public void setIdTelefonata(String idTelefonata) {
	IdTelefonata = idTelefonata;
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
public LocalTime getOra() {
	return ora;
}
public void setOra(LocalTime ora) {
	this.ora = ora;
}
public String getNote() {
	return note;
}
public void setNote(String note) {
	this.note = note;
}
public String getEsito() {
	return Esito;
}
public void setEsito(String esito) {
	TelefonateDAO tel = new TelefonateDAO() ; 
	tel.setEsito(esito) ; 
	this.Esito=tel.getEsito() ; 


}
public String getId_centralinista() {
	return id_centralinista;
}
public void setId_centralinista(String id_centralinista) {
	this.id_centralinista = id_centralinista;
}
public String getNumero() {
	return numero;
}
public void setNumero(String numero) {
	if(numero.length()==10) {
	this.numero = numero;
	}
	else {
		System.out.println(" errore il numero inserito non e' valido \n ") ; 
  	}
}


public void registrazioneEsito ( String id , String esito) {
	TelefonateDAO e = new TelefonateDAO() ; 
	e.registrazioneEsito(id, esito);
}

public void registrazioneNote(String id , String note) {
	TelefonateDAO e = new TelefonateDAO() ; 
	e.registrazioneNote(id, note);
}


}
