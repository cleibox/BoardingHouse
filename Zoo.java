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
                // if (animalList[i].location.equals("zoo")){
                    System.out.println(animalList[i].getClass() + ": " + animalList[i].getName());
                // }
            }
        }    
    }

    public void breedAnimal(String userAnimalName){
        Animal animal = animalList[findAnimal(userAnimalName)];
        if (animal.isFed == true){
            for (int i = 0; i < animalList.length; i++){
                if (animalList[i] != null){
                    System.out.println("animalList[i].getClass() " + animalList[i].getClass());
                    if ((animal.getClass().equals(animalList[i].getClass())) && !(animalList[i].equals(animal)) && animalList[i] != null && animal.location.equals("zoo") && (animal.location.equals(animalList[i].location))){ // same species, another animal, same location
                        System.out.println("in");
                        if ((animal.getSex().equals("f") && animalList[i].getSex().equals("m")) || (animal.getSex().equals("m") && animalList[i].getSex().equals("f"))){
                            System.out.println("in2");
                            Animal[] babies = animalList[i].breed();
                            for (int j = 0; j < babies.length; j++){
                                addAnimal(animal.breed()[j]);
                            }
                            animalList[findAnimal(userAnimalName)].animalIs = "breeding";
                            animalList[findAnimal(userAnimalName)].isFed = false;
                            i = animalList.length;
                        } 
                    }   
                } 
                else{
                    System.out.println("nao");
                }
            }
        }
        else{
            removeAnimal(animal);
            System.out.println(animal.getName() + " died due to breeding without being fed.");
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
