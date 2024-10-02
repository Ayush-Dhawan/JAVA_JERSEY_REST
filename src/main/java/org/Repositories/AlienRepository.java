package org.Repositories;

import org.apicode.Alien;

import org.apicode.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class AlienRepository {
    private static List<Alien> alien;
    private Session session;

    public AlienRepository() {
        session = HibernateUtil.getSession();
    }

    public Alien getAlienById(int id) {
            Query q = session.createQuery("from Alien where id = :id");
            q.setParameter("id", id);
            Alien alien = (Alien) q.uniqueResult();
            if (alien == null) {
                System.out.println("No Alien found with id: " + id);  // Optional: Log or handle the absence of the Alien
            }
            return alien;
    }

    public List<Alien> getAllAliens() {
            Query q = session.createQuery("from Alien");
            List<Alien> aliens = q.list();
            return aliens;
    }

    public List<Alien> addNewAlien(Alien a) throws Exception {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Alien");
            List<Alien> aliens = q.list();
            try{
                session.save(a);
            }catch(Exception e){
                throw new Exception(e.getMessage());
            }
            finally {
                tx.commit(); //put in finally as if we try to start another transaction already present one interferes
            }
            return alien;
    }

    public void updateAlienInfo(String oldName, String newName) {
        for (Alien alien : alien) {
            if(alien.getName().equals(oldName)) {
                alien.setName(newName);
                System.out.println("Alien updated succesfully");
                return;
            }
        }
        System.out.println("No such Alien found");
    }

    public void deleteAlien(int id) {
//        this.alien.removeIf(alien -> alien.getId() == id);
        Transaction tx = session.beginTransaction();
        Query q = session.createQuery("DELETE from Alien where id = :id");
        q.setParameter("id", id);
        try{
            q.executeUpdate();
        }catch(Exception e){
            throw new RuntimeException(e.getMessage());
        }
        finally{
            tx.commit();
        }
    }

}
