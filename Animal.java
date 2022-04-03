/**
 * Animal Class
 * @author Cynthia Lei
 * @version March 24, 2022
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
    
    public String location = "zoo";
    
    // What the animal's state is --------------------
    public boolean isFed = true; 
    public boolean isRested; // needs rest after exhibit, breed, train, perform
    public boolean isTrained;  // only put in performing???
    
    // What the animal is currently doing --------------------
    public String animalIs = "exhibiting"; // "performing", "breeding", "resting"

    public abstract void transfer();
    public abstract void breed();
    
}//end of class