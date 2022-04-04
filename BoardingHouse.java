/**
 * Name: BoardingHouse.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: BoardingHouse Class is the parent class to the Circus and Zoo classes
 */

import java.util.Arrays;
import java.util.Comparator; // sorting

public abstract class BoardingHouse {
    public Animal[] animalList = new Animal[50]; // Boarding House has a maximum size of 50 Animal Objects

    public abstract void printList(); // Printing out the separate animals in the zoo and the circus

    /**
     * removeAnimal
     * The given Animal object parameter will be removed from the animalList by being set to null
     * @param animal an Animal object that will be removed
     */
    public void removeAnimal(Animal animal) { 
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] == animal){                
                animalList[i] = null;
                System.out.println("Removal Successful");
            }
        }  
    }

    /**
     * setAlphabeticalOrder
     * Sorts the animalList into alphabetical order by the Animal names
     */
    public void setAlphabeticalOrder(){
        Arrays.sort(animalList, new Comparator<Animal>(){ // Comparator is via compareTo (compare String Animal name)
            public int compare(Animal a, Animal b) {
                if (a == null || b == null) {
                    return 0; // don't change the position between the two compared Animal objects
                }
                return a.getName().compareTo(b.getName()); // if Animal a is greater (more characters) than Animal b, it will go before Animal b
            }
        });
    }

    /**
     * findAnimal
     * Determines whether the user inputted animal name exists within the animalList or not
     * @param animalName user input of an animal name
     * @return an Animal Object that matches the animal name given by the user; else, returning null means the animal doesn't exist
     */
    public Animal findAnimal(String animalName){
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] != null){
                if (animalList[i].getName().equals(animalName)){ // find if the Animal Object has the same name as the user's inputted name
                    return animalList[i];
                }
            }
        }
        return null; 
    }

     /**
      * findAnimal (Method Overloading)
      * Determines whether the user inputted animal object exists within the animalList or not 
      * @param animal user input of an Animal Object
      * @return an Animal Object that matches the animal name given by the user; else, returning null means the animal doesn't exist
      */
    public Animal findAnimal(Animal animal) {
        if(animal == null) {
            return null;
        }
        return findAnimal(animal.getName());
    }

    /**
     * addAnimal
     * Adds a user inputted animal object into the animalList
     * @param animal user input of an Animal Object
     */
    public void addAnimal(Animal animal) {
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] == null){ // Look for an "empty" (null) element within animalList
                animalList[i] = animal;
                i = animalList.length; // adds only ONCE
            }
        }
    }
}
