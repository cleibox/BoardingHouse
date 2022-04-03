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
    public Animal[] breed() {
        Animal[] hawkBabies = new Animal[4];
        for (int i = 0; i < hawkBabies.length; i++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String hawkName = "Hawk" + randomNum;
            String hawkSex;
            if (randomNum % 2 == 0){
                hawkSex = "f";
            } else {
                hawkSex = "m";
            }
            hawkBabies[i] = new Hawk(hawkName, hawkSex);
        }
        return hawkBabies;
    }
}
