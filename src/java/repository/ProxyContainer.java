package repository;

import model.Inventory;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProxyContainer {
    @PersistenceContext
    private Session session;
    public List<Inventory> allUsers(){

        return session.createQuery("from Inventory").list();
    }
}
