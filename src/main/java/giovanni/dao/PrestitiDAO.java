package giovanni.dao;

import jakarta.persistence.EntityManager;

public class PrestitiDAO {
    private EntityManager em;

    public PrestitiDAO(EntityManager em) {
        this.em = em;
    }
}
