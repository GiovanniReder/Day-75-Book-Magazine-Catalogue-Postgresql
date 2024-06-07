package giovanni.dao;

import giovanni.entities.Catalogo;
import giovanni.entities.Prestiti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PrestitiDAO {
    private EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestiti prestito) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(prestito);
        transaction.commit();
        System.out.println("L'utente: " + prestito.getUtente() + " ha preso in prestito: " + prestito.getElementoPrestato().getTitolo());
    }



    // METODO 7: RICERCA DEGLI ELEMENTI ATTUALMENTE IN PRESTITO DATO UN NUMERO DI TESSERA UTENTE

    public List<Catalogo> ricercaCatalogoByNumeroTessera(long numeroTessera) {
        TypedQuery<Catalogo> query = em.createQuery(
                "SELECT p.elementoPrestato FROM Prestiti p WHERE p.utente.numeroTessera = :numeroTessera",
                Catalogo.class
        );
        query.setParameter("numeroTessera", numeroTessera);
        return query.getResultList();
    }


    // METODO 8: RICERCA DI TUTTI I PRESTITI SCADUTI E NON ANCORA RESTITUITI

    public List<Prestiti> ricercaPrestitiScaduti() {
        TypedQuery<Prestiti> query = em.createQuery(
                "SELECT p FROM Prestiti p WHERE p.restituzioneEffettiva > p.restituzionePrevista",
                Prestiti.class
        );
        return query.getResultList();
    }

}
