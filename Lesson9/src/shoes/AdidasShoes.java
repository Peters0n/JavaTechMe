package shoes;

public class AdidasShoes implements IShoes{
   /* private  String brandShoes;


    public AdidasShoes(String brandShoes) {
        this.brandShoes = brandShoes;
    }*/
    public AdidasShoes(){
    }

    @Override
    public void putOn() {
        System.out.println("Adidas pants is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Adidas pants!");
    }
}
