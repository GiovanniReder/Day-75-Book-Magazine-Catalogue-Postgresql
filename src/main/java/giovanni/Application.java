package giovanni;

import giovanni.dao.CatalogoDAO;
import giovanni.entities.Catalogo;
import giovanni.entities.Libri;
import giovanni.entities.Riviste;
import giovanni.enums.Periodicita;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {

    private static final EntityManagerFactory emf= Persistence.createEntityManagerFactory("Catalogue");

    public static void main(String[] args) {

        EntityManager em= emf.createEntityManager();

        CatalogoDAO dao = new CatalogoDAO(em);

        Libri book1 = new Libri(200 , 2005 , "I Cozonac" , "Vasco Pratolini " , "Cucina");
        Libri book2 = new Libri(109 , 2016 , "Eclissi" , "Enzo Sinigaglia" , "Romanzo");
        Libri book3 = new Libri(300 , 1980 , "Aglio, olio e assassino" , "Pino Imperatore" , "Thriller");
        Libri book4 = new Libri(400 , 1998 , "Terre rare" , "Sandro Veronesi" , "Narrativa");
        Libri book5 = new Libri(232 , 1800 , "La monaca di Monza" , "Alessandro Manzoni" , "Commedia");



        Riviste rivista1 = new Riviste(100, 2005 , "Focus" , Periodicita.MENSILE );
        Riviste rivista2 = new Riviste(70, 2010 , "Japan Magazine" , Periodicita.SEMESTRALE );
        Riviste rivista3 = new Riviste(150, 1998 , "F" , Periodicita.SETTIMANALE );
        Riviste rivista4 = new Riviste(200, 2005 , "One Piece" , Periodicita.SETTIMANALE );
        Riviste rivista5 = new Riviste(400, 1962 , "Rolling Stones" , Periodicita.MENSILE );



    




    }
}
