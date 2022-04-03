public class Seal extends NonPerforming {
    final public String animalType = "Seal";
    public Seal(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Seal(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public Animal[] breed() {
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String SealName = "Seal" + randomNum;
        String SealSex;
        if (randomNum % 2 == 0){
            SealSex = "f";
        } else {
            SealSex = "m";
        }
        Animal[] sealBabies = new Animal[1];
        sealBabies[0] = new Seal(SealName, SealSex);
        return sealBabies;
    }
}
