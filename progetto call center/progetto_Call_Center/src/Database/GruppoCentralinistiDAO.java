package Database;

import java.sql.ResultSet;
import java.sql.SQLException;


public class GruppoCentralinistiDAO {
	private String ID;
	private String Descrizione;
	
	public GruppoCentralinistiDAO() {
		this.ID = new String();
		this.Descrizione = new String();
	}
	
	public GruppoCentralinistiDAO(GruppoCentralinistiDAO GC) {
		this.ID = GC.getID();
		this.Descrizione = GC.getDescrizione();
	}
	
	public GruppoCentralinistiDAO(String id) {
		this.ID = id;
		caricaDaDB();
	}
	
	public void caricaDaDB() {
		String query = new String("SELECT * FROM gruppicentralinisti WHERE idGruppoCentralinisti ='" + this.ID+"'");
		try {
			ResultSet rs = DBConnectionManager.selectQuery(query);
			if(rs.next()) {
				this.setDescrizione(rs.getString("Descrizione"));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescrizione() {
		return Descrizione;
	}

	public void setDescrizione(String descrizione) {
		Descrizione = descrizione;
	}
	
	public void inserisciGruppo(GruppoCentralinistiDAO Gruppo) {
				String query = "INSERT INTO gruppicentralinisti (IdGruppoCentralinisti, descrizione) VALUES ('" + Gruppo.getID() + "', '" + Gruppo.getDescrizione();	
					try {
		         DBConnectionManager.updateQuery(query);
		      
		        System.out.println("Gruppo registrato con successo");       
		        
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la registrazione del gruppo");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la connessione al database.");
		    }
				}
				
		public void aggiornaGruppo(String Id, GruppoCentralinistiDAO nuovoGruppo) {
				String query = "UPDATE gruppicentralinisti SET  Descrizione = '" + nuovoGruppo.getDescrizione() + "', WHERE IdGruppo = " + Id;	
					try {
		        DBConnectionManager.updateQuery(query);
		        System.out.println("Dati gruppo aggiornati con successo");       
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante l'aggiornamento dei dati del gruppo");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la connessione al database.");
		    }
				}
			// QUERY : 
			/*1 INSERT -> fatto
			 * 2 UPDATE -> fatto
			 * 3 DELETE -> gruppo centralinista non può crearlo il gruppo stesso !
			 *
			 * 4 VISUALIZZA -> posso visualizzarmi da solo ? 
			 * 5 AGGIUNGI CENTRALINISTA-> fatto 
			 * 6 TOGLI CENTRALINISTA-> fatto
			 *		 * 
			 * 
			 * */
	
		
		public void aggiungiCentralinista(String idCentralinista , String nome , String cognome , String email) {
		    // Verifica se il centralinista esiste già nel gruppo
		    if (centralinistaEsisteNelGruppo(idCentralinista)) {
		        System.out.println("Il centralinista è già presente nel gruppo.");
		        return;
		    }

		    // Esegui l'operazione di aggiunta nel database
		    String query = "INSERT INTO Centralinisti  VALUES ('" + idCentralinista + "','" +nome + "','" + cognome + "','"+email+"','"+this.ID+"')";
		    try {
		        DBConnectionManager.updateQuery(query);
		        System.out.println("Centralinista aggiunto con successo al gruppo.");     
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante l'aggiunta del centralinista al gruppo.");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la connessione al database.");
		    }
		}

		public boolean centralinistaEsisteNelGruppo(String idCentralinista) {
		    String query = "SELECT * FROM Centralinisti WHERE IdCentralinista = '" + idCentralinista + "' AND IdGruppo = '" + this.ID + "'";
		    try {
		        ResultSet rs = DBConnectionManager.selectQuery(query);
		        return rs.next();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		    }
		    return false;
		}
		
		public void eliminaGruppo(String id) {
			
			String query= "DELETE FROM gruppicentralinisti where IdGruppoCentralinisti =  '" + id+"'" ; 
			try {
			 DBConnectionManager.updateQuery(query)  ; 
				System.out.println("Eliminazione avvenuta con successo") ; 
			}catch(SQLException e ) {
				e.printStackTrace() ;
				System.out.println("Errore durante l'eliminazione") ; 
			}catch(ClassNotFoundException e) {
				e.printStackTrace() ; 

				System.out.println("Errore durante la connesione al database ") ; 
			}	
			
		}
	
		public void eliminaCentralinista(String idcentralinista , String idgruppo ) {
			if(centralinistaEsisteNelGruppo(idcentralinista)) {
				System.out.println(" il centralinista esiste") ; 
			}
			else {

				System.out.println(" il centralinista NON esiste") ; 
			}
			String query= "DELETE FROM Centralinisti where IdGruppo = '"+ idgruppo+"'AND IdCentralinista= '"+idcentralinista+"'" ; 
			try {
				
			 DBConnectionManager.updateQuery(query)  ; 
				System.out.println("Eliminazione avvenuta con successo") ; 
			}catch(SQLException e ) {
				e.printStackTrace() ;
				System.out.println("Eliminazione NON avvenuta") ; 
			}catch(ClassNotFoundException e) {
				e.printStackTrace() ; 

				System.out.println("Errore durante la connesione al database ") ; 
			}
			
			
		}
		
		// VISUALIZZA : 
		public void visualizzaGruppi() {
			
			String query = " Select * from gruppiCentralinisti" ; 
			try {
				ResultSet rs = DBConnectionManager.selectQuery(query) ; 
				System.out.println("Visualizzazione  gruppi ") ;
				  while (rs.next()) {
		               String ID = rs.getString("idGruppoCentralinisti");
		           String    Descrizione = rs.getString("descrizione");
		           
		           System.out.println( " \n - id gruppo : " + ID + " \n - descrizione : +"+ Descrizione+ "\n") ; 
		               }
			}catch(SQLException e) {
				e.printStackTrace() ;
				System.out.println("Visualizzazione non avvenuta") ; 
			}catch(ClassNotFoundException e) {
				e.printStackTrace() ; 

				System.out.println("Errore durante la connesione al database ") ; 
			}
		}
		// VISUALIZZA : 
				public void visualizzaCentralinisti(String id) {
					
				//	String query = "SELECT * FROM gruppicentralinisti Where IdGruppo ='"+this.ID+"'" ; 
					String query = " Select * from Centralinisti Where iDGruppo = '"+id+"'" ; 
					try {
						ResultSet rs = DBConnectionManager.selectQuery(query) ; 
						System.out.println("Visualizzazione  Centralinisti nei gruppi ") ;
						  while (rs.next()) {
				               String ID = rs.getString("idCentralinista");
				           String    nome = rs.getString("nome");
				           String cognome = rs.getString("cognome") ; 
				           String email = rs.getString("email") ; 
				           String id_g = rs.getString("idgruppo") ; 
				           System.out.println( " \n - id centralino : " + ID + " \n - nome: "+ nome+"\n -cognome : "+cognome+"\n -email "+email+" \n -id gruppo:"+ id_g+"\n") ; 
				               }
					}catch(SQLException e) {
						e.printStackTrace() ;
						System.out.println("Visualizzazione non avvenuta") ; 
					}catch(ClassNotFoundException e) {
						e.printStackTrace() ; 

						System.out.println("Errore durante la connesione al database ") ; 
					}
				}
				

				public void inserisciGruppo() {
					String query = "INSERT INTO gruppicentralinisti  VALUES ('" + this.ID + "','"
							+ this.Descrizione + "')";
					try {
						DBConnectionManager.updateQuery(query);

						System.out.println("Gruppo registrato con successo");

					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Errore durante la registrazione del gruppo");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();
						System.out.println("Errore durante la connessione al database.");
					}
				}
				
				public void eliminaGruppo() {

					String query = "DELETE FROM gruppicentralinisti where IdGruppoCentralinisti =  '" + this.ID + "'";
					try {
						DBConnectionManager.updateQuery(query);
						System.out.println("Eliminazione avvenuta con successo");
					} catch (SQLException e) {
						e.printStackTrace();
						System.out.println("Errore durante l'eliminazione");
					} catch (ClassNotFoundException e) {
						e.printStackTrace();

						System.out.println("Errore durante la connesione al database ");
					}

				}
				
}
