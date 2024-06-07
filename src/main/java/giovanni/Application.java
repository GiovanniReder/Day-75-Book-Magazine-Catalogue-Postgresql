package giovanni;

import giovanni.dao.CatalogoDAO;
import giovanni.dao.PrestitiDAO;
import giovanni.dao.UtentiDAO;
import giovanni.entities.Catalogo;
import giovanni.entities.Libri;
import giovanni.entities.Riviste;
import giovanni.entities.Utenti;
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



       // System.out.println(dao.ricercaPerAnno(2016));
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
        // utenteDao.save(giovanni);
        // utenteDao.save(giacomo);
        // utenteDao.save(marina);
        // utenteDao.save(luciana);




em.close();
emf.close();
    }
}
