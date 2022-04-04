/**
 * Name: Flamingo.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Flamingo Class
 */

public class Flamingo extends NonPerforming {
    public Flamingo(String name, String sex){ // Default constructor
        this.setName(name);
        this.setSex(sex);
    }
    
    @Override
    public Animal[] breed() {
        Animal[] flamingoBabies = new Animal[1]; // flamingoes have 1 baby
        
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String FlamingoName = "Flamingo" + randomNum; // randomly generates a UNIQUE name for each baby
        String FlamingoSex;
        if (randomNum % 2 == 0){ // Randomly generates sex
            FlamingoSex = "f";
        } else {
            FlamingoSex = "m";
        }
        flamingoBabies[0] = new Flamingo(FlamingoName, FlamingoSex);
        return flamingoBabies;
    }
}
