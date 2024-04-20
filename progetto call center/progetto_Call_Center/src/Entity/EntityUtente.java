package Entity;

import Database.UtenteDAO;

public class EntityUtente {
	private String NumeroTelefonico;
	private String idLista ; 
	
	public EntityUtente() {
		super();
	}
	public EntityUtente(String id , String g) {
		this.NumeroTelefonico=id;
		this.idLista=g ; 
	}

	public EntityUtente(String Numero) {
		UtenteDAO utente= new UtenteDAO(Numero);
		this.NumeroTelefonico=utente.getIdNumeroTelefonico();
		this.idLista=utente.getIdLista() ; 
	}
	
	public EntityUtente(UtenteDAO utente) {
		NumeroTelefonico=utente.getIdNumeroTelefonico();
		idLista=utente.getIdLista() ; 
	}

	public String getNumeroTelefonico() {
		return NumeroTelefonico;
	}

	public void setNumeroTelefonico(String numeroTelefonico) {
		NumeroTelefonico = numeroTelefonico;
	}
	public String getIdLista() {
		return idLista;
	}

	public void setIdLista(String idLista) {
		this.idLista = idLista;
	}

	public int insert() {
		int ret=0;
		UtenteDAO u = new UtenteDAO(this.NumeroTelefonico)  ; 
		ret=u.insert() ; 
		return ret;
	}

}
