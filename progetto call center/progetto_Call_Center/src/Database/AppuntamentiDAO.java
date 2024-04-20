package Database;

import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
// MANCA UNA COSA : " COME FAR RIFERIRE A SE STESSO ?????  
import java.text.ParseException;
import java.text.SimpleDateFormat;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class AppuntamentiDAO {
	private String IdAppuntamento;
	private Date Data;
	private Time Ora;
	private String Note;
	private String id_codice_fiscale  ; // chiave esterna
	// MANCA ID_TELEFONATA 
	private String id_telefonata ; 
	public String getId_telefonata() {
		return id_telefonata;
	}

	public void setId_telefonata(String id_telefonata) {
		this.id_telefonata = id_telefonata;
	}

	public AppuntamentiDAO() {
		this.IdAppuntamento = "";
		this.Data = new Date(0);
		this.Ora = new Time(0);
		this.Note = "";
		this.id_codice_fiscale="" ;  
		this.id_telefonata="" ; 
	}
	// serve nell'atto della creazione
	public AppuntamentiDAO(String id , Date data , Time ora , String note , String id_codice , String telefonata ) {
		this.IdAppuntamento = id;
		this.Data = data;
		this.Ora = ora;
		this.Note = note ; 
		this.id_codice_fiscale= id_codice ;  
		this.id_telefonata=telefonata ; 
	}
	
	public AppuntamentiDAO(AppuntamentiDAO appuntamento) {
		this.IdAppuntamento = appuntamento.getID();
		this.Data = appuntamento.getData();
		this.Ora = appuntamento.getOra();
		this.Note = appuntamento.getNote();
		
	}
	
	public AppuntamentiDAO(String id) {
		this.IdAppuntamento = id;
		caricaDaDB();
		caricaCodiceFiscaleDaDB() ;  // DUBBI , SONO IO CHE COLLEGO L'APPUNTAMENTO !!!quindi non so 
	}
					
					public String getID() {
						return IdAppuntamento;
					}
					
					public void setID(String ID) {
						this.IdAppuntamento= ID;
					}
					
					public Date getData() {
						return Data;
					}
					
					
					public void setData(String date) {
						 String pattern = "dd/MM/yyyy"; 
					       SimpleDateFormat sdf = new SimpleDateFormat(pattern);
					       Date giorno = new Date() ;
					       try {
					            giorno = sdf.parse(date);
					           System.out.println("Data: " + date);
					       } catch (ParseException e) {
					           e.printStackTrace();       }
						this.Data = giorno;
					}
					
					public void setData(Date data) {
						this.Data = data;
					}
					
					public Time getOra() {
						return Ora;
					}
					
					public void setOra(String ora) {
						Ora = Time.valueOf(ora);
					}
					
					public void setOra(Time ora) {
						Ora = ora;
					}
					
					public String getNote() {
						return Note;
					}
					
					public void setNote(String note) {
						Note = note;
					}
	
	
					public String getId_codice_fiscale() {
						return id_codice_fiscale;
					}

					public void setId_codice_fiscale(String id_codice_fiscale) {
						if(id_codice_fiscale.length()==16) {
						this.id_codice_fiscale = id_codice_fiscale;
					}
						else {
							System.out.println(" il codice fiscale non e' valido") ; 
						}
					}

														// QUERY : 
														public void caricaDaDB() {
															String query = new String("SELECT * FROM appuntamenti WHERE idAppuntamento =" + this.IdAppuntamento);
															try {
																ResultSet rs = DBConnectionManager.selectQuery(query);
																if(rs.next()) {
																	this.setID(rs.getString("idAppuntamento"));
																	this.setData(rs.getString("Data"));
																	this.setOra(rs.getString("Ora"));
																	this.setNote(rs.getString("Note"));
																	this.setId_codice_fiscale(rs.getString("codice fiscale"));
																	this.setId_telefonata("idtelefonata") ; 
																}
															}catch(SQLException e){
																e.printStackTrace();
															}catch(ClassNotFoundException e) {
																e.printStackTrace();
															}
														}
														// CARICA CODICE FISCALE DA DB 
														public void caricaCodiceFiscaleDaDB() {
															String query = new String()  ; 
															
															try {
																ResultSet rs=DBConnectionManager.selectQuery(query) ; 																
																
															}
															catch(ClassNotFoundException | SQLException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}
																
															
														}
														

														// OPERAZIONI BASILARI : 
														// 1 INSERT 
														public void inserimentoAppuntamento (String id , Date data ,Time ora , String note , String codice , String telefonata ) {
															/*
														* 	private String ID;
														private Date Data;
														private Time Ora;
														private String Note;
														
																							*
									INSERT INTO appuntamenti VALUES ('1111', '07-apr-2023', TIMESTAMP '2023-07-07 09:15:00', 'sembra che ci stia', 'FLFLFFFFF1233FSA');

*/
															
										    String query = "INSERT INTO appuntamenti VALUES ('" + id + "', '" + data + "', TIMESTAMP '" + data + " " + ora + "', '" + note + "', '" + codice + "','"+telefonata+"')";

															    try {
															        DBConnectionManager.updateQuery(query);
															        System.out.println("Appuntamento inserito");
															    } catch (ClassNotFoundException e) {
															        e.printStackTrace();
															    } catch (SQLException e) {
															        e.printStackTrace();
															    }
															}

														// delete : 
														public void eliminaAppuntamenti (String id) {
															
															String query= new String("Delete from appuntamenti where IdAppuntamento ='" + id+ "'") ; 
																	
															
															try {
																
																DBConnectionManager.updateQuery(query) ;
																System.out.println("appuntamento eliminato") ;
																									
																
															}catch(ClassNotFoundException e) {
																e.printStackTrace();
															}catch(SQLException e){
																e.printStackTrace();
															}
															
														}
														
														
														// visualizza tutti appuntamenti
														public void visualizzaTuttiAppuntamenti() {

														String query= new String("select * from appuntamenti  " ) ;								
													
															try {
																
																ResultSet rs= DBConnectionManager.selectQuery(query) ;
																  while (rs.next()) {
															            String id = rs.getString("IdAppuntamento");
															            Date data  = rs.getDate("data") ; 
															            Time ora = rs.getTime("Ora") ; 
															            String note = rs.getString("note"); 
															            String codice = rs.getString("codiceFiscale") ; 
															            String telefonata= rs.getString("idtelefonata") ; 
															            System.out.println("ID: " + id + ", data: " + data + ", ora: " + ora+" , note"+ note +" , codice fiscale"+ codice+",telefonata"+telefonata+" \n");
															        }
																
																									
																
															}catch(ClassNotFoundException e) {
																e.printStackTrace();
															}catch(SQLException e){
																e.printStackTrace();
															}
															
															
														}
														
															// visualizza 1 appuntamento : 
															public void visualizzaAppuntamenti(String id ) {
																
																String query = new String( " select * from appuntamenti  where IdAppuntamento = " + id) ; 
																
																try {
																	
																	ResultSet rs= DBConnectionManager.selectQuery(query) ;
																	 if(rs.next()) {
																	String id_a=rs.getString("IdAppuntamento");
																	
															            Date data  = rs.getDate("data") ; 
															            Time ora = rs.getTime("Ora") ; 
															            String note = rs.getString("Note"); 
															            String codice = rs.getString("CodiceFiscale") ; 
															            String telefonata= rs.getString("IdTelefonata") ; 
															            System.out.println("ID: " + id_a+", data: " + data + ", ora: " + ora+" , note"+ note +" , codice fiscale"+ codice +",telefonata"+telefonata+" \n");
																	}
																	else {
																		System.out.println("L'id cercato non è presente ") ; 
																	}
																																											
																}catch(ClassNotFoundException e) {
																	e.printStackTrace();
																}catch(SQLException e){
																	e.printStackTrace();
																}
																	}
															
															
															// set note
															public void modificaNoteAppuntamenti ( String id , String note)
															{
																if(id.length()<1 || id.length()>5) {
																	System.out.println("\n errore id non valido \n ");
																}else {
																	System.out.println("\n id e' scelto : "+ id+" \n ");
																}
																if(note.length()>45) {
																	System.out.println("\n note troppo lunghe , riprova !\n "); 
																}else {
																	System.out.println(" \n note scelte :"+ note+" \n") ; 
																}
																
																
																String query = new String ("UPDATE Appuntamenti SET note ='"+ note+"' WHERE IdAppuntamento ='"+id+"'") ;
																
																try {
																	int risultato = DBConnectionManager.updateQuery(query) ; 
																	 if(risultato>0) {
																	
															            System.out.println("NOTE MODIFICATE:");
															            System.out.println("ID: " + id + ", note: " + note);
															           }else {
																		System.out.println(" l'id scelto è sbagliato , riprovare !") ; 
																	 }																				
																}catch(ClassNotFoundException |SQLException e) {
																	e.printStackTrace();
																	}														
															}
															
															public void visualizzaNoteAppuntamentiFissati ()
															{
																
																	String query = new String ("select a.note from appuntamenti a JOIN telefonate t on a.IdTelefonata=t.IdTelefonate AND t.Esito='Appuntamento fissato' ;") ; 
																	
																
																try {
																	ResultSet rs= DBConnectionManager.selectQuery(query) ;
																	 while(rs.next()) {
															            String note_1 = rs.getString("note"); 
															            System.out.println("NOTE: ") ; 
															            System.out.println(" note"+ note_1+" \n");
																	 }									        
																						
																	
																}catch(ClassNotFoundException e) {
																	e.printStackTrace();
																}catch(SQLException e){
																	e.printStackTrace();
																}
																
															}
															public void creazioneAppuntamento( String Id,Date Data,Time Ora,String Note) {
																
													String query = new String ("Insert into Appuntamenti values ('"+ Id +"','"+ Data +"', '"+Ora+"','"+Note +"')") ; 
																											
																
																try {
																	int rs= DBConnectionManager.updateQuery(query) ;
																	 if(rs>0) {
															           System.out.println(" \n appuntamento creato! \n") ;
																	 }else {
																		 System.out.println(" \n appuntamento non creato") ; 
																	 }
																						
																	
																}catch(ClassNotFoundException e) {
																	e.printStackTrace();
																}catch(SQLException e){
																	e.printStackTrace();
																}
																
															}
															public void creazioneAppuntamento (String id , Date dat ,Time ora , String note ,String codiceFiscale , String idTelefonata) { // RICORDA LE DEVI CONOSCERE , GLI ULTIMI DUE SONO CHIAVI ESTERNE !!
																AppuntamentiDAO app = new AppuntamentiDAO(id , dat , ora , note , codiceFiscale , idTelefonata) ; 
																
																
																//String query = "INSERT INTO appuntamenti  VALUES ('" + app.getID() + "','" + app.getData() + "','" + app.getOra() + "','" + app.getNote() +"','"+app.getId_codice_fiscale()+"','"+app.getId_telefonata()+"' ) ";	
																String query = "INSERT INTO appuntamenti VALUES ('" + app.getID() + "', '" + app.getData() + "', '" + app.getOra() + "', '" + app.getNote() + "', '" + app.getId_codice_fiscale() + "', '" + app.getId_telefonata() + "') ";

																try {
																	DBConnectionManager.updateQuery(query);
																	System.out.println("Creazione appuntamento avvenuta con successo");       
																} catch (SQLException e) {
																	e.printStackTrace();
																	System.out.println("Errore durante la creazione dell'appuntamento");
																} catch (ClassNotFoundException e) {
																	e.printStackTrace();
																	System.out.println("Errore durante la connessione al database.");
																}
															}
															
															
}



	/** 
		 * aggiuntive : 
		 * visualizzaNote appuntamento FISSATO ; 
		 * visualizza Appuntamenti 
		 * modifica note appuntamenti 
		 * visualizza TUTTI appuntamenti 
		 */


