
public class Circus extends BoardingHouse{
    @Override
    public void printList() {
        System.out.println("Circus List --------------------|");
        for (int i = 0; i < animalList.length; i++){
            if (animalList[i] != null){
                if (animalList[i].location.equals("circus")){
                    System.out.println(animalList[i].getClass() + ": " + animalList[i].getName());
                }
            }
        }  
    }
   
    public void train(Animal animal){ // make a validity checker unless ... 
        if (animal.location.equals("circus") && animal instanceof Performing){
            if (animal.isFed == true){
                animal.animalIs = "training";
                animal.isTrained = true;
                animal.isFed = false;
                animal.isRested = false;
                System.out.println("Training Successful");
            }
            else{
                removeAnimal(animal);
                System.out.println(animal.getName() + " died due to training without being fed.");
            }
        }
        else {
            System.out.println("You can't train an animal if they're not at the circus or are nonperforming animals.");
        }
    }

    public void perform(Animal animal){
        if (animal.location.equals("circus")){
            if (animal.isFed == true && animal.isTrained == true){
                animal.animalIs = "performing";
                animal.isFed = false;
                animal.isRested = false;
                System.out.println("Performance Successful");
            } else if (animal.isFed == true){
                System.out.println(animal.getName() + " cannot perform because they're not trained!");
            }
            else{
                removeAnimal(animal);
                System.out.println(animal.getName() + " died due to performing without being fed.");
            }
        }
        else {
            System.out.println("You can't make an animal perform if they're not at the circus.");
        }
    }

}