/**
 * Name: Parrot.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Parrot Class
 */

public class Parrot extends NonPerforming {
    public Parrot(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }

    @Override
    public Animal[] breed() {
        Animal[] parrotBabies = new Animal[6]; // parrots have 6 babies
        
        for (int i = 0; i < parrotBabies.length; i ++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3; 
            String parrotName = "Parrot" + randomNum; // randomly generates a UNIQUE name for each baby
            String parrotSex;
            if (randomNum % 2 == 0){ // randomly generates sex
                parrotSex = "f";
            } else {
                parrotSex = "m";
            }
            parrotBabies[i] = new Parrot(parrotName, parrotSex);
        }
        return parrotBabies;
    }
    
    @Override
    public void rest(){} // parrots don't rest so there's nothing in rest method
}
