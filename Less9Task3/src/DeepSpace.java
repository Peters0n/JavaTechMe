import java.util.Random;

public class DeepSpace implements IStart {
    public void startDeepSpace() {
        var check = new DeepSpace().checkBeforeStart();
        if (check) {
            checkBeforeStartTrue();
            var checkEn = new DeepSpace().checkEngine();
            if (checkEn) {
                startEngine();
                start();
            }else {
                notStartEngine();
                rocketStop();
            }
        } else {
            checkBeforeStartFalse();
            rocketStop();
        }
    }

    public boolean startEngineCount() {
        return new Random().nextBoolean();
    }

    public boolean checkEngine() {
        var chk = new DeepSpace().startEngineCount();
        for (int i = 0; i <= 3; i++){
            if (chk){
                break;
            }
        }
        return chk;

    }
    public boolean checkBeforeStartCount(){
        return new Random().nextBoolean();
    }

    @Override
    public boolean checkBeforeStart() {
        return checkBeforeStartCount();
    }
    public void checkBeforeStartTrue (){
        System.out.println("Предстартовая подготовка прошла упешно!");
    }
    public void checkBeforeStartFalse (){
        System.out.println("Предстартовая проверка провалена");
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатель завелся");
    }

    public void notStartEngine() {
        System.out.println("Проверка двигателя провалена");
    }

    @Override
    public void start() {
        System.out.println("Рокета взлетела");
    }

    public void rocketStop() {
        System.out.println("Рокета никуда не полетит");
    }
}

