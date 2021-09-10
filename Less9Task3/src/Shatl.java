import java.util.Random;

public class Shatl implements IStart{
     void startShatl(){
        var check = new Shatl().checkBeforeStart();
        if (check){
            startEngine();
            start();
        }
    }



    @Override
    public boolean checkBeforeStart() {
        boolean rtrn;
        int number = new Random().nextInt(10);
        if(number > 3){
            rtrn = true;
            System.out.println("проверка прошла успешно!");
        }else {
            rtrn = false;
            System.out.println("Проверка провалена!");
        }
        return rtrn;
    }

    @Override
    public void startEngine() {
        System.out.println("Двигатели шатла запущены. Системы в норме.");
    }

    @Override
    public void start() {
        System.out.println("Старт Шатла");
    }
}
