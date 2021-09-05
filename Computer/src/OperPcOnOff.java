import java.util.Random;
import java.util.Scanner;

public class OperPcOnOff {
    // метод действия при вкл
    int choiseSituationPc;
    int choiseSituationUser;

    public void setChoiseSituationPc() {
        Random rand = new Random();
        this.choiseSituationPc = rand.nextInt(2);
    }

    public int getChoiseSituationPc() {
        return choiseSituationPc;
    }

    public void setChoiseSituationUser() {
        System.out.println("Введите число: 1 - вкл, 0 - выкл.");
        Scanner scan = new Scanner(System.in);
        this.choiseSituationUser = scan.nextInt();
    }

    public int getChoiseSituationUser() {
        return choiseSituationUser;
    }

    public void pcOnTrue() {
        var pcONn = new OperPcOnOff();
        pcONn.setChoiseSituationPc();
        pcONn.setChoiseSituationUser();
        if (pcONn.getChoiseSituationPc() == pcONn.getChoiseSituationUser() && pcONn.getChoiseSituationUser() == 0) {
            System.out.println("Компьютер выключается");
        } else {
            if (pcONn.getChoiseSituationPc() == pcONn.getChoiseSituationUser() && pcONn.getChoiseSituationUser() == 1) {
                System.out.println("Компьютер включается");
            } else {
                if(pcONn.getChoiseSituationPc() != pcONn.getChoiseSituationUser()) {
                    System.out.println("Компьютер сгорел");
                }
            }
        }
    }
}

