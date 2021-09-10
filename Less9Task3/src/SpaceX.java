import java.util.Random;

public class SpaceX implements IStart {
    public void strtSpaceX() {
        var check = new SpaceX().checkBeforeStart();
        if (!check) {
            stopRocket();
        } else {
            System.out.println("Предстартовая подготовка прошла успешно");
            var strtEgn = new SpaceX().checkStartEngine();
            if (strtEgn) {
                System.out.println("Проверка двигателя прошла успешно");
                start();
            } else {
                stopRocket();
            }
        }
    }

    public void stopRocket(){
        System.out.println("рокета никуда не полетит");
    }

    public boolean checkStartEngine() {
        var checkEgn = new Random().nextBoolean();
        if (!checkEgn) {
            System.out.println("Проверка двигателя провалена");
        }
        return checkEgn;
    }

    @Override
    public boolean checkBeforeStart() {
        var checkBeforeStart = new Random().nextBoolean();
        if (!checkBeforeStart) {
            System.out.println("Предстартовая подготовка провалена");
        }
        return checkBeforeStart;
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели запущены");
    }

    @Override
    public void start() {
        System.out.println("Ракета взлетела");
    }
}
