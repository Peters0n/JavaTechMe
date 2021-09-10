package pants;

public class AdidasPants implements IPants {
  /*  private String brandPants ;

    public AdidasPants(String brandPants) {
            this.brandPants = brandPants;
        }*/
        public AdidasPants(){

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
