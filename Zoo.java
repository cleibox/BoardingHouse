/**
 * Name: Zoo.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: The Zoo class extends from the BoardingHouse. It contains specific animal actions such as exhibit and breed.
 */

public class Zoo extends BoardingHouse {
    public Zoo() {
        animalList[0] = new Dolphin("Dolphin1", "f");
        animalList[1] = new Dolphin("Dolphin2", "m");
        animalList[2] = new Lion("Lion1", "f");
        animalList[3] = new Lion("Lion2", "m");
        animalList[4] = new Parrot("Parrot1", "f");
        animalList[5] = new Parrot("Parrot2", "m");
        animalList[6] = new Elephant("Elephant1", "f");
        animalList[7] = new Elephant("Elephant2", "m");
        animalList[8] = new Flamingo("Flamingo1", "f");
        animalList[9] = new Flamingo("Flamingo2", "m");
        animalList[10] = new Hawk("Hawk1", "f");
        animalList[11] = new Hawk("Hawk2", "m");
        animalList[12] = new Horse("Horse1", "f");
        animalList[13] = new Horse("Horse2", "m");
        animalList[14] = new Seal("Seal1", "f");
        animalList[15] = new Seal("Seal2", "m");
        animalList[16] = new Tiger("Tiger1", "f");
        animalList[17] = new Tiger("Tiger2", "m");
        animalList[18] = new Walrus("Walrus1", "f");
        animalList[19] = new Walrus("Walrus2", "m");
    }

    @Override // Prints all the Animals in the zoo
    public void printList() {
        System.out.println("Zoo List -----------------------|");
        setAlphabeticalOrder(); // sort
        for (int i = 0; i < animalList.length; i++) {
            if (animalList[i] != null) {
                System.out.println(animalList[i].getClass() + ": " + animalList[i].getName()); // Displays the Animal's class type and name
            }
        }
    }

    /**
     * breedAnimal
     * Only animals in the zoo can breed. After passing breeding conditions, the Animal object will breed 
     * @param animal user inputted Animal Object that will have specific babies
     */
    public void breedAnimal(Animal animal) {
        if (animal.isFed) {
            for (int i = 0; i < animalList.length; i++) {
                if (animalList[i] != null) { 
                    if ((animal.getClass().equals(animalList[i].getClass())) && !(animalList[i].equals(animal))) { // Same species, a different animal (not the same inputted animal), user inputted animal exists
                        if ((animal.getSex().equals("f") && animalList[i].getSex().equals("m")) || (animal.getSex().equals("m") && animalList[i].getSex().equals("f"))) { // male and female Animals
                            Animal[] babies = animalList[i].breed(); // Varying number of babies
                            for (int j = 0; j < babies.length; j++) {
                                addAnimal(animal.breed()[j]); // add the babies to the animalList
                            }
                            animal.animalIs = "breeding";
                            animal.isFed = false;
                            System.out.println("Breeding Successful");
                            i = animalList.length; // Breed with only ONE other Animal
                        }
                    }
                }
            }
        } else {
            removeAnimal(animal); // breeding sure is tiring
            System.out.println(animal.getName() + " died due to breeding without being fed.");
        }
    }

    /**
     * exhibit
     * An Animal will be put on exhibit after passing certain conditions
     * @param animal user inputted Animal Object that will be put on exhibit
     */
    public void exhibit(Animal animal) {
        if (animal.isFed == true) {
            animal.animalIs = "exhibiting";
            animal.isFed = false;
            animal.isRested = false;
        } else {
            removeAnimal(animal); // burnout season hits hard
            System.out.println(animal.getName() + " died due to exhibiting without being fed.");
        }
    }
}
