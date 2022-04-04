/**
 * Name: Walrus.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Walrus Class
 */

public class Walrus extends NonPerforming {
    public Walrus(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }
    
    @Override
    public Animal[] breed() {
        Animal[] walrusBabies = new Animal[1]; // walruses have 1 baby

        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String WalrusName = "Walrus" + randomNum; // randomly generates a UNIQUE name for each baby
        String WalrusSex;
        if (randomNum % 2 == 0){ // Randomly generates sex
            WalrusSex = "f";
        } else {
            WalrusSex = "m";
        }
        walrusBabies[0] = new Dolphin(WalrusName, WalrusSex);
        return walrusBabies;
    }
}
