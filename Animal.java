/**
 * Name: Animal.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Animal class for the blueprint of all instantiated animals
 */

public abstract class Animal{
    // Animal Characteristics --------------------
    private String name;
    public String getName() { // Getter
        return name;
    }
    public void setName(String newName) { // Setter
        this.name = newName;
    }

    private String sex;
    public String getSex() { // Getter
        return sex;
    }
    public void setSex(String newSex) { // Setter
        this.sex = newSex;
    }
        
    // What the animal's state is --------------------
    public boolean isFed = true; 
    public boolean isRested; // needs rest after exhibit, breed, train, perform
    public boolean isTrained;  // only put in performing???
    
    // What the animal is currently doing --------------------
    public String animalIs = "exhibiting"; // "performing", "breeding", "resting", "training"

    public abstract Animal[] breed(); // individual animals have different babies

    public void rest(){ // let the animal rest
        if ((animalIs.equals("exhibiting") || animalIs.equals("breeding") || animalIs.equals("training") || animalIs.equals("performing"))){
            System.out.println(getName() + " is now tired after " + animalIs + " and will rest right now.");
            isRested = true;
            animalIs = "resting";
        }
    }
}