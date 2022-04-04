/**
 * Name: Elephant.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Elephant Class
 */

public class Elephant extends Performing {
    public Elephant(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }

    @Override
    public Animal[] breed() {
        Animal[] elephantBabies = new Animal[1]; // elephants have 1 baby
        
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String elephantName = "Elephant" + randomNum; // randomly generates a UNIQUE name for each baby
        String elephantSex;
        if (randomNum % 2 == 0){ // randomly generates sex
            elephantSex = "f";
        } else {
            elephantSex = "m";
        }
        elephantBabies[0] = new Elephant(elephantName, elephantSex);
        return elephantBabies;
    }
}
