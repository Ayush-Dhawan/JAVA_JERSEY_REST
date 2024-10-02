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

    public AlienRepository() {
//        Alien alien1 = new Alien(1, "alien1", 101);
//        Alien alien2 = new Alien(2, "alien2", 102);
//        Alien alien3 = new Alien(3, "alien3", 103);
//        Alien alien4 = new Alien(4, "alien4", 104);
//        Alien alien5 = new Alien(5, "alien5", 105);
//        alien = new ArrayList<>(Arrays.asList(alien1, alien2, alien3, alien4, alien5));
    }

    public Alien getAlienById(int id) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query q = session.createQuery("from Alien where id = :id");
            q.setParameter("id", id);
            Alien alien = (Alien) q.uniqueResult();
            if (alien == null) {
                System.out.println("No Alien found with id: " + id);  // Optional: Log or handle the absence of the Alien
            }
            return alien;
        }
    }

    public List<Alien> getAllAliens() {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Query q = session.createQuery("from Alien");
            List<Alien> aliens = q.list();
            session.close();
            return aliens;
        }

    }

    public List<Alien> addNewAlien(Alien a) {
        try(Session session = HibernateUtil.getSessionFactory().openSession()){
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Alien");
            List<Alien> aliens = q.list();
            session.save(a);
            tx.commit();
            session.close();
            return alien;
        }
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
        for (Alien alien : alien) {
            if(alien.getId() == id) {
                AlienRepository.alien.remove(alien);
                System.out.println("alien deleted succesfully!");
                return;
            }
        }
        System.out.println("No such alien found");
    }

}
