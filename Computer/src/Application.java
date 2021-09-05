public class Application {
    public static void main(String[] args) {

        var pc1 = new Computer();
        pc1.setProcessor();
        pc1.setOpMem();
        pc1.setHardDisk();
        pc1.setResFullCycles();
        pc1.computer();
        int countStartStop = 0;

        var start = new Operations();
        start.setOnOff();

        do {
            switch (start.getOnOff()) {
                case "on" -> {
                    System.out.println("Результат включения: ");
                    var pcOn = new OperPcOnOff();
                    pcOn.pcOnTrue();
                    countStartStop++;
                    System.out.println("счетчик запусков: " + countStartStop);
                }
                case "off" -> {
                    System.out.println("Результат выключения");
                    var pcOn = new OperPcOnOff();
                    pcOn.pcOnTrue();
                    countStartStop++;
                    System.out.println("счетчик запусков" + countStartStop);
                }
            }
        }
        while (countStartStop < pc1.getResFullCycles());
        if (countStartStop >= pc1.getResFullCycles()) {
            System.out.println("Компьютер сгорел! Превышен лимит ресурса.");
        }
    }
}


