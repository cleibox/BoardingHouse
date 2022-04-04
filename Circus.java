/**
 * Name: Circus.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: The Circus class extends from the BoardingHouse. It contains specific animal actions such as train and perform.
 */

public class Circus extends BoardingHouse{
    @Override // Prints all the Animals in the circus
    public void printList() {
        System.out.println("Circus List --------------------|");
        setAlphabeticalOrder(); // sort
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] != null){
                System.out.println(animalList[i].getClass() + ": " + animalList[i].getName()); // Displays the Animal's class type and name
            }
        }
    }
   
    /**
     * train
     * Trains an Animal after all conditions are met
     * @param animal Animal object that will be trained
     */
    public void train(Animal animal){ 
        if (animal instanceof Performing){
            if (animal.isFed == true){
                animal.animalIs = "training";
                animal.isTrained = true;
                animal.isFed = false;
                animal.isRested = false;
                System.out.println("Training Successful");
            } else{
                removeAnimal(animal); // overexhaustion lol
                System.out.println(animal.getName() + " died due to training without being fed.");
            }
        } else {
            System.out.println("You can't train an animal if they're not at the circus or are nonperforming animals.");
        }
    }

    /**
     * perform
     * An Animal performs after all conditions are met
     * @param animal Animal object that will perform
     */
    public void perform(Animal animal){
        if (animal.isFed == true && animal.isTrained == true){
            animal.animalIs = "performing";
            animal.isFed = false;
            animal.isRested = false;
            System.out.println("Performance Successful");
        } else if (animal.isFed == true){
            System.out.println(animal.getName() + " cannot perform because they're not trained!");
        } else{
            removeAnimal(animal); // overexhuastion relateable lol
            System.out.println(animal.getName() + " died due to performing without being fed.");
        }
    }
}