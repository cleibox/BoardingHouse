public class Elephant extends Performing {
    final public String animalType = "Elephant";
    public Elephant(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Elephant(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public Animal[] breed() {
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String elephantName = "Elephant" + randomNum;
        String elephantSex;
        if (randomNum % 2 == 0){
            elephantSex = "f";
        } else {
            elephantSex = "m";
        }
        Animal[] elephantBabies = new Animal[1];
        elephantBabies[0] = new Elephant(elephantName, elephantSex);
        return elephantBabies;
    }
}
