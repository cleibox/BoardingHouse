/**
 * Name: BoardingHouseManager.java
 * Author: Cynthia Lei
 * Date: April 3, 2022
 * Description: Develops the user interface of how the Boarding House program will run
 */

import java.util.Scanner;

public class BoardingHouseManager  {
    Scanner reader = new Scanner(System.in);
    Zoo zoo = new Zoo();
    Circus circus = new Circus();

    /**
     * findAnimalInBoardingHouse
     * Determines whether the user inputted animal exists in the entire BoardingHouse
     * @param userAnimalName user inputted animal name string
     * @return the Animal Object if it exists; otherwise, null
     */
    private Animal findAnimalInBoardingHouse(String userAnimalName) { // find if the animal exists in either the zoo or circus
        Animal animal = zoo.findAnimal(userAnimalName); // find if the animal exists in the zoo
        if (animal != null){ // animal in zoo
            return animal;
        } else { // animal in circus
            animal = circus.findAnimal(userAnimalName); // find if the animal exists in the zoo
            if (animal !=null) {
                return animal;
            }
        }
        return null;
    }

    /**
     * transfer
     * Moves the Animal Object from circus to zoo and vice versa
     * @param userAnimalName user inputted animal name string
     */
    public void transfer(String userAnimalName){ // transfer the animal between the zoo and circus
        Animal animal = zoo.findAnimal(userAnimalName);
        if (animal instanceof Performing){ // animal is in zoo
            zoo.removeAnimal(animal);
            circus.addAnimal(animal);
            System.out.println("Successful transfer from the zoo to the circus");
        } else { // animal is in circus
            animal = circus.findAnimal(userAnimalName);
            if (animal instanceof Performing) {
                zoo.addAnimal(animal);
                circus.removeAnimal(animal);
                System.out.println("Successful transfer from the circus to the zoo");
            } else {
                System.out.println("Non Performing animals can't be transferred.");
            }   
        }
    }

    /**
     * getLocation
     * Determine the Animal Object's location (circus or zoo)
     * @param userAnimal user inputted animal name string
     * @return String of the Animal's location; "circus" or "zoo"
     */
    public String getLocation(Animal userAnimal){
        Animal animal = zoo.findAnimal(userAnimal);
        if (animal != null){ // animal is in zoo
            return "zoo";
        } else { // animal is in circus
            animal = circus.findAnimal(userAnimal);
            if (animal != null) {
                return "circus";
            } 
        }
        return "";
    }

    /**
     * getZooSize
     * Determine how many animals exist in the zoo
     * @return number of animals in the zoo
     */
    public int getZooSize(){
        int count = 0;
        for (int i = 0; i < zoo.animalList.length; i ++){
            if (zoo.animalList[i] != null){
                count++;
            }
        }
        return count;
    }

    public void openMenu(){ // main menu
        int userChoice = 0; 
        System.out.println("Welcome to Cynthia's Boarding House! Cynthia loves land animals so only they will be able to perform. Be sure to feed your animals so they don't die!");
        do{
            System.out.println("\n----------------------------------------\nChoose one of the following options: \n1) Print a list of the Boarding House" + "\n2) Add an Animal to the zoo" + "\n3) Remove an Animal from the zoo" + "\n4) View any Animal" + "\n5) Quit");
            try{
                userChoice = reader.nextInt();
                reader.nextLine(); // Prevent nextInt from skipping the next input
                System.out.println("");

                int zooSize = getZooSize();
                if (userChoice == 1){ // print player list
                    System.out.println("Maximum Animals: " + zoo.animalList.length);
                    zoo.printList();
                    circus.printList();
                } else if (userChoice == 2){ // add animals
                    if (zooSize < zoo.animalList.length){
                        Animal animal = addUserAnimal();
                        if (animal != null){
                            zoo.addAnimal(animal);
                            System.out.println(animal.getName() + " added.");
                        }
                    } else{
                        System.out.println("Zoo is full.");
                    }
                } else if (userChoice == 3){ // remove animals
                    System.out.print("Enter the name of the animal you want to remove from the zoo: ");
                    String animalName = reader.nextLine();
                    Animal animal = zoo.findAnimal(animalName) ;
                    if (animal != null){
                        zoo.removeAnimal(animal);
                    } else{
                        System.out.println("The animal you chose does not exist in the zoo.");
                    }
                } else if (userChoice == 4){ // View an animal
                    System.out.print("Enter the name of the animal you want view: ");
                    String animalName = reader.nextLine();
                    Animal animal = findAnimalInBoardingHouse(animalName);
                    if (animal != null){ // Animal exists
                        openAnimalManagementMenu(animal);
                    } else{
                        System.out.println("The animal you chose does not exist.");
                    }
                } else if (userChoice == 5){ // quit
                    System.out.println("bye");
                } else{ // incorrect user input
                    System.out.println("Enter a value between 1-5");
                }
            } catch (java.lang.ArrayIndexOutOfBoundsException e){
                System.out.println("The animal no longer exists.");
            }
            catch(java.util.InputMismatchException e){
                System.out.println("Enter a NUMBER between 1-5. Failed Input.");
                reader.nextLine();
            }
        } while (userChoice != 5);
    }  
    
    /**
     * addUserAnimal
     * Retrieve information necessary to construct the user's desired Animal Object
     * @return user's desired Animal Object
     */
    public Animal addUserAnimal(){
        String animalName = getValidUserAnimalName();
        String animalSex = getUserAnimalSex();
        int userChoice = 0;
        System.out.println("Animal Type: \n(1) Parrot \n(2) Hawk \n(3) Flamingo \n(4) Seal \n(5) Dolphin \n(6) Walrus \n(7) Tiger \n(8) Lion \n(9) Elephant \n(10) Horse");
        do{
            System.out.print("Be sure to type a value 1-10: ");
            userChoice = reader.nextInt();
            if (userChoice == 1){
                return new Parrot(animalName, animalSex);
            } else if (userChoice == 2){
                return new Hawk(animalName, animalSex);
            } else if (userChoice == 3){
                return new Flamingo(animalName, animalSex);
            } else if (userChoice == 4){
                return new Seal(animalName, animalSex);
            } else if (userChoice == 5){
                return new Dolphin(animalName, animalSex);
            } else if (userChoice == 6){
                return new Walrus(animalName, animalSex);
            } else if (userChoice == 7){
                return new Tiger(animalName, animalSex);
            } else if (userChoice == 8){
                return new Lion(animalName, animalSex);
            } else if (userChoice == 9){
                return new Elephant(animalName, animalSex);
            } else if (userChoice == 10){
                return new Horse(animalName, animalSex);
            } 
        } while (userChoice > 10 || userChoice < 1);
        return null;
    }

    /**
     * getValidUserAnimalName
     * Force user to input a valid Animal name
     * @return valid String Animal name
     */
    public String getValidUserAnimalName(){
        String userAnimalName = "1";
        Animal animal = null;
        do{
            System.out.print("Animal Name (No duplicates!): ");
            userAnimalName = reader.nextLine();
            animal = findAnimalInBoardingHouse(userAnimalName);
        } while (animal != null); // can't have the same name as a pre-existing animal!
        return userAnimalName;
    }

    /**
     * getUserAnimalSex
     * Force user to input a valid Animal sex
     * @return valid String Animal Sex
     */
    public String getUserAnimalSex(){
        String userPetSex = "1";
        do{
            System.out.print("Animal Sex (f/m): ");
            userPetSex = reader.next();
        } while (!(userPetSex.equals("f")) && !(userPetSex.equals("m"))); 
        return userPetSex;
    }

    /**
     * openAnimalManagementMenu
     * Another menu for animal management
     * @param animal the Animal Object the user wants to manage
     */
    public void openAnimalManagementMenu(Animal animal){ 
        int userChoice = 0; 
        do{
            System.out.println("\nViewing '" + animal.getName() + "' ----------\nAnimal Type: " + animal.getClass() + "\nAnimal Sex: " + animal.getSex() + "\nAnimal Location: " + getLocation(animal) + "\nCurrent Behaviour: " + animal.animalIs + "\nIs Fed? " + animal.isFed + "\nIs Rested? " + animal.isRested + "\nIs Trained? " + animal.isTrained);
            if (animal instanceof Performing){
                System.out.println("Performing Animal. Can be Trained or transferred.");
            } else { // viewAnimal instanceof NonPerforming
                System.out.println("Non-Performing Animal. Can't be Trained or transferred.");
            }
            System.out.println();
            animal.rest();

            System.out.println("\nAnimal Management Mode: \n1) Feed\n2) Rest\n3) Breed\n4) Train\n5) Perform\n6) Exhibit\n7) Transfer\n8) Exit Management Mode");
            userChoice = reader.nextInt();
            reader.nextLine(); // Prevent nextInt from skipping the next input
            System.out.println("");
            
            if (userChoice == 1){ // feed animal
                animal.isFed = true;
                System.out.println("Animal fed");
            } else if (userChoice == 2){ // rest animal
                animal.isRested = true;
                System.out.println("Animal rested");
            } else if (userChoice == 3){ // Breed animal
                System.out.println("If the zoo becomes full, any extra babies are put down.");
                if (zoo.findAnimal(animal) != null){
                    zoo.breedAnimal(animal);
                } else  {
                    System.out.println("Only animals in the zoo can breed.");
                }
            } else if (userChoice == 4){ // train animal
                if (circus.findAnimal(animal) != null){
                    circus.train(animal);
                } else {
                    System.out.println("You can only train animals in the circus.");
                }
            } else if (userChoice == 5){ // animal perform
                if (circus.findAnimal(animal) != null){
                    circus.perform(animal);
                } else {
                    System.out.println("Only animals in the circus can perform.");
                }
            } else if (userChoice == 6){ // exhibit animal
                if (zoo.findAnimal(animal) != null){
                    zoo.exhibit(animal);
                } else {
                    System.out.println("Only animals in the zoo can exhibit.");
                }
            } else if (userChoice == 7){ // transfer
                transfer(animal.getName());
            } else { // incorrect user input
                System.out.println("Enter a value between 1-8");
            }
        } while (userChoice != 8 && findAnimalInBoardingHouse(animal.getName()) != null);
    }
}
