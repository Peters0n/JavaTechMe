package shoes;

public class PumaShoes implements IShoes{
  /*  private String brandShoes;

    public PumaShoes(String brandShoes) {
        this.brandShoes = brandShoes;
    }*/
    public PumaShoes(){
    }

    @Override
    public void putOn() {
        System.out.println("Puma pants is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Puma pants!");
    }
}
