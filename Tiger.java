public class Tiger extends Performing {
    final public String animalType = "Tiger";
    public Tiger(){
        this.setName("unnamed");
        this.setSex("f");
    }
    public Tiger(String name, String sex){
        this.setName(name);
        this.setSex(sex);
    }
    @Override
    public Animal[] breed(){
        Animal[] tigerBabies = new Animal[3];

        for (int i = 0; i < tigerBabies.length; i ++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String TigerName = "Tiger" + randomNum;
            String TigerSex;
            if (randomNum % 2 == 0){
                TigerSex = "f";
            } else {
                TigerSex = "m";
            }
            tigerBabies[i] = new Tiger(TigerName, TigerSex);
        }
        return tigerBabies;
    }
}
