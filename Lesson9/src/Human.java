import jacket.IJacket;
import pants.IPants;
import shoes.IShoes;

public class Human implements IHuman {
    private String name;
    private IJacket jacket;
    private IPants pants;
    private IShoes shoes;

    public Human(String name, IJacket jacket, IPants pants, IShoes shoes) {
        this.name = name;
        this.jacket = jacket;
        this.pants = pants;
        this.shoes = shoes;
    }
    public Human(){
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IJacket getJacket(){
        return jacket;
    }
    public void setJacket(IJacket jacket){
        this. jacket = jacket;
    }

    public IPants getPants() {
        return pants;
    }

    public void setPants(IPants pants) {
        this.pants = pants;
    }

    public IShoes getShoes() {
        return shoes;
    }

    public void setShoes(IShoes shoes) {
        this.shoes = shoes;
    }

    @Override
    public void actionPutOn() {
        System.out.println("Human's name is " + getName());
        jacket.putOn();
        pants.putOn();
        shoes.putOn();
        System.out.println();
    }

    @Override
    public void actionTakeOff() {
        System.out.println("Human's name is " + getName());
        jacket.takeOff();
        pants.takeOff();
        shoes.takeOff();
        System.out.println();
    }
}


