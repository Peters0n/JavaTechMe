import java.util.Scanner;

public class Computer {
    private String processor;
    private int opMem;
    private int hardDisk;
    private int resFullCycles;

    public Computer() {
    }

    public void setProcessor() {
        System.out.println("Введите модель процессора: ");
        Scanner sc = new Scanner(System.in);
        this.processor = sc.nextLine();
    }

    public String getProcessor() {
        return processor;
    }

    public void setOpMem() {
        System.out.println("Введите количество оперативной памяти:");
        Scanner sc = new Scanner(System.in);
        this.opMem = sc.nextInt();
    }

    public int getOpMem() {
        return opMem;
    }

    public void setHardDisk() {
        System.out.println("Введите количество памяти на жестком диске:");
        Scanner sc = new Scanner(System.in);
        this.hardDisk = sc.nextInt();
    }

    public int getHardDisk() {
        return hardDisk;
    }

    public void setResFullCycles() {
        System.out.println("Введите количество полных циклов включения компьютера (число не более 10): ");
        Scanner sc = new Scanner(System.in);
        int resFullCycles = sc.nextInt();
//        if (resFullCycles > 10) {
//            do {
//                System.out.println("Неверные данные!");
//                System.out.println("Введите количество полных циклов включения компьютера (число не более 10): ");
//                Scanner sc1 = new Scanner(System.in);
//                resFullCycles = sc1.nextInt();
//            } while (resFullCycles > 10);
//        } else {
//            if (resFullCycles < 10) {
                this.resFullCycles = resFullCycles;
           // }
        //}
    }

    public int getResFullCycles() {
        return resFullCycles;
    }

    public void computer() {
        System.out.println("Парамететры компьютера:");
        System.out.println("процессор: " + getProcessor());
        System.out.println("оперативная память: " + getOpMem());
        System.out.println("жесткий диск: " + getHardDisk());
        System.out.println("полный ресурс всех циклов(включения и выключения): " + getResFullCycles());
    }
}






