public class Hawk extends NonPerforming {
    final public String animalType = "Hawk";
    public Hawk(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Hawk(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public void breed() {
        for (int i = 0; i < 4; i++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String hawkName = "Hawk" + randomNum;
            String hawkSex;
            if (randomNum % 2 == 0){
                hawkSex = "f";
            } else {
                hawkSex = "m";
            }
            Zoo.addAnimal(new Hawk(hawkName, hawkSex));
        }
    }
}
