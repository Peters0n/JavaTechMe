package jacket;

public class AdidasJacket implements IJacket{
   /*private  String brandJacket;

    public AdidasJacket(String brandJacket) {
        this.brandJacket = brandJacket;
    }*/
    public AdidasJacket(){
    }

    @Override
    public void putOn() {
        System.out.println("Adidas jacket is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Adidas jacket!");
    }
}
