package jacket;

public class NikeJacket implements IJacket{
    /*private String brandJacket;

    public NikeJacket(String brandJacket) {
        this.brandJacket = brandJacket;
    }*/
    public NikeJacket(){
    }

    @Override
    public void putOn() {
        System.out.println("Nike jacket is the best to wear!");
    }

    @Override
    public void takeOff() {
        System.out.println("I'm sat to take off Nike jacket!");
    }
}
