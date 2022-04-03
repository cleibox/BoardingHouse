public class Parrot extends NonPerforming {
    final public String animalType = "Parrot";
    public Parrot(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Parrot(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public void breed() {
        for (int i = 0; i < 6; i ++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String parrotName = "Parrot" + randomNum;
            String parrotSex;
            if (randomNum % 2 == 0){
                parrotSex = "f";
            } else {
                parrotSex = "m";
            }
            Zoo.addAnimal(new Parrot(parrotName, parrotSex));
        }
    }
}
