/**
 * Name: Lion.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Lion Class
 */

public class Lion extends Performing {
    public Lion(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }
    
    @Override
    public Animal[] breed() {
        Animal[] lionBabies = new Animal[3]; // lion have 3 babies
        
        for (int i = 0; i < lionBabies.length; i ++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String lionName = "Lion" + randomNum; // randomly generates a UNIQUE name for each baby
            String lionSex;
            if (randomNum % 2 == 0){ // randomly generates sex
                lionSex = "f";
            } else {
                lionSex = "m";
            }
            lionBabies[i] = new Lion(lionName, lionSex);
        }
        return lionBabies;
    }
}
