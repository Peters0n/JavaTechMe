package shoes;

public class NikeShoes implements IShoes{
   /* private String brandShoes;

    public NikeShoes(String brandShoes) {
        this.brandShoes = brandShoes;
    }*/
    public NikeShoes(){
    }

    @Override
    public void putOn() {
        System.out.println("Nike pants is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Nike pants!");
    }
}
