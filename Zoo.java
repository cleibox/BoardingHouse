// import java.util.ArrayList; // import the ArrayList class

public class Zoo extends BoardingHouse{
    public Zoo() {
        animalList[0] = new Dolphin("Dolphin1", "f");
        animalList[1] = new Dolphin("Dolphin2", "m");
        animalList[2] = new Lion("Lion1", "f");
        animalList[3] = new Lion("Lion2", "m");
        animalList[4] = new Parrot("Parrot1", "f");
        animalList[5] = new Parrot("Parrot2", "m");
        // add the rest of the animals
    }

    @Override
    public void printList() {
        System.out.println("Zoo List -----------------------|");
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] != null){
                if (animalList[i].location.equals("zoo")){
                    System.out.println(animalList[i].getClass() + ": " + animalList[i].getName());
                }
            }
        }    
    }

    public static void addAnimal(Animal animal) {
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] == null){                
                animal.location = "zoo";
                animalList[i] = animal;
                i = animalList.length;
            }
        }
    }

    public void exhibit(Animal animal){
        if (animal.location.equals("zoo")){
            if (animal.isFed == true){
                animal.animalIs = "exhibiting";
                animal.isFed = false;
                animal.isRested = false;
            }
            else{
                removeAnimal(animal);
                System.out.println(animal.getName() + " died due to exhibiting without being fed.");
            }
        }
        else {
            System.out.println("Animals can only exhibit in the zoo, dummy.");
        }
    }

}
