package repository;

import model.Inventory;
import model.News;
import org.hibernate.LockMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import javax.persistence.LockModeType;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@Repository
public class UserDAO {
    @Autowired
SessionFactory factory;

    public List<News> allNews(){

        return factory.getCurrentSession().createQuery("from model.News E order by E.id desc ").list();
    }
    public News find(int id){
        TypedQuery<News> q= factory.getCurrentSession().createQuery("from News E where E.id=:ID",News.class);
        q.setParameter("ID",id);
        return q.getSingleResult();
    }
    public void delete(int id){

       Session session=factory.getCurrentSession();
       News news=session.load(News.class,new Integer(id));
       session.remove(news);

        // factory.getCurrentSession().createQuery("delete from News E where E.id=?1").setParameter(1,id).executeUpdate();
    }
    public void update(News news){
        factory.getCurrentSession().update(news);
    }
    public Serializable saveNews(News news){
        Session session=factory.getCurrentSession();
                return session.save(news);

    }
}
