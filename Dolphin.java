/**
 * Name: Dolphin.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Dolphin Class
 */

public class Dolphin extends NonPerforming {
    public Dolphin(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }

    @Override
    public Animal[] breed() {
        Animal[] dolphinBabies = new Animal[1]; // dolphins have 1 baby

        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String dolphinName = "Dolphin" + randomNum; // randomly generates a UNIQUE name for each baby
        String dolphinSex;
        if (randomNum % 2 == 0){ // randomly generates sex
            dolphinSex = "f";
        } else {
            dolphinSex = "m";
        }
        dolphinBabies[0] = new Dolphin(dolphinName, dolphinSex);
        return dolphinBabies;
    }
}
