package by.teachmeskills.robot.legs;

public class ToshibaLeg implements ILeg{
    private int price;

    public ToshibaLeg(int price){
        this.price = price;
    }
    public ToshibaLeg(){
    }

    @Override
    public void step() {
        System.out.println("Robot Toshiba шагает");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
