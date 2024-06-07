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

    // METODI

    public void save(Catalogo catalogo){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(catalogo);
        transaction.commit();
        System.out.println("il catalogo: " + catalogo.getTitolo() + " è stato salvato correttamente");


    }

    public Catalogo findByISBN(long ISBN){
        Catalogo catalogo = em.find(Catalogo.class, ISBN);
        if (catalogo == null ) throw new NotFoundException(ISBN);
        return catalogo;
    }

    public void removeByIsbn(long ISBN){

    }
}
