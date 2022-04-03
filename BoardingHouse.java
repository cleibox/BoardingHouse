public abstract class BoardingHouse {
    public Animal[] animalList = new Animal[50]; 

    public abstract void printList();
  
    
    public void transferAnimal(Animal animal){
        if (this instanceof Zoo){
            this.removeAnimal(animal);
            
        }
        else {
            this.removeAnimal(animal);
        }
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
    

    public void removeAnimal(Animal animal) {
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] == animal){                
                animalList[i] = null;
                System.out.println("Removal Successful");
                i = animalList.length;
            }
        }  
    }

    public int findAnimal(String animalName){
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] != null){
                if (animalList[i].getName().equals(animalName)){
                    return i;
                }
            }
        }
        return -1; 
    }

    public void addAnimal(Animal animal) {
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] == null){                
                animal.location = "zoo";
                animalList[i] = animal;
                i = animalList.length;
            }
        }
    }

    public void rest(String animalName){
        if ((animalList[findAnimal(animalName)].animalIs.equals("exhibiting") || animalList[findAnimal(animalName)].animalIs.equals("breeding") || animalList[findAnimal(animalName)].animalIs.equals("training") || animalList[findAnimal(animalName)].animalIs.equals("performing")) && !(animalList[findAnimal(animalName)] instanceof Parrot)){
            System.out.println(animalList[findAnimal(animalName)].getName() + " is now tired after " + animalList[findAnimal(animalName)].animalIs + " and will rest right now.");
            animalList[findAnimal(animalName)].isRested = true;
            animalList[findAnimal(animalName)].animalIs = "resting";
        }
    }

}
