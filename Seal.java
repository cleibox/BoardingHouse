/**
 * Name: Seal.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Seal Class
 */

public class Seal extends NonPerforming {
    public Seal(String name, String sex){ // Default Constructor
        this.setName(name);
        this.setSex(sex);
    }
    
    @Override
    public Animal[] breed() {
        Animal[] sealBabies = new Animal[1]; // seals have 1 baby

        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String SealName = "Seal" + randomNum; // randomly generates a UNIQUE name for each baby
        String SealSex;
        if (randomNum % 2 == 0){ // randomly generates sex
            SealSex = "f";
        } else {
            SealSex = "m";
        }
        sealBabies[0] = new Seal(SealName, SealSex);
        return sealBabies;
    }
}
