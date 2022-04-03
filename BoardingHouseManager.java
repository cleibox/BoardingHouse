import java.util.Scanner;

public class BoardingHouseManager  {
    Scanner reader = new Scanner(System.in);
    Zoo zoo = new Zoo();
    Circus circus = new Circus();

    public void openMenu(){ 
        int userChoice = 0; 
        do{
            System.out.println("\n----------------------------------------\nChoose one of the following options: \n1) Print a list of the Boarding House" + "\n2) Add an Animal" + "\n3) Remove an Animal" + "\n4) View an Animal" + "\n5) Quit");
            try{
                userChoice = reader.nextInt();
                reader.nextLine(); // Prevent nextInt from skipping the next input
                System.out.println("");

                // int boardingHouseListSize = BoardingHouse.animalList.length;
                if (userChoice == 1){ // print player list
                    zoo.printList();
                    circus.printList();
                } else if (userChoice == 2){ // add animals
                    Animal animal = addUserAnimal();
                    if (animal != null){
                        Zoo.addAnimal(animal);
                    }
                } else if (userChoice == 3){ // remove animals
                    System.out.print("Enter the name of the animal you want to remove from the zoo: ");
                    String animalName = reader.nextLine();
                    if (BoardingHouse.findAnimal(animalName) != -1){
                        BoardingHouse.removeAnimal(BoardingHouse.animalList[BoardingHouse.findAnimal(animalName)]);
                    } else{
                        System.out.println("The animal you chose does not exist in the zoo.");
                    }
                } else if (userChoice == 4){ // View an animal
                    System.out.print("Enter the name of the animal you want view: ");
                    String animalName = reader.nextLine();
                    if (BoardingHouse.findAnimal(animalName) != -1){  
                        userManageAnimal(animalName);
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
    public static Animal addUserAnimal(){
        String animalName = getValidUserAnimalName();
        String animalSex = getUserAnimalSex();
        int userChoice = 0;
        System.out.println("Animal Type: \n(1) Parrot \n(2) Hawk \n(3) Flamingo \n(4) Seal \n(5) Dolphin \n(6) Walrus \n(7) Tiger \n(8) Lion \n(9) Elephant \n(10) Horse");
        do{
            System.out.print("Be sure to type a value 1-10: ");
            userChoice = reader.nextInt();
            if (userChoice == 1 && reader.hasNextInt()){
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

    public static String getValidUserAnimalName(){
        String userPetName = "1";
        do{
            System.out.print("Animal Name (No duplicates!): ");
            userPetName = reader.nextLine();
        } while (BoardingHouse.findAnimal(userPetName) != -1);
        return userPetName;
    }

    public static String getUserAnimalSex(){
        String userPetSex = "1";
        do{
            System.out.print("Animal Sex (f/m): ");
            userPetSex = reader.next();
        } while (!(userPetSex.equals("f")) && !(userPetSex.equals("m")));
        return userPetSex;
    }

    public void userManageAnimal(String userAnimalName){
        int userChoice = 0; 
        do{
            System.out.println("\nViewing '" + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].getName() + "' ----------\nAnimal Type: " + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].getClass() + "\nAnimal Sex: " + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].getSex() + "\nCurrent Behaviour: " + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].animalIs + "\nCurrent Location: " + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].location + "\nIs Fed? " + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].isFed + "\nIs Rested? " + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].isRested + "\nIs Trained? " + BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].isTrained);
            if (BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)] instanceof Performing){
                System.out.println("Performing Animal. Can be Trained or transferred.");
            } else { // viewAnimal instanceof NonPerforming
                System.out.println("Non-Performing Animal. Can't be Trained or transferred.");
            }
            System.out.println();
            BoardingHouse.rest(userAnimalName);

            System.out.println("\nAnimal Management Mode: \n1) Feed\n2) Rest\n3) Breed\n4) Train\n5) Perform\n6) Exhibit\n7) Transfer\n8) Exit Management Mode");
            userChoice = reader.nextInt();
            reader.nextLine(); // Prevent nextInt from skipping the next input
            System.out.println("");
            
            if (userChoice == 1){ // feed animal
                BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].isFed = true;
            } else if (userChoice == 2){ // rest animal
                BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].isRested = true;
            } else if (userChoice == 3){ // Breed animal
                BoardingHouse.breedAnimal(userAnimalName);
            } else if (userChoice == 4){ // train animal
                circus.train(BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)]);
            } else if (userChoice == 5){ // perform
                circus.perform(BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)]);
            } else if (userChoice == 6){ // exhibit
                zoo.exhibit(BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)]);
            } else if (userChoice == 7){ // transfer
                BoardingHouse.animalList[BoardingHouse.findAnimal(userAnimalName)].transfer();
            } else { // incorrect user input
                System.out.println("Enter a value between 1-8");
            }
            
        } while (userChoice != 8);
    }
}
