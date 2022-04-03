public class Horse extends Performing {
    final public String animalType = "Horse";
    public Horse(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Horse(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public Animal[] breed() {
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String horseName = "Horse" + randomNum;
        String horseSex;
        if (randomNum % 2 == 0){
            horseSex = "f";
        } else {
            horseSex = "m";
        }
        Animal[] horseBabies = new Animal[1];
        horseBabies[0] = new Horse(horseName, horseSex);
        return horseBabies;
    }
}
