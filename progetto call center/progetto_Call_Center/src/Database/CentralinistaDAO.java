
package Database ; 
import java.sql.ResultSet;
import java.util.Scanner ; 
import java.util.Date ; 
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.sql.Time;
import org.junit.Test;

import Database.ListaDAO ; 
import Database.UtenteDAO ;
import Entity.EntityUtente;
import Database.GruppoCentralinistiDAO ;
import Database.AppuntamentiDAO;


public class CentralinistaDAO {
	private String IdCentralinista;
	private String Nome;
	private String Cognome;
	private String Email;
	private String idgruppo;
	
	public CentralinistaDAO() {
		this.IdCentralinista= new String();
		this.Nome= new String();
		this.Cognome= new String();
		this.Email= new String();
		this.setIdgruppo(new String());
	}
	
	public CentralinistaDAO(CentralinistaDAO Centralinista) {
		this.IdCentralinista=Centralinista.getIdCentralinista();
		this.Nome=Centralinista.getNome();
		this.Cognome=Centralinista.getCognome();
		this.Email=Centralinista.getEmail();
	}
	
	public CentralinistaDAO(String id) {
		this.IdCentralinista=id;
		caricaDaDB();
	}
	
				public void caricaDaDB() {
					String query = new String("SELECT * FROM centralinisti WHERE idCentralinista =" +this.IdCentralinista);
					try {
						ResultSet rs= DBConnectionManager.selectQuery(query);
						if(rs.next()) {
							this.setNome(rs.getString("Nome"));
							this.setCognome(rs.getString("Cognome"));
							this.setEmail(rs.getString("Email"));
							this.setIdgruppo(rs.getString("Idgruppo"));
						}
					}catch(SQLException e){
						e.printStackTrace();
					}catch(ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
				
	public String getIdCentralinista() {
		return IdCentralinista;
	}

	public void setIdCentralinista(String iD) {
		IdCentralinista = iD;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getCognome() {
		return Cognome;
	}

	public void setCognome(String cognome) {
		Cognome = cognome;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		 if (email.contains("@")) {
		        Email = email;
		        System.out.println("\n Email inserita correttamente ! \n ") ; 
		    } else {
		        System.out.println("L'email non è valida. Assicurati di inserire un indirizzo email corretto.");
		    }
	}
	
	public String getIdgruppo() {
		return idgruppo;
	}

	public void setIdgruppo(String idGruppo) {
		idgruppo = idGruppo;
	}
					 // QUERY : 
			// INSERT -> FATTO
			// CREATE -> FATTO
			// DELETE -> FATTO
			// UPDATE -> FATTO
	
	public void inserisciCentralinista(CentralinistaDAO Centralinista, String idG) { // dovrà essere richiamata !!!
				String query = "INSERT INTO centralinista (idCentralinista, Nome, Cognome, Email) VALUES ('" + this.IdCentralinista + "', '" + this.Nome + "', " + this.Cognome + "," + this.Email;	
					try {
		        DBConnectionManager.updateQuery(query);
		        aggiungiCentralinista(this.IdCentralinista, idG);
		        System.out.println("Centralinista registrato con successo");       
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la registrazione del centralinista");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la connessione al database.");
		    }
				}
				
	public void creaTabella(GruppoCentralinistiDAO GC) { // Dovrebbe essere inutile
				String query = "CREATE TABLE centralinista (idCentralinista VARCHAR(5), Nome VARCHAR(45), Cognome VARCHAR(45), Email VARCHAR(45),PRIMARY KEY (idCentralinista), CONSTRAINT FK_Gruppo FOREIGN KEY (" + GC.getID() +") REFERENCES gruppocentralinisti(" + GC.getID() + ") )";
					try {
		        DBConnectionManager.updateQuery(query);
		        System.out.println("Tabella creata con successo");       
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la creazione della tabella");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la connessione al database.");
		    }
				}
	
	public void aggiungiCentralinista(String id, String idgruppo) { // dovrà essere richiamata
		
		String query ="UPDATE centralinisti SET idgruppo = '" + idgruppo + "' WHERE idCentralinista = '" + id+"'";	
		try {
			DBConnectionManager.updateQuery(query);
			System.out.println("Centralinista associato con successo");       
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Errore durante l'associazione del centralinista");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.out.println("Errore durante la connessione al database.");
		}
	}
	 
	public void eliminaCentralinista(String idcentralinista) { 
			
			String query= "DELETE FROM centralinisti where idCentralinista = '"+ idcentralinista+"'" ; 
			try {
			 int rit =DBConnectionManager.updateQuery(query)  ; 
			 if(rit>0) {
				System.out.println("Eliminazione avvenuta con successo") ; 
			 }else {
				 System.out.println("\n Eliminazione non avvenuta") ; 
			 }
			}catch(SQLException e ) {
				e.printStackTrace() ;
				System.out.println("Errore durante l'eliminazione") ; 
			}catch(ClassNotFoundException e) {
				e.printStackTrace() ; 

				System.out.println("Errore durante la connesione al database ") ; 
			}	
			
		}
		
	public void aggiornaCentralinista(String Id, CentralinistaDAO nuovoCentralinista) {
				String query = "UPDATE centralinista SET  Nome = '" + this.Nome + "', " + "Cognome = " + this.Cognome + "," + "Email = " + this.Email + ", WHERE idCentralinista = " + Id;	
					try {
		        DBConnectionManager.updateQuery(query);
		        System.out.println("Dati centralinista aggiornati con successo");       
		    } catch (SQLException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante l'aggiornamento dei dati del centralinista");
		    } catch (ClassNotFoundException e) {
		        e.printStackTrace();
		        System.out.println("Errore durante la connessione al database.");
		    }
				}
	public void chiamaNumero(String idLista ) // perchè il centralinista " conosce " la sua lista e inserisce solo l'id della lista 
	{
		ListaDAO l = new ListaDAO()  ; 
		
		  String query2 = new String("SELECT IdLista FROM liste WHERE idgruppoCentralinisti = (SELECT idgruppo FROM centralinisti WHERE idCentralinista= '"+IdCentralinista+"')"); 
		  String iD = new String(); 
		  try{ 
		   ResultSet rs=DBConnectionManager.selectQuery(query2); 
		   if(rs.next()){ 
		    iD=rs.getString("IdLista"); 
		    System.out.println(" \n idLista : "+ iD + " \n ") ; 
		   } 
		  }catch (SQLException e) { 
		   e.printStackTrace(); 
		   System.out.println("Errore durante l'aggiornamento dei dati del centralinista"); 
		  } catch (ClassNotFoundException e) { 
		   e.printStackTrace(); 
		   System.out.println("Errore durante la connessione al database."); 
		  } 
		l.setID(idLista);
		l.caricaListaDB();
		String next = l.ProssimoNumero() ; 
		System.out.println("\n chiamo il numero : "+ next+"\n ") ; 
	
		
		// devo creare l'oggetto e passargli io l'id : id = random()
		System.out.println(" \n inserisci l'id della chiamata : \n " ) ;
		Scanner input1 = new Scanner(System.in) ; 
		String id= input1.nextLine(); 
				System.out.println(" \n inserisci l'esito della chiamata : \n ") ; 
				Scanner input2 = new Scanner(System.in) ; 
				String esito = input2.nextLine(); 
		String query = new String ("insert into telefonate (Idtelefonate) values ('"+id+"')") ; 
		try {
			
			 DBConnectionManager.updateQuery(query) ;
			System.out.println("\n telefonata creata  \n - id :"+ id +" \n") ;   
									        
																													
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e){
			e.printStackTrace();
		}
		TelefonateDAO  tel = new TelefonateDAO() ;
		tel.setIdTelefonata(id);
		
		Date currentDate = new Date();
		LocalTime tempo = LocalTime.now(); 
		tel.setData(currentDate);
		tel.setOra(tempo);
		tel.setId_centralinista(this.IdCentralinista);
		tel.setNumero(next);
		//  --- REGISTRAZIONE ESITO 
		tel.registrazioneEsito(id , esito );
		

		Date dateString = tel.getData();
	
		SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				try {
				   
				    String formattedDate = outputFormat.format(dateString);
				    String query1 = "UPDATE telefonate SET IdTelefonate = '" + tel.getIdTelefonata() + "', Data = '" + formattedDate + "', Ora = '" + tel.getOra() + "', Note = 'funziona', Esito = '" + tel.getEsito() + "', Id_centralinista = '" + tel.getId_centralinista() + "', Id_Numero = '" + tel.getNumero() + "' WHERE IdTelefonate = '" + tel.getIdTelefonata() + "'";

				
				int rit = DBConnectionManager.updateQuery(query1) ;
				if(rit>0) {
				System.out.println("\n telefonata creato :   \n "+tel.getIdTelefonata()+"','"+formattedDate+"','"+tel.getOra()+"','funziona','"+tel.getId_centralinista()+"','"+tel.getNumero()+"' \n") ; 
				}else {
					System.out.println(" \n errore telefonata non creato \n ") ; 
				}
				
				}catch(ClassNotFoundException e) {
				e.printStackTrace();
			}catch(SQLException e){
				e.printStackTrace();
			}
	}	
		
			public void registraNote(String id_Telefonata , String note)
			{
				TelefonateDAO t = new TelefonateDAO() ; 
				t.setIdTelefonata(id_Telefonata);
				t.registrazioneNote(t.getIdTelefonata(), note);
			
			}
	
	public boolean RicercaNumero(ArrayList<EntityUtente> l, String n) {
		
		for(int i = 0; i<l.size(); i++){
			if(l.get(i).equals(n))	return true;
		}
		return false;
	}	

}