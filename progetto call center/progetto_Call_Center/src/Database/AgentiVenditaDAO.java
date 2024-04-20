package Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import Database.DBConnectionManager;

public class AgentiVenditaDAO {
	private String idCodiceFiscale;
	private String nome;
	private String cognome;
	
	public AgentiVenditaDAO() {
		super();
	}
	
	public AgentiVenditaDAO(AgentiVenditaDAO a) {
		this.idCodiceFiscale=a.getIdCodiceFiscale();
		this.nome=a.getNome();
		this.cognome=a.getCognome();
	}
	
	public AgentiVenditaDAO(String CF) {
		this.idCodiceFiscale=CF;
		caricaDaDB();
	}
	
	
	
				public String getIdCodiceFiscale() {
					return idCodiceFiscale;
				}
				public void setIdCodiceFiscale(String idCodiceFiscale) {
					if(idCodiceFiscale.length()==16) {
					this.idCodiceFiscale = idCodiceFiscale;
					}
					else {
						System.out.println(" errore il codice fiscale inserito non è valido ") ; 
					}
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
									// QUERY 
									public void caricaDaDB() {
										String query= new String("SELECT * FROM agentivendita WHERE idCodiceFiscale=" +this.idCodiceFiscale);
										try {
											ResultSet rs= DBConnectionManager.selectQuery(query);
											if(rs.next()) {
												this.setNome(rs.getString("nome"));
												this.setCognome(rs.getString("cognome"));
											}
										}catch(ClassNotFoundException e) {
											e.printStackTrace();
										}catch(SQLException e){
											e.printStackTrace();
										}
									}
									// OPERAZIONI BASILARI : 
									// 1 INSERT 
									public void inserimentoAgentiVendita (String id , String nome , String cognome) {
										
										String query = new String (" INSERT into agentivendita values ('"+ id +"' ,' "+ nome+"','"+ cognome+"')") ; 
										
										try {
											
											DBConnectionManager.updateQuery(query) ;
											System.out.println("agente vendita inserito : \n - id codice : "+ id +" \n -nome :"+ nome+" \n -cognome :"+cognome +" \n") ;
																				
											
										}catch(ClassNotFoundException e) {
											e.printStackTrace();
										}catch(SQLException e){
											e.printStackTrace();
										}
									}
										// delete 
										public void eliminaAgentiVendita (String id ) {
											
											String query= new String("Delete from agentivendita where IdCodiceFiscale = '" + id+ "' , ") ; 
										
													
											
											try {
												
												DBConnectionManager.updateQuery(query) ;
												System.out.println("agente vendita eliminato") ;
																					
												
											}catch(ClassNotFoundException e) {
												e.printStackTrace();
											}catch(SQLException e){
												e.printStackTrace();
											}
											
										}
										
							
											// visualizza 1 agnete vendita
											public void visualizzaAgenteVendita(String nome ,String cognome ) {
												
												String query = new String( " select * from agentivendita  where nome =' " + nome + "' AND cognome=' " + cognome + " ' ; ");
												
												try {
													
													ResultSet rs= DBConnectionManager.selectQuery(query) ;
													  
												            String id_c = rs.getString("id");
												            String nome_a = rs.getString("nome");
												            String cognome_a = rs.getString("cognome");
												            
												            // Puoi fare qualcosa con i valori ottenuti, come stamparli
												            System.out.println("ID: " + id_c+ ", Nome: " + nome_a + ", Cognome: " + cognome_a);
												        
													
																						
													
												}catch(ClassNotFoundException e) {
													e.printStackTrace();
												}catch(SQLException e){
													e.printStackTrace();
												}
												
												
												
											}
											
											/** 
											 * aggiuntive : 
											 * visualizzaNote appuntamento FISSATO ; 
											 * visualizza Appuntamenti 
											 * modifica note appuntamenti 
											 * visualizza TUTTI appuntamenti 
											 */
										
										
										
										
										
									
									

}
