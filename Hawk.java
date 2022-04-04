/**
 * Name: Hawk.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Hawk Class
 */

public class Hawk extends NonPerforming {
    public Hawk(String name, String sex){ // Default constructor
        this.setName(name);
        this.setSex(sex);
    }
    
    @Override
    public Animal[] breed() {
        Animal[] hawkBabies = new Animal[4]; // hawks have 4 babies
         
        for (int i = 0; i < hawkBabies.length; i++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String hawkName = "Hawk" + randomNum; // randomly generates a UNIQUE name for each baby
            String hawkSex;
            if (randomNum % 2 == 0){ // Randomly generates sex
                hawkSex = "f";
            } else {
                hawkSex = "m";
            }
            hawkBabies[i] = new Hawk(hawkName, hawkSex);
        }
        return hawkBabies;
    }
}
