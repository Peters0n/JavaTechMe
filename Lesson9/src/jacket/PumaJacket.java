package jacket;

public class PumaJacket implements IJacket{
  /*  private String brandJacket;

    public PumaJacket(String brandJacket) {
        this.brandJacket = brandJacket;
    }*/

    public PumaJacket(){
    }

    @Override
    public void putOn() {
        System.out.println("Puma jacket is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Puma jacket!");
    }
}
