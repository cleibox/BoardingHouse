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
    public Animal[] breed() {
        Animal[] parrotBabies = new Animal[6];
        
        for (int i = 0; i < parrotBabies.length; i ++){
            int randomNum = (int) (Math.random() * (10000 - 3)) + 3;
            String parrotName = "Parrot" + randomNum;
            String parrotSex;
            if (randomNum % 2 == 0){
                parrotSex = "f";
            } else {
                parrotSex = "m";
            }
            parrotBabies[i] = new Parrot(parrotName, parrotSex);
        }
        return parrotBabies;
    }
}
