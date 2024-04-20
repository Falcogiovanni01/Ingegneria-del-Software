package Entity;

import java.sql.SQLException;
import java.util.ArrayList;

import Database.DBConnectionManager;
import Database.ListaDAO;

public class EntityLista {
	
	private String IdLista;
	private String IdGruppo ; 
	private ArrayList<EntityUtente> ListaNumeriTelefonici;
	
	public EntityLista() {
		super();
		ListaNumeriTelefonici = new ArrayList<EntityUtente>();
	}
	
	public EntityLista(String id , String g) {
		this.IdLista=id;
		this.IdGruppo=g ; 
	}
	
	public EntityLista(String id) {
		this.IdLista=id;
		this.IdGruppo=null;
	}
	//public EntityLista (ListaDAO l) 
	public String getIdLista() {
		return IdLista;
	}

	public void setIdLista(String idLista) {
		IdLista = idLista;
	}
	
	public String getIdGruppo() {
		return IdGruppo;
	}

	public void setIdGruppo(String idGruppo) {
		IdGruppo = idGruppo;
	}

	public ArrayList<EntityUtente> getListaNumeriTelefonici() {
		return ListaNumeriTelefonici;
	}

	public void setListaNumeriTelefonici(ArrayList<EntityUtente> listaNumeriTelefonici) {
		ListaNumeriTelefonici = listaNumeriTelefonici;
	}
	
	public void AggiungiUtente(String numero , String id) {
		ListaDAO lista = new ListaDAO();
		lista.AggiungiUtente(numero , id);
	}
	
	public void RimuoviUtente(String numero , String id) {
		ListaDAO lista=new ListaDAO();
		int ret=0;
		ret=lista.RimuoviUtente(numero , id);
		if(ret==0) {
			System.out.println("Rimozione numero avvenuta con successo!");
		}
	}
	
	public String ProssimoNumero() {
		ListaDAO listaDAO = new ListaDAO(this.IdLista);
		return listaDAO.ProssimoNumero();
	}
	public void CreazioneLista(String id, String numeri) {
		ListaDAO listaDAO = new ListaDAO();
		listaDAO.CreazioneLista(id, numeri);
	}
	public void RimozioneLista(String idLista) {
		ListaDAO lista = new ListaDAO();
					
			lista.setID(idLista);
			String query = new String("DELETE FROM utenti WHERE lista= '"+idLista+"'");
			
			try {
				int ris =DBConnectionManager.updateQuery(query);
				if(ris>0) {
					System.out.println("\n utenti eliminato ! \n"); 
					lista.delete();
				}
				else {
					System.out.println("\n Utente non eliminato ! \n ") ;
				}
			}catch(ClassNotFoundException e) {
				e.printStackTrace();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
					
	}
	
	public void AssegnaLista(String idlista, String idgruppo) { 
		  ListaDAO lista = new ListaDAO(); 
		  lista.update(idlista, idgruppo); 
		 }
	

}
