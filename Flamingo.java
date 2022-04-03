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
    public Animal[] breed() {
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String FlamingoName = "Flamingo" + randomNum;
        String FlamingoSex;
        if (randomNum % 2 == 0){
            FlamingoSex = "f";
        } else {
            FlamingoSex = "m";
        }
        Animal[] flamingoBabies = new Animal[1];
        flamingoBabies[0] = new Flamingo(FlamingoName, FlamingoSex);
        return flamingoBabies;
    }
}
