package lesson_12.shop;

import java.util.Scanner;

public class ControllerPrintProducts {
    ShopController shopcotroller = new ShopController();
    SorterController sorter = new SorterController();

    public void controlPrintProducts() {
        System.out.println("Вывод товара:");
        var shop = new Shop();
        System.out.println("Для выбора вида сортировки спивка товаров введите число от 1 до 3:\n" +
                "1 - - по цене(возрастание)\n" +
                "2 - - по цене(убывание)\n" +
                "3 - - по добавлению(сначал новые, потом более старые)\n" +
                "4 - - возврат в предыдущее меню");

        var sc = new Scanner(System.in);
        int scanner;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Неверный ввод, для продолжения работы введите одно из указанных чисел от 1 до 3");
                sc.next();
            }
            scanner = sc.nextInt();
        } while (scanner < 0 || scanner > 5);

        switch (scanner) {
            case 1 -> {//по цене(возрастание)
                try {
                    var list = shop.readProductList();
                    sorter.sortByPriceToUpper(list);
                    shopcotroller.process();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {// по цене(убывание)
                try {
                    var list = shop.readProductList();
                    sorter.sortByPriceToLower(list);
                    shopcotroller.process();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            case 3 -> {//по добавлению(сначал новые, потом более старые)
                try {
                    var list = shop.readProductList();
                    shop.printProductList();
                    shopcotroller.process();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            case 4 -> {//возврат в предыдущее меню
                try {
                    shopcotroller.process();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
