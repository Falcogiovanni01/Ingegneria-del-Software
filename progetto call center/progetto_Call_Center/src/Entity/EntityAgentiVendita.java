package Entity;

import Database.*;
import Database.AgentiVenditaDAO;
public class EntityAgentiVendita {
	private String idCodiceFiscale;
	private String nome;
	private String cognome;
	
	public EntityAgentiVendita() {
		super();
	}
	
	public EntityAgentiVendita(String id_codice) {
	
		AgentiVenditaDAO agente= new AgentiVenditaDAO(id_codice); 
		 
		
		this.idCodiceFiscale=agente.getIdCodiceFiscale()  ; 
		this.nome=agente.getNome() ; 
		this.cognome=agente.getCognome() ; 
		
	}
	
	public EntityAgentiVendita (AgentiVenditaDAO agente) {
		this.idCodiceFiscale=agente.getIdCodiceFiscale() ; 
		this.nome=agente.getNome() ; 
		this.cognome=agente.getCognome() ; 
		}

	public String getIdCodiceFiscale() {
		return idCodiceFiscale;
	}

	public void setIdCodiceFiscale(String idCodiceFiscale) {
		this.idCodiceFiscale = idCodiceFiscale;
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
	@Override
	public String toString() {
		return "EntityAgenteVendita [Codice Fiscale =" + idCodiceFiscale + ", nome=" + nome + ", cognome=" + cognome + "] \n";
	}

						
						public void  visualizzaTuttiAppuntamenti() {
							AppuntamentiDAO appuntamenti = new AppuntamentiDAO() ;
							appuntamenti.visualizzaTuttiAppuntamenti();
							
						}
						public void visualizzaAppuntamenti (String id) {
							AppuntamentiDAO appuntamenti = new AppuntamentiDAO() ; 
							appuntamenti.visualizzaAppuntamenti(id);
						}
						public void modificaNoteAppuntamenti (String id , String note) {
							AppuntamentiDAO appuntamenti = new AppuntamentiDAO () ; 
							appuntamenti.modificaNoteAppuntamenti(id, note);
						}
						
						public void visualizzNoteAppuntamentiFissati () {
							// Per visualizzare le note appuntamento fissato devo passare solo la chiamata che mi interessa 
							// perchè chiave esterna che collega gli appuntamenti alle telefonate !
							// oppure visualizzo tutte le note con appuntamenti fissati richiamando solo la funzione !
							
							AppuntamentiDAO appuntamenti = new AppuntamentiDAO() ; 
							appuntamenti.visualizzaNoteAppuntamentiFissati();
							
							
							
						}
	
}

