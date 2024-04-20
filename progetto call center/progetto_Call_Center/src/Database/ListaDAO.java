package Database;
import java.util.Iterator ; 
import java.util.ArrayList;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entity.EntityLista;
import Entity.EntityUtente;
public class ListaDAO{
	private String ID;
	private ArrayList<EntityUtente> ListaNumeriTelefonici;
	private ArrayList <UtenteDAO> lista ; 
	private String IdGruppo;
	
	public ListaDAO() {
		super();
		this.ListaNumeriTelefonici= new ArrayList<EntityUtente>();
		this.lista=new ArrayList<UtenteDAO>() ; 
	}
	
	public ListaDAO(ListaDAO LDAO) {
		this.ID=LDAO.getID();
		this.ListaNumeriTelefonici=LDAO.getListaNumeriTelefonici();
		this.IdGruppo=LDAO.getIdGruppo();
	}
	
	public ListaDAO(String id) {
		this.ID=id;
		caricaDaDB();
		caricaListaDB() ; 
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT idNumeroTelefonico FROM utenti WHERE Lista = '" +this.ID+"'");
		String query2 = new String("SELECT idgruppo FROM liste WHERE idLista = '"+this.ID+"'");
		try {
			ResultSet rs=DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				EntityUtente utente= new EntityUtente(rs.getString("idNumeroTelefonico"));
				this.ListaNumeriTelefonici.add(utente);
			}
			rs=DBConnectionManager.selectQuery(query2);
			if(rs.next()) {
				this.IdGruppo=rs.getString("idgruppo");
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void caricaListaDB() {
		String query = new String("SELECT idNumeroTelefonico FROM utenti WHERE Lista ='" +this.ID+"'");
		
		try {
			ResultSet rs=DBConnectionManager.selectQuery(query);
			while(rs.next()) {
				UtenteDAO utente= new UtenteDAO(rs.getString("idNumeroTelefonico"));
				this.lista.add(utente);
				
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	
 public ArrayList<UtenteDAO> getLista() {
		return lista;
	}

	public void setLista(ArrayList<UtenteDAO> lista) {
		this.lista = lista;
	}
	public void stampaLista() {
		
		    int i = 0;
		    Iterator<UtenteDAO> iterator = lista.iterator(); // Ottieni un iteratore per la lista
		    while (iterator.hasNext()) {
		        UtenteDAO elemento = iterator.next(); // Ottieni l'elemento corrente dall'iteratore
		        System.out.println("Elemento " + i + " della lista: " + elemento.getIdNumeroTelefonico());
		        i++;
		    }
		}

	

    public int RimuoviUtente(String utente , String id_lista) {// testa
		UtenteDAO u= new UtenteDAO(utente, id_lista );
		int ret= u.delete();
		return ret;
	}
	
	public void insert() {
		String query = new String("INSERT INTO liste VALUES ("+this.ID+"','"+this.IdGruppo+"')");  // lui gki passa l 'id e il gruppo 
		//int ret=0;
		try {
			int ris=DBConnectionManager.updateQuery(query);
			if(ris>0) {
			System.out.println("Lista aggiunta \n") ;
			}
			else {
				System.out.println("\n Lista non aggiunta \n ") ; 
			}
		}catch(ClassNotFoundException e) {
			
			//ret=-1;
			e.printStackTrace();
		}catch(SQLException e) {
			//ret=-1;
			e.printStackTrace();
		}
	//	return ret;
	}
	
	public int delete() {
		String query = new String("DELETE FROM liste WHERE IdLista= '"+this.ID+"'");
		int ret=0;
		try {
			int ris = DBConnectionManager.updateQuery(query);
			if(ris>0) {
				System.out.println("Lista eliminata \n") ;
				}
				else {
					System.out.println("\n Lista non eliminata \n ") ; 
				}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			ret=-1;
		}catch(SQLException e) {
			e.printStackTrace();
			ret=-1;
		}
		return ret;
	}
	
	public int update(String idlista, String idnuovogruppo) { 
		int ret = 0; 
		if(idlista.length()<1 || idlista.length()>5) {
			System.out.println(" \n errore id lista non valida \n ") ; 
			ret=-1 ; 
		}else {
		System.out.println( "\n id lista valida \n ") ; 
		}
		if(idnuovogruppo.length()<1 || idnuovogruppo.length()>5) {
			System.out.println(" \n errore id gruppo non valido \n ") ; 
			ret=-1 ; 
		}else {
		System.out.println( "\n id lista valido \n ") ; 
		}
		  String query = new String("UPDATE liste SET idgruppocentralinisti = '" + idnuovogruppo + "' WHERE idLista= '" + idlista + "'"); 
		  try { 
		   int ris = DBConnectionManager.updateQuery(query); 
		   if (ris > 0) { 
		    System.out.println("Lista aggiornata :\n"); 
		    System.out.println(" \n ID nuovo : " + idnuovogruppo); 
		   } else { 
		    System.out.println("\n Lista non aggiornata \n "); 
		   } 
		  } catch (ClassNotFoundException | SQLException e) { 
		   ret = -1; 
		   e.printStackTrace(); 
		  } 
		  return ret; 
		 }
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		ID = iD;
	}


	public ArrayList<EntityUtente> getListaNumeriTelefonici() {
	return ListaNumeriTelefonici;
	}

	public void setListaNumeriTelefonici(ArrayList<EntityUtente> listaNumeriTelefonici) {
	ListaNumeriTelefonici = listaNumeriTelefonici;
	}
	
	public String getIdGruppo() {
		return IdGruppo;
	}
	
	public void setIdGruppo(String iD) {
		IdGruppo = iD;
	}
	
	public void visualizzaListe() {
	
		String query = new String("select * from Liste ") ; 
		try {ResultSet rs = DBConnectionManager.selectQuery(query) ; 
			while(rs.next())
			{
				String id_l= rs.getString("IdLista") ;
				String id_g= rs.getString("idGruppoCentralinisti") ; 
				System.out.println("\n id_lista = "+id_l +" id centralinista "+ id_g+" \n") ;
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {			
			e.printStackTrace();
		}
		
	}
	public void visualizzaLista(String idLista) {
		
		String query=new String(" select * from utenti where lista = '"+ idLista+"'") ; 
		try {ResultSet rs = DBConnectionManager.selectQuery(query) ;
		System.out.println("\n ELENCO : \n") ; 
		while(rs.next())
		{
			String id_l= rs.getString("IdNumeroTelefonico") ;
			String id_g= rs.getString("Lista") ; 
			System.out.println("\n id_lista = "+id_l +" id centralinista "+ id_g+" \n") ;
		}
	}catch(ClassNotFoundException e) {
		e.printStackTrace();
	}catch(SQLException e) {			
		e.printStackTrace();
	}
	}
	
	
	public void AggiungiUtente(String utente , String id) { //
		UtenteDAO u = new UtenteDAO (utente, id) ;  // UTENTE ID 
	    int ret = u.insert(); 
	    EntityUtente ut = new EntityUtente(utente , id) ; 
	    this.ListaNumeriTelefonici.add(ut);
	    if(ret==0)
	    	System.out.println(" \n utente aggiunto ! \n") ; 
	}

	public String ProssimoNumero() {
		    String next = "";
		    if (!lista.isEmpty()) {
		        next = lista.get(0).getIdNumeroTelefonico();
		       lista.remove(0);
		        UtenteDAO utente = new UtenteDAO(next);
		       
		        lista.add(utente);
		        System.out.println("\n il prossimo numero e':"+next+"\n") ; 
		         
		    }
		    return next;
		}
	
	public void CreazioneLista(String id, String listaNumeri) {
		String query = new String("INSERT INTO liste (IdLista) VALUES ('" + id + "')");
		int ret = 0;
		try {
			ret = DBConnectionManager.updateQuery(query);
			if (ret > 0) {
				System.out.println("Lista creata\n");
				this.AggiungiUtente(listaNumeri, id);
			} else {
				System.out.println("\n Lista non creata \n ");
			}	
		} catch (ClassNotFoundException e) {
			ret = -1;
			e.printStackTrace();
		} catch (SQLException e) {
			ret = -1;
			e.printStackTrace();
		}
	}
	
	
public void AssegnaLista(String id_lista , String id_gruppo) {
		if(id_lista.length()<1 || id_lista.length()>5) {
			System.out.println(" \n errore id lista non valida \n ") ; 
		}else {
		System.out.println( "\n id lista valida \n ") ; 
		}
		if(id_gruppo.length()<1 || id_gruppo.length()>5) {
			System.out.println(" \n errore id gruppo non valido \n ") ; 
		}else {
		System.out.println( "\n id lista valido \n ") ; 
		}
		
	 String query = new String("UPDATE liste SET idgruppocentralinisti = '" + id_gruppo + "' WHERE idLista= '" + id_lista + "'"); 
			 
			  try { 
			   int ris = DBConnectionManager.updateQuery(query); 
			   if (ris > 0) { 
			    System.out.println("Lista aggiornata :\n"); 
			    System.out.println(" \n ID nuovo : " + id_gruppo); 
			   } else { 
			    System.out.println("\n Lista non aggiornata \n "); 
			   } 
			  } catch (ClassNotFoundException e) { 
			   e.printStackTrace(); 
			  } catch (SQLException e) { 
			   e.printStackTrace(); 
			  } 
}	
}



