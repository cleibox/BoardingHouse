public abstract class Performing extends Animal {
    @Override
    public void transfer() {
        
        if (this. instanceof Zoo){
            this.location = "circus";
            System.out.println("Successful Transfer from the zoo to the circus.");
        } else{ // this.location.equals("circus")
            this.location = "zoo";
            System.out.println("Successful Transfer from the circus to the zoo.");
        }
    }
}
