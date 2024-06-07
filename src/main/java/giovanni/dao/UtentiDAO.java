package giovanni.dao;

import giovanni.entities.Catalogo;
import giovanni.entities.Utenti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtentiDAO {
    private EntityManager em;

    public UtentiDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Utenti utente) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(utente);
        transaction.commit();
        System.out.println("L'utente: " + utente.getNome() + utente.getCognome() + " è stato salvato correttamente");
    }
}
