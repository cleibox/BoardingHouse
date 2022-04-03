public class Lion extends Performing {
    final public String animalType = "Lion";
    public Lion(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Lion(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public void breed() {
        for (int i = 0; i < 3; i ++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String lionName = "Lion" + randomNum;
            String lionSex;
            if (randomNum % 2 == 0){
                lionSex = "f";
            } else {
                lionSex = "m";
            }
            Zoo.addAnimal(new Lion(lionName, lionSex));
        }
    }
}
