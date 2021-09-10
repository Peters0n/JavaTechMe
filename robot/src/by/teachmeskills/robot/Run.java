package by.teachmeskills.robot;

import by.teachmeskills.robot.hands.SamsungHand;
import by.teachmeskills.robot.hands.SonyHand;
import by.teachmeskills.robot.hands.ToshibaHand;
import by.teachmeskills.robot.heads.SamsungHead;
import by.teachmeskills.robot.heads.SonyHead;
import by.teachmeskills.robot.heads.ToshibaHead;
import by.teachmeskills.robot.legs.SamsungLeg;
import by.teachmeskills.robot.legs.SonyLegs;
import by.teachmeskills.robot.legs.ToshibaLeg;


import java.util.Random;

public class Run {
    public static void main(String[] args) {
        /*
        Создать по 3 реализации(Sony, Toshiba, Samsung) каждой запчасти(IHead, IHand, ILeg)
        Класс SonyHead является примером реализацией головы от Sony.
        Создайте 3 робота с разными комплектующими.
        Например у робота голова и нога от Sony а, рука от Samsung.
        У всех роботов вызовите метод action.
        Среди 3-х роботов найдите самого дорогого.
        */
        Robot robotSony = new Robot(new SonyHead(100), new SonyHand(50), new SonyLegs(150));
        System.out.println("Robot Sony из запчастей Sony стоит: " + robotSony.getPrice());
        robotSony.action();
        System.out.println();

        Robot robotToshi = new Robot(new ToshibaHead(80), new ToshibaHand(40), new ToshibaLeg(100));
        System.out.println("Robot Toshiba из запчастей Toshiba стоит: " + robotToshi.getPrice());
        robotToshi.action();
        System.out.println();

        Robot robotSams = new Robot(new SamsungHead(90), new SamsungHand(70), new SamsungLeg(200));
        System.out.println("Robot Samsung из запчастей Samsung стоит: " + robotSams.getPrice());
        robotSams.action();
        System.out.println();

        Robot[] randomRobotArray = new Robot[3];
        String[] randomRobotComplectArray = new String[3];

        for (int i = 0; i <= 2; i++) {
            int rand = new Random().nextInt(3);
            if (rand == 1) {
                Robot randomRobotN = new Robot(robotSams.getHead(), robotSony.getHand(), robotSony.getLeg());
                randomRobotArray[i] = randomRobotN;
                randomRobotComplectArray[i] = "голова от Robot Samsung, руки от Robot Sony, ноги от Robot Sony";
            } else if (rand == 2) {
                Robot randomRobotN = new Robot(robotSony.getHead(), robotToshi.getHand(), robotSams.getLeg());
                randomRobotArray[i] = randomRobotN;
                randomRobotComplectArray[i] = "голова от Robot Sony, руки от Robot Toshiba, ноги от Robot Samsung";
            } else {
                Robot randomRobotN = new Robot(robotToshi.getHead(), robotSams.getHand(), robotToshi.getLeg());
                randomRobotArray[i] = randomRobotN;
                randomRobotComplectArray[i] = "голова от Robot Toshiba, руки от Robot Samsung, ноги от Robot Toshiba";
            }
        }
        Robot robotRandom1 = randomRobotArray[0];
        Robot robotRandom2 = randomRobotArray[1];
        Robot robotRandom3 = randomRobotArray[2];

        System.out.println("Робот Random1 состоит из запчастей: " + randomRobotComplectArray[0] + " и стоит: " + robotRandom1.getPrice());
        robotRandom1.action();
        System.out.println();
        System.out.println("Робот Random2 состоит из запчастей: " + randomRobotComplectArray[1] + " и стоит: " + robotRandom2.getPrice());
        robotRandom2.action();
        System.out.println();
        System.out.println("Робот Random3 состоит из запчастей: " + randomRobotComplectArray[2] + " и стоит: " + robotRandom3.getPrice());
        robotRandom3.action();
        System.out.println();

        if (robotSams.getPrice() > robotSony.getPrice() && robotSams.getPrice() > robotToshi.getPrice()) {
            System.out.println("Robot Samsung самый дорогой робот!");
        } else if (robotSony.getPrice() > robotToshi.getPrice() && robotSony.getPrice() > robotSams.getPrice()) {
            System.out.println("Robot Sony самый дорогой робот!");
        } else {
            System.out.println("Robot Toshiba самый дорогой робот!");
        }
    }

}


