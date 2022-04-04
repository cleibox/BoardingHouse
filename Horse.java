/**
 * Name: Horse.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Horse Class
 */

public class Horse extends Performing {
    public Horse(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }
    
    @Override
    public Animal[] breed() {
        Animal[] horseBabies = new Animal[1]; // horse have 1 baby
        
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String horseName = "Horse" + randomNum; // randomly generates a UNIQUE name for each baby
        String horseSex;
        if (randomNum % 2 == 0){ // randomly generates sex
            horseSex = "f";
        } else {
            horseSex = "m";
        }
        horseBabies[0] = new Horse(horseName, horseSex);
        return horseBabies;
    }
}
