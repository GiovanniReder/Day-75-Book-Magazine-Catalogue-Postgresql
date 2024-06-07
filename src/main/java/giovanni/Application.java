package giovanni;

import giovanni.dao.CatalogoDAO;
import giovanni.dao.PrestitiDAO;
import giovanni.dao.UtentiDAO;
import giovanni.entities.*;
import giovanni.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

public class Application {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("Catalogue");

    public static void main(String[] args) {

        EntityManager em= emf.createEntityManager();
        CatalogoDAO dao = new CatalogoDAO(em);
        UtentiDAO utenteDao= new UtentiDAO(em);
        PrestitiDAO prestitoDao= new PrestitiDAO(em);



        Libri book1 = new Libri(200 , 2005 , "I Cozonac" , "Vasco Pratolini " , "Cucina");
        Libri book2 = new Libri(109 , 2016 , "Eclissi" , "Enzo Sinigaglia" , "Romanzo");
        Libri book3 = new Libri(300 , 1980 , "Aglio, olio e assassino" , "Pino Imperatore" , "Thriller");
        Libri book4 = new Libri(400 , 1998 , "Terre rare" , "Sandro Veronesi" , "Narrativa");
        Libri book5 = new Libri(232 , 1800 , "La monaca di Monza" , "Alessandro Manzoni" , "Commedia");



        Riviste rivista1 = new Riviste(100, 2007 , "Focus" , Periodicita.MENSILE );
        Riviste rivista2 = new Riviste(70, 2010 , "Japan Magazine" , Periodicita.SEMESTRALE );
        Riviste rivista3 = new Riviste(150, 1998 , "F" , Periodicita.SETTIMANALE );
        Riviste rivista4 = new Riviste(200, 2005 , "One Piece" , Periodicita.SETTIMANALE );
        Riviste rivista5 = new Riviste(400, 1962 , "Rolling Stones" , Periodicita.MENSILE );


        System.out.println(dao.findByISBN(152));
        System.out.println(dao.ricercaPerAnno(2016));
        // System.out.println(dao.ricercaPerAutore("Pino Imperatore"));
       // System.out.println(dao.ricercaPerTitolo("I Cozonac"));


        LocalDate dataDiNascita1 = LocalDate.of(1958, 9, 28);
        Utenti aldo = new Utenti(dataDiNascita1, "Aldo", "Baglio");

        LocalDate dataDiNascita2 = LocalDate.of(1957, 2, 20);
        Utenti giovanni = new Utenti(dataDiNascita1, "Giovanni", "Storti");

        LocalDate dataDiNascita3 = LocalDate.of(1956, 4, 26);
        Utenti giacomo = new Utenti(dataDiNascita1, "Giacomo", "Poretti");

        LocalDate dataDiNascita4 = LocalDate.of(1963, 5, 16);
        Utenti marina = new Utenti(dataDiNascita1, "Marina", "Massironi");

        LocalDate dataDiNascita5 = LocalDate.of(1964, 10, 29);
        Utenti luciana = new Utenti(dataDiNascita1, "Luciana", "Litizzetto");

        // utenteDao.save(aldo);
       //  utenteDao.save(giovanni);
      //  utenteDao.save(giacomo);
      //  utenteDao.save(marina);
      //   utenteDao.save(luciana);


        LocalDate inizioPrestito1 = LocalDate.of(2023, 06, 07);
        LocalDate restituzioneEffettiva1 = LocalDate.of(2023, 8, 28);
        Prestiti prestito1 = new Prestiti(aldo , dao.findByISBN(152) ,inizioPrestito1 ,restituzioneEffettiva1 , inizioPrestito1.plusDays(30));


        LocalDate inizioPrestito2 = LocalDate.of(2024, 01, 07);
        LocalDate restituzioneEffettiva2 = LocalDate.of(2024, 1, 28);
        Prestiti prestito2 = new Prestiti(giovanni , dao.findByISBN(202) ,inizioPrestito2 ,restituzioneEffettiva2 , inizioPrestito2.plusDays(30));


        LocalDate inizioPrestito3 = LocalDate.of(2024, 06, 07);
        LocalDate restituzioneEffettiva3 = LocalDate.of(2024, 8, 28);
        Prestiti prestito3 = new Prestiti(giacomo , dao.findByISBN(203) ,inizioPrestito3 ,restituzioneEffettiva3 , inizioPrestito3.plusDays(30));

        LocalDate inizioPrestito4 = LocalDate.of(2024, 06, 07);
        LocalDate restituzioneEffettiva4 = LocalDate.of(2024, 8, 28);
        Prestiti prestito4 = new Prestiti(marina , dao.findByISBN(204) ,inizioPrestito4 ,restituzioneEffettiva4 , inizioPrestito4.plusDays(30));

        LocalDate inizioPrestito5 = LocalDate.of(2024, 06, 07);
        LocalDate restituzioneEffettiva5 = LocalDate.of(2024, 8, 28);
        Prestiti prestito5 = new Prestiti(luciana , dao.findByISBN(205) ,inizioPrestito5 ,restituzioneEffettiva5 , inizioPrestito5.plusDays(30));

         prestitoDao.save(prestito1);
         prestitoDao.save(prestito2);
         prestitoDao.save(prestito3);
         prestitoDao.save(prestito4);
         prestitoDao.save(prestito5);

        System.out.println("se si vede questo messagio è ok");




em.close();
emf.close();
    }
}
