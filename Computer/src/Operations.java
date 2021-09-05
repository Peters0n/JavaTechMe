import java.util.Scanner;


public class Operations {
    // метод определения операции вкл, выкл или вывода информации о компьютере
    private String onOff;

    public Operations setOnOff() {
        System.out.println("Включить компьютер: on\nВыключить компьютер: off");
        this.onOff= new Scanner(System.in).nextLine();


       /* if(enterSwitch.equals("on") || enterSwitch.equals("off")) {
            this.onOff = enterSwitch;
        }else {
            do {
                System.out.println("Неверно введены данные.\nВключить компьютер: on\nВыключить компьютер: off\n");
                enterSwitch= new Scanner(System.in).nextLine();
            }while (!enterSwitch.equals("on") || !enterSwitch.equals("off"));
        }*/
       return null;
    }

    public String getOnOff() {
        return onOff;
    }
}



