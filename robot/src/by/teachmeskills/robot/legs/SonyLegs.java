package by.teachmeskills.robot.legs;

import by.teachmeskills.robot.heads.SonyHead;

public class SonyLegs implements ILeg{
    private int price;

    public SonyLegs(int price){
        this.price = price;
    }
    public SonyLegs(){
    }

    @Override
    public void step() {
        System.out.println("Robot Sony шагает");
    }

    @Override
    public int getPrice() {
        return price;
    }
}
