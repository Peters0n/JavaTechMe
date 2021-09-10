import java.util.Random;

public class Cosmodrom implements IStart{
    public void starting(){
        System.out.println("Предстартовая подготовка!");
        IStart check = new Cosmodrom();
        var checkBeforeStart = new Random().nextBoolean();
        if(checkBeforeStart){
            System.out.println("Предстартовая подготовка прошла упешно!");
            check.startEngine();
            check.start();
        } else {
            System.out.println("Предстартовая проверка провалена");
        }
    }

    @Override
    public boolean checkBeforeStart() {
        return true;
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатель рокеты запущен!");
        for(int i = 10; i >= 0; i--){
            System.out.println("Обратный отсчет: " + i);
        }
    }

    @Override
    public void start() {
        System.out.println("Ракета взлетела!");

    }
}
