package pants;

public class NikePants implements IPants{
  /*  private String brandPants;

    public NikePants(String brandPants) {
        this.brandPants = brandPants;
    }
    public NikePants(){
    }*/

    @Override
    public void putOn() {
        System.out.println("Nike pants is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Nike pants!");
    }
}
