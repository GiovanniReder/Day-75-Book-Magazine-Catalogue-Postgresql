package giovanni.dao;

import giovanni.entities.Catalogo;
import giovanni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;


import java.util.List;

public class CatalogoDAO {

    private EntityManager em;

    public CatalogoDAO(EntityManager em) {
        this.em = em;
    }

    // METODO 1: AGGIUNTA DI UN ELEMENTO DEL CATALOGO

    public void save(Catalogo catalogo) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("Il catalogo: " + catalogo.getTitolo() + " è stato salvato correttamente");
    }

    // METODO 2: RIMOZIONE DAL DB TRAMITE ISBN

    public Catalogo removeByIsbn(long ISBN) {
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Catalogo foundC = em.find(Catalogo.class, ISBN);
            if (foundC != null) {
                em.remove(foundC);
                transaction.commit();
                System.out.println("Oggetto rimosso dal database");
            } else {
                System.out.println("Oggetto non trovato nel db");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null; // oppure un oggetto Catalogo vuoto, a seconda delle tue esigenze
    }

    // METODO 3: RICERCA TRAMITE ISBN

    public Catalogo findByISBN(long ISBN) {
        Catalogo catalogo = em.find(Catalogo.class, ISBN);
        if (catalogo == null) {
            throw new NotFoundException((int) ISBN);
        }
        return catalogo;
    }

    // METODO 4: RICERCA PER ANNO DI PUBBLICAZIONE

    public Catalogo ricercaPerAnno(int year) {
        try {
            return em.createQuery("SELECT c FROM Catalogo c WHERE c.annoPubblicazione = :anno", Catalogo.class)
                    .setParameter("anno", year)
                    .getSingleResult();
        } catch (NoResultException e) {
            throw new NotFoundException( year);
        }
    }


    // METODO 5: RICERCA PER AUTORE

    public List<Catalogo> ricercaPerAutore(String autore) {
        return em.createQuery("SELECT c FROM Catalogo c WHERE c.autore = :autore", Catalogo.class)
                .setParameter("autore", autore)
                .getResultList();
    }

    // METODO 6: RICERCA PER TITOLO O PARTE DI ESSO

    public List<Catalogo> ricercaPerTitolo(String titolo) {
        return em.createQuery("SELECT c FROM Catalogo c WHERE c.titolo = :titolo", Catalogo.class)
                .setParameter("titolo", titolo)
                .getResultList();
    }


    // METODO 7: RICERCA DEGLI ELEMENTI ATTUALMENTE IN PRESTITO DATO UN NUMERO DI TESSERA UTENTE

    // METODO 8: RICERCA DI TUTTI I PRESTITI SCADUTI E NON ANCORA RESTITUITI
}
