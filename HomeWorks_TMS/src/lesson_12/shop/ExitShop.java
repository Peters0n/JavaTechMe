package lesson_12.shop;

public class ExitShop {
    public void exitShop() {
        try {
            System.out.println("Магазин закрыт");
            System.exit(0);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }

}
