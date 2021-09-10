import jacket.*;
import pants.*;
import shoes.*;
public class Application {
    public static void main(String[] args) {
        var humanAdidas = new Human("Jack", new AdidasJacket(), new AdidasPants(), new AdidasShoes());
        var humanPuma = new Human("Ron", new PumaJacket(), new PumaPants(), new PumaShoes());
        var humanNike = new Human("Bill", new NikeJacket(), new NikePants(), new NikeShoes());
        humanAdidas.actionPutOn();
        humanAdidas.actionTakeOff();
        humanNike.actionPutOn();
        humanNike.actionTakeOff();
        humanPuma.actionPutOn();
        humanPuma.actionTakeOff();
        humanAdidas.getJacket().putOn();
        humanNike.getPants().takeOff();
        humanPuma.getShoes().putOn();
    }

}
