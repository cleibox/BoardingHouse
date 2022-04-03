public class Flamingo extends NonPerforming {
    final public String animalType = "Flamingo";
    public Flamingo(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Flamingo(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public void breed() {
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String FlamingoName = "Flamingo" + randomNum;
        String FlamingoSex;
        if (randomNum % 2 == 0){
            FlamingoSex = "f";
        } else {
            FlamingoSex = "m";
        }
        Zoo.addAnimal(new Flamingo(FlamingoName, FlamingoSex));
    }
}
