package pants;

public class PumaPants implements IPants{
   /* private String brandPants;

    public PumaPants(String brandPants) {
        this.brandPants = brandPants;
    }
    public PumaPants(){
    }*/

    @Override
    public void putOn() {
        System.out.println("Puma pants is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Puma pants!");
    }
}
