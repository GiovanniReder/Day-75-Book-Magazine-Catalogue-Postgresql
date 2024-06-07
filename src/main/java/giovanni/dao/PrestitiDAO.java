package giovanni.dao;

import giovanni.entities.Prestiti;
import giovanni.entities.Utenti;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
