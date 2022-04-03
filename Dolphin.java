public class Dolphin extends NonPerforming {
    final public String animalType = "Dolphin";
    public Dolphin(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Dolphin(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public void breed() {
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String dolphinName = "Dolphin" + randomNum;
        String dolphinSex;
        if (randomNum % 2 == 0){
            dolphinSex = "f";
        } else {
            dolphinSex = "m";
        }
        Zoo.addAnimal(new Dolphin(dolphinName, dolphinSex));
    }
}
