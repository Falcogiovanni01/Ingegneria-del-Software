package Database;
import java.util.Scanner ; 
import java.util.Date ; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate ; 
import java.time.LocalTime; 
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;



public class TelefonateDAO {

private String IdTelefonata ; 
private Date data ;
private LocalTime ora ; 
private String note ; 
private String Esito  ;
private String id_centralinista ; 
private String numero ; 
	public TelefonateDAO() {
		this.IdTelefonata= new String( ) ; 
		this.data= new Date(0)  ; 
		this.ora=LocalTime.now() ;  
		this.note= new String() ; 
		this.Esito= new String() ; 
	}
	public TelefonateDAO (TelefonateDAO  telefonata) {
		this.IdTelefonata=telefonata.getIdTelefonata() ; 
	 
		this.data= telefonata.getData() ;   
		this.ora=telefonata.getOra() ;  
		this.note= telefonata.getNote() ; 
		this.Esito= telefonata.getEsito(); 
		this.id_centralinista= telefonata.getId_centralinista()  ; 
		this.numero = telefonata.getNumero() ; 
		}
	public TelefonateDAO ( String t , Date d , LocalTime o , String n , String e , String c , String num ) {
		this.IdTelefonata=t ; 
	 
		this.data= d ;   
		this.ora= o ;  
		this.note= n ; 
		this.Esito= e; 
		this.id_centralinista= c  ; 
		this.numero = num ; 
		}
	
	
	
	public TelefonateDAO  (String Id) {
		this.IdTelefonata=Id ; 
		caricaDaDB() ;
	}


			public String getIdTelefonata() {
				return IdTelefonata;
			}
			public void setIdTelefonata(String idTelefono) {
				IdTelefonata = idTelefono;
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
				this.data = giorno;
			}
			
			public void setData(Date date) {
				this.data = date;
			}
			public Date getData() {
				return data;
			}
			
			public LocalTime getOra() {
				return ora;
			}
			public void setOra(LocalTime ora) {
				this.ora = ora;
			}
			public String getNote() {
				return note;
			}
			public void setNote(String note) {
				this.note = note;
			}
			public String getEsito() {
				return Esito;
			}
			public void setEsito(String esito) {
			
			     
			this.Esito=esito ; 
			} 
			public String getId_centralinista() {
				return id_centralinista;
			}
			public void setId_centralinista(String id_centralinista) {
				this.id_centralinista = id_centralinista;
			}
			public String getNumero() {
				return numero;
			}
			public void setNumero(String numero) {
				this.numero = numero;
			}
				
				
			

			

							public void caricaDaDB() {
								
								String query = new String("SELECT * FROM telefonate WHERE idTelefonate =" +this.IdTelefonata);
									try {
										ResultSet rs= DBConnectionManager.selectQuery(query);
										if(rs.next()) {
											this.setData(rs.getString("Data"));
											this.setOra(LocalTime.parse(rs.getString("Ora")));
											this.setNote(rs.getString("Note"));
											this.setEsito(rs.getString("Esito")) ; 
											this.setId_centralinista(rs.getString("id_centralinista")) ; 
											this.setNumero(rs.getString("numero"));
										}
									}catch(SQLException e){
										e.printStackTrace();
									}catch(ClassNotFoundException e) {
										e.printStackTrace();
									}
								}
							
								// QUERY : 
							// 1 INSERT -> 
						//	insert into telefonate values ('1234', '07-apr-2023', TIMESTAMP'2023-04-07 12:59:11','speriamo che me la cavo' , 'Appuntamento fissato' , '001', '3207111839') ; 

								
							// 1 INSERT 
							public void inserimentoTelefonata (String id , Date data ,Time ora , String note , String esito , String id_c , String id_u ) {
							
																
								
			    String query = "INSERT INTO telefonate VALUES ('"+ id+"','" + data + "', TIMESTAMP '" + data + " " + ora + "', '" + note +"','"+ esito + "','"+id_c+"','"+ id_u+"')" ;

								    try {
								        DBConnectionManager.updateQuery(query);
								        System.out.println("Telefonata inserita");
								    } catch (ClassNotFoundException e) {
								        e.printStackTrace();
								    } catch (SQLException e) {
								        e.printStackTrace();
								    }
								}
							
							// delete : 
							public void eliminaTelefonate (String id) {
								
								String query= new String("delete from telefonate where IdTelefonate= '"+ id+ "'") ; 
										
								
								try {
									
									DBConnectionManager.updateQuery(query) ;
									System.out.println("Telefonata eliminata") ;
																		
									
								}catch(ClassNotFoundException e) {
									e.printStackTrace();
								}catch(SQLException e){
									e.printStackTrace();
								}
								
							}
							
							// visualizza tutte le telefonate
							public void visualizzaTuttiAppuntamenti() {

							String query= new String("select * from telefonate  " ) ;								
						
								try {
									
									ResultSet rs= DBConnectionManager.selectQuery(query) ;
									  while (rs.next()) {
								            String id = rs.getString("id");
								            Date data  = rs.getDate("data") ; 
								            Time ora = rs.getTime("tempo") ; 
								            String note = rs.getString("note"); 
								             String esito = rs.getString("esito")  ;
								             String id_c= rs.getString("centralinista")  ; 
								             String id_u =rs.getString("utente") ; 
								            
								            System.out.println("ID: " + id + ", data: " + data + ", ora: " + ora+" , note"+ note +" , esito "+ esito +" , centralinista"+id_c+",numero "+ id_u+ " \n");
								        }
									
																		
									
								}catch(ClassNotFoundException e) {
									e.printStackTrace();
								}catch(SQLException e){
									e.printStackTrace();
								}
								
								
							}
							
							// visualizza 1 telefonata : 
							public void visualizzaTelefonata(String id ) {
								
								String query = new String( " select * from Telefonate  where IdTelefonate = " + id) ; 
								
								try {
									
									ResultSet rs= DBConnectionManager.selectQuery(query) ;
									   String id_t = rs.getString("id");
							            Date data  = rs.getDate("data") ; 
							            Time ora = rs.getTime("tempo") ; 
							            String note = rs.getString("note"); 
							             String esito = rs.getString("esito")  ;
							             String id_c= rs.getString("centralinista")  ; 
							             String id_u =rs.getString("utente") ; 
							            
							            System.out.println("ID: " + id_t + ", data: " + data + ", ora: " + ora+" , note"+ note +" , esito "+ esito +" , centralinista"+id_c+",numero "+ id_u+ " \n");
							        
															        
																																			
								}catch(ClassNotFoundException e) {
									e.printStackTrace();
								}catch(SQLException e){
									e.printStackTrace();
								}
								
							}
							
							public void registrazioneNote (String id , String note) {
								
								String query = new String("UPDATE telefonate SET note = '" +note+"' WHERE idtelefonate = '"+ id + "'" ) ;
								

								try {
									
									 DBConnectionManager.updateQuery(query) ;
									System.out.println("\n note settate \n - note :"+ note+" \n") ;   
															        
																																			
								}catch(ClassNotFoundException e) {
									e.printStackTrace();
								}catch(SQLException e){
									e.printStackTrace();
								}
							}
								
							
							
							public void registrazioneEsito(String id , String esito) {						
																
					String query = new String("UPDATE telefonate SET esito = '" +esito+"' WHERE idtelefonate = '"+ id + "'" ) ;
								

								try {
									
									 DBConnectionManager.updateQuery(query) ;
									System.out.println("\n esito settato \n - esito :"+esito+" \n") ;   
															        
									switch (esito) {
								    case "occupato":
								    case "Occupato":
								        System.out.println( "l'utente chiamato è occupato ") ; 
								        this.Esito=esito ; //"occupato" ; 
								        
								        
								        break;
								    case "senza risposta":
								    case "Senza risposta":
								    	System.out.println("L'utente chiamato non ha risposto") ; 
								    	this.Esito=esito ; //"senza risposta" ; 
								        break;
								    case "da richiamare":
								    case "Da richiamare":
								        System.out.println("L'utente chiamato ha detto di richiamarlo ") ; 
								        this.Esito=esito ; //"da richiamare" ; 
								        break;
								    case "non interessato":
								    case "Non interessato":

								        System.out.println("L'utente chiamato ha detto che non e' interessato ") ; 
								       this.Esito="non interessato" ; 
								    	
								        break;
								    case "appuntamento fissato":
								    case "Appuntamento fissato":

								        System.out.println("L'utente ha confermato l'appuntamento \n ") ;
								        
								          // Appuntamento fissato per la query !!!
								        System.out.println("inserisci i dati dell'ppuntamento : \n" ) ; 
								        this.Esito=esito ; 
								        AppuntamentiDAO creazione_appuntamento = new AppuntamentiDAO() ; // OGGETTO 
								        System.out.println("\n Inserisci ID appuntamento : ");
								        Scanner appuntamento = new Scanner(System.in) ; 
								        creazione_appuntamento.setID(appuntamento.nextLine());
						
								        System.out.println("\n Inserisci  data : ") ; 
								       
								        Scanner input = new Scanner(System.in); 
								        String data_input= input.nextLine(); 
								        
								        creazione_appuntamento.setData(data_input);
								        System.out.println("\n Inserisci ora : ") ; 
								        Scanner ora = new Scanner(System.in); 

								        creazione_appuntamento.setOra(ora.nextLine());
								        System.out.println("\n Inserisci note : ") ; 
								        Scanner note = new Scanner(System.in); 

								        creazione_appuntamento.setNote(note.nextLine());
								        System.out.println("\n Inserisci Id codiceFiscalr : ") ; 
								        Scanner id_codice = new Scanner(System.in); 

								        creazione_appuntamento.setId_codice_fiscale(id_codice.nextLine());
								        System.out.println("\n Inserisci Id telefonata : ") ; 
								        Scanner id_telefono = new Scanner(System.in); 
								                
								        creazione_appuntamento.setId_telefonata(id_telefono.nextLine());
									
									Date dateString = creazione_appuntamento.getData();
								
									SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
											
											try {
											   
											    String formattedDate = outputFormat.format(dateString);
										        String query1= new String (" insert into appuntamenti values ('"+creazione_appuntamento.getID()+"','"+formattedDate+"','"+creazione_appuntamento.getOra()+"','"+creazione_appuntamento.getNote()+"','"+creazione_appuntamento.getId_codice_fiscale()+"','"+creazione_appuntamento.getId_telefonata()+"')") ; 
										       
								    	
											
											int rit = DBConnectionManager.updateQuery(query1) ;
											if(rit>0) {
											System.out.println("\n appuntamento creato :   \n "+creazione_appuntamento.getID()+" "+formattedDate+" "+creazione_appuntamento.getOra()+" "+creazione_appuntamento.getNote()+" "+creazione_appuntamento.getId_codice_fiscale()+"  "+creazione_appuntamento.getId_telefonata()+"\n") ;
											}else {
												System.out.println(" \n errore appuntamento non creato \n ") ; 
											}
											
											}catch(ClassNotFoundException e) {
											e.printStackTrace();
										}catch(SQLException e){
											e.printStackTrace();
										}	
								        break;
								    default:
								        System.out.println("L'esito inserito non è valido ") ; 
								        break;
										
									}
										
										
										
										
									}catch(ClassNotFoundException e) {
									e.printStackTrace();
								}catch(SQLException e){
									e.printStackTrace();
								}	
							}
	
	
	
							
	
	
}


