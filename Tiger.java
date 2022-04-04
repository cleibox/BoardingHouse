/**
 * Name: Tiger.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Tiger Class
 */

public class Tiger extends Performing {
    public Tiger(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }

    @Override
    public Animal[] breed(){
        Animal[] tigerBabies = new Animal[3]; // tigers have 3 babies

        for (int i = 0; i < tigerBabies.length; i++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String TigerName = "Tiger" + randomNum; // randomly generates a UNIQUE name for each baby
            String TigerSex;
            if (randomNum % 2 == 0){ // randomly generates sex
                TigerSex = "f";
            } else {
                TigerSex = "m";
            }
            tigerBabies[i] = new Tiger(TigerName, TigerSex);
        }
        return tigerBabies;
    }
}
