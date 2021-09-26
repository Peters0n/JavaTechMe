package lesson_12.shop;

import java.util.Scanner;

public class ControllerDeleteProduct {
    ShopController shopcotroller = new ShopController();
    Shop shop = new Shop();
    Storage storage = new Storage();

    public void controlDeleteProduct() {
        System.out.println("Удаление товара:");
        var shop = new Shop();
        System.out.println("Для выбора действия введите число от 1 или 2:\n" +
                "1 - - удаление товара\n" +
                "2 - - возврат в предыдущее меню ");

        var sc = new Scanner(System.in);
        int scanner;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Неверный ввод, для продолжения работы введите одно из указанных чисел 1 или 2");
                sc.next();
            }
            scanner = sc.nextInt();
        } while (scanner < 0 || scanner > 3);

        switch (scanner) {
            case 1 -> {//удаление
                try {

                    System.out.println("Удаление товара:");
                    var sc1 = new Scanner(System.in);
                    int idDelete;
                    System.out.println("Введите ID товара для удаления:");
                    do {
                        while (!sc1.hasNextInt()) {
                            System.out.println("Неверный ввод, для продолжения работы введите ID товара");
                            sc1.next();
                        }
                        idDelete = sc1.nextInt();
                    } while (idDelete < 0);
                    var list = shop.readProductList();
                    shop.deleteProduct(idDelete);
                    shop.saveProductList();

                    try {
                        shopcotroller.process();
                    } catch (RuntimeException e) {
                        e.printStackTrace();
                    }
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }
            case 2 -> {// возврат в предыдущее меню
                try {
                    shopcotroller.process();
                } catch (RuntimeException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
