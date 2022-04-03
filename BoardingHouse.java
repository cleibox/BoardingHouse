public abstract class BoardingHouse {
    public static Animal[] animalList = new Animal[50]; 

    public abstract void printList();
  
    /*
    public static void transferAnimal(Animal animal){
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] != null){
                if (animalList[i] == animal){
                    if (animalList[i].location.equals("circus")){
                        animalList[i].location = ("zoo");
                    }
                    else{ // animalList[i].location.equals("zoo");
                        animalList[i].location = ("circus");
                    }
                }
            }
        }
    }
    */

    public static void removeAnimal(Animal animal) {
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] == animal){                
                animalList[i] = null;
                System.out.println("Removal Successful");
                i = animalList.length;
            }
        }  
    }

    public static int findAnimal(String animalName){
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] != null){
                if (animalList[i].getName().equals(animalName)){
                    return i;
                }
            }
        }
        return -1; 
    }

    public static void breedAnimal(Animal animal){
        // find f and m
        for (int i = 0; i < animalList.length; i++){
            if ((animal.getClass() == animalList[i].getClass()) && (animalList[i] != animal)){
                if (animal.getSex().equals("f") && animalList[i].getSex().equals("m")){
                    animalList[i].breed();
                } else if (animal.getSex().equals("m") && animalList[i].getSex().equals("f")){
                    
                }
            }
        }
    }

    public static void rest(String animalName){
        if ((animalList[findAnimal(animalName)].animalIs.equals("exhibiting") || animalList[findAnimal(animalName)].animalIs.equals("breeding") || animalList[findAnimal(animalName)].animalIs.equals("training") || animalList[findAnimal(animalName)].animalIs.equals("performing")) && !(animalList[findAnimal(animalName)] instanceof Parrot)){
            System.out.println(animalList[findAnimal(animalName)].getName() + " is now tired after " + animalList[findAnimal(animalName)].animalIs + " and will rest right now.");
            animalList[findAnimal(animalName)].isRested = true;
            animalList[findAnimal(animalName)].animalIs = "resting";
        }
    }

}
