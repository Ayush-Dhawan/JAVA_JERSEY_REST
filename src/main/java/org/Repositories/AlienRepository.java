package org.Repositories;

import org.apicode.Alien;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AlienRepository {
    private static List<Alien> alien;

    public AlienRepository() {
        Alien alien1 = new Alien(1, "alien1", 101);
        Alien alien2 = new Alien(2, "alien2", 102);
        Alien alien3 = new Alien(3, "alien3", 103);
        Alien alien4 = new Alien(4, "alien4", 104);
        Alien alien5 = new Alien(5, "alien5", 105);
        alien = new ArrayList<>(Arrays.asList(alien1, alien2, alien3, alien4, alien5));
    }

    public Alien getAlienById(int id) {
        for (Alien alien : alien)
            if (alien.getId() == id) return alien;

        return null;
    }

    public List<Alien> getAllAliens() {
        return alien;
    }

    public List<Alien> addNewAlien(Alien a) {
        alien.add(a);
        System.out.println(a);
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
