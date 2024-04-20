package Database;

import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UtenteDAO {
	private String IdNumeroTelefonico ;
	private String IdLista ; 

	
	public UtenteDAO() {
		this.IdNumeroTelefonico= new String( ) ; 
	}
	public UtenteDAO(UtenteDAO utente) {
		this.IdNumeroTelefonico=utente.getIdNumeroTelefonico() ; 
		this.IdLista=utente.getIdLista() ; 
	}
	
	public UtenteDAO (String Id) {
		if(Id.length()==10) {
		this.IdNumeroTelefonico=Id ; 
		}else 
		{
			System.out.println("errore id non valido"); 
		}
		caricaDaDB() ; 
	}
	public UtenteDAO (String Id , String idL) {
		if(Id.length()==10) {
		this.IdNumeroTelefonico=Id ; 
		}else 
		{
			System.out.println("errore id non valido"); 
		}
		this.IdLista=idL ;  
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM Utenti WHERE IdNumeroTelefonico =" + this.IdNumeroTelefonico );
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
			
				this.setIdLista(rs.getString("Lista"));
				
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
		
	
	public String getIdLista() {
		return IdLista;
	}
	public void setIdLista(String idLista) {
		IdLista = idLista;
	}
	
	public String getIdNumeroTelefonico() {
		return IdNumeroTelefonico;
	}

	public void setIdNumeroTelefonico(String idNumeroTelefonico) {
		
		if(idNumeroTelefonico.length()== 10 ) {
		IdNumeroTelefonico = idNumeroTelefonico;
		}
		else {
			System.out.println("errore il numero inserito non è valido ") ; 
		}
		
	} 
	public int insert() {
		//String query = new String("INSERT INTO utenti VALUES ("+this.IdNumeroTelefonico+"','"+this.IdLista+"')"); where idlista = id 
		String query = "INSERT INTO utenti VALUES ('" + this.IdNumeroTelefonico + "','" + this.IdLista + "')";

		int ret=0;
		try {
			int ris=DBConnectionManager.updateQuery(query);
			 if (ris > 0) {
		            System.out.println("numero inserito ecco i dati : \n");
		            System.out.println("- numero : " + this.IdNumeroTelefonico + " \n - id lista " + this.IdLista + "\n");
		        } else {
		            System.out.println("\n errore numero non inserito");
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
	
	public int delete() {
		String query = new String("DELETE FROM utenti WHERE IdNumeroTelefonico= "+this.IdNumeroTelefonico);
		int ret=0;
		try {
			int ris =DBConnectionManager.updateQuery(query);
			if(ris>0) {
				System.out.println("\n utente eliminato ! \n"); 
			}
			else {
				System.out.println("\n Utente non eliminato ! \n ") ;
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
	public void visualizzaUtenti() {
		String query = new String("Select * from Utenti ") ;
		try {
			ResultSet rs= DBConnectionManager.selectQuery(query) ;
			System.out.println("\n elenco utenti : \n") ; 
			while(rs.next()) {
				String id=rs.getString("IdNumeroTelefonico") ;
				String lista=rs.getString("lista") ; 
				System.out.println("\n Id numero : "+ id +" lista "+ lista+" \n") ; 
				
				
			}
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}
	}
	
}
