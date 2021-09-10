package by.teachmeskills.robot.legs;

public class SamsungLeg implements ILeg {
    private int price;

    public SamsungLeg(int price){
        this.price = price;}

    public SamsungLeg(){
    }

    @Override
    public void step() {
        System.out.println("Robot Samsung шагает");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
