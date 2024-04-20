package Entity;

import java.sql.ResultSet;
import java.sql.SQLException;

import Database.*;

public class EntityGruppiCentralinisti {
	private String ID;
	private String Descrizione;
	
	public EntityGruppiCentralinisti() {
		super();
	}
	
	public EntityGruppiCentralinisti(String Id) {
		GruppoCentralinistiDAO gruppocentralinisti= new GruppoCentralinistiDAO(Id);
		this.ID = gruppocentralinisti.getID();
		this.Descrizione = gruppocentralinisti.getDescrizione();
	}
	
	public EntityGruppiCentralinisti(GruppoCentralinistiDAO gruppocentralinisti) {
		ID = gruppocentralinisti.getID();
		Descrizione = gruppocentralinisti.getDescrizione();
	}
	public EntityGruppiCentralinisti(String id, String d) {
	    this.ID = id;
	    this.Descrizione = d;
	  }
	public String getID() {
		return ID;
	}

	public void setID(String Id) {
		ID = Id;
	}
	
	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	public void AggiungiCentralinista(String idCentralinista , String nome , String cognome , String email ) {
	GruppoCentralinistiDAO gc = new GruppoCentralinistiDAO() ; 
	gc.setID("2222");
	gc.aggiungiCentralinista(idCentralinista, nome, cognome, email);
		}
	public void eliminaCentralinista(String idcentralinista , String idgruppo) {
		GruppoCentralinistiDAO gc= new GruppoCentralinistiDAO() ;
		gc.eliminaCentralinista(idcentralinista, idgruppo);
	}
	public void visualizzaGruppi() {
		GruppoCentralinistiDAO gc = new GruppoCentralinistiDAO() ; 
		gc.setID("1111");
		gc.visualizzaGruppi();
	}
	public void visualizzaCentralinisti(String id) {
		GruppoCentralinistiDAO gc = new GruppoCentralinistiDAO() ; 
		gc.setID("1111");
		gc.visualizzaCentralinisti("1111");
	}

	public void CreazioneGruppo(String id, String Descrizione) {
		GruppoCentralinistiDAO gruppoDAO = new GruppoCentralinistiDAO();
		gruppoDAO.setID(id);
		gruppoDAO.setDescrizione(Descrizione);
		gruppoDAO.inserisciGruppo();
	}

	public void RimozioneGruppo(String id) {
		GruppoCentralinistiDAO gruppoDAO = new GruppoCentralinistiDAO(id);
		gruppoDAO.eliminaGruppo();
	}
	
}


