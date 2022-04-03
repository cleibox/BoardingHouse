public class Walrus extends NonPerforming {
    final public String animalType = "Walrus";
    public Walrus(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Walrus(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public Animal[] breed() {
        int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
        String WalrusName = "Walrus" + randomNum;
        String WalrusSex;
        if (randomNum % 2 == 0){
            WalrusSex = "f";
        } else {
            WalrusSex = "m";
        }
        Animal[] walrusBabies = new Animal[1];
        walrusBabies[0] = new Dolphin(WalrusName, WalrusSex);
        return walrusBabies;
    }
}
