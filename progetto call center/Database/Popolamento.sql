Insert into agentivendita values ('FLFLFFFFF1233FSA', 'GIO', 'FALCO') ; 

Insert into agentivendita values ('FLFLFZZZF1233FAA', 'michele', 'FALCO') ; 

select*
from utenti ; 
INSERT INTO CENTRALINISTI VALUES ('001', 'GIO','FALC','F@GMAIL','1111') ;

INSERT INTO UTENTI VALUES ('3207111839', 'AAAA')  ; 
Insert into liste values ('AAAA', '1111') ; 
insert into gruppicentralinisti values ('1111' ,'formato da : Giovanni e Michele') ; 


insert into telefonate values ('1234', '2023-04-04', TIMESTAMP'2023-04-04 12:59:11','speriamo che me la cavo' , 'Appuntamento fissato' , '001', '3207111839') 

INSERT INTO appuntamenti VALUES ('1', '2023-04-07', TIMESTAMP '2023-07-07 09:15:00', 'sembra che ci stia', 'FLFLFFFFF1233FSA', '1234')  

SELECT *
FROM LISTE ;  -- ID LISTA = AAAA , IDGRUPPO =1111
SELECT *
FROM GRUPPICENTRALINISTI ; 
SELECT*
FROM UTENTI ; 
SELECT IdNumeroTelefonico FROM utenti WHERE lista= 'AAAA' ; 
select * from liste ; 
select *
from utenti 
order by IdNumeroTelefonico DESC ; 

select *
from telefonate ; 
select*
from agentivendita
select *from centralinisti  ; 
insert into  Centralinisti (IdCentralinista , Nome , Cognome , email ) values ('2','Mario','Fornmato','Form@gmail') ; 
select * from appuntamenti ; 
insert into gruppicentralinisti values ('2222' , 'un altro gruppo') ; 


select * from gruppicentralinisti; 
DELETE FROM utenti WHERE lista= 'DDDDD' 