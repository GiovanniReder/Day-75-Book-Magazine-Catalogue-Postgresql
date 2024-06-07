package giovanni.dao;

import giovanni.entities.Catalogo;
import giovanni.exception.NotFoundException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class CatalogoDAO {

    private EntityManager em;

    public CatalogoDAO (EntityManager em){
        this.em = em;
    }

    // METODO 1 AGGIUNTA DI UN ELEMENTO DEL CATALOGO

    public void save(Catalogo catalogo){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("il catalogo: " + catalogo.getTitolo() + " è stato salvato correttamente");


    }

    // METODO 3 RICERCA TRAMITE ISBN

    public Catalogo findByISBN(long ISBN){
        Catalogo catalogo = em.find(Catalogo.class, ISBN);
        if (catalogo == null ) throw new NotFoundException(ISBN);
        return catalogo;
    }

    // METODO 2 RIMOZIONE DAL DB TRAMITE ISBN

    public void removeByIsbn(long ISBN){
        try {
            EntityTransaction transaction = em.getTransaction();
            transaction.begin();
            Catalogo foundC = em.find(Catalogo.class, ISBN);
            if (foundC != null){
                em.remove(foundC);
                transaction.commit();
                System.out.println("Oggetto rimosso dal database");
            } else System.out.println("Oggetto non trovato nel db");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
