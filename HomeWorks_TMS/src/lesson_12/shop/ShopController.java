package lesson_12.shop;

import java.util.Scanner;

public class ShopController {

    public void process() {
        System.out.println("Для начал работы и выбора дейтвий введите число от 1 до 5:\n" +
                "\n1 - - Вывод всех товаров\n" +
                "2 - - Добавление товара\n" +
                "3 - - Удаление товара\n" +
                "4 - - Редактирование товара\n" +
                "5 - - Выход");
        var sc = new Scanner(System.in);
        int scanner;
        do {
            while (!sc.hasNextInt()) {
                System.out.println("Неверный ввод, для продолжения работы введите одно из указанных чисел от 1 до 5");
                sc.next();
            }
            scanner = sc.nextInt();
            //!!!исправить выборку по меньше 1
        } while (scanner > 6);

        switch (scanner) {
            case 1 -> {//Вывод всех товаров
                var shopCntrPrint = new ControllerPrintProducts();
                shopCntrPrint.controlPrintProducts();
            }
            case 2 -> {//Добавление товара
                var shopCntrAdd = new ControllerAddProduct();
                shopCntrAdd.controlAddProduct();
            }
            case 3 -> {//Удаление товара
                var prodDelete = new ControllerDeleteProduct();
                prodDelete.controlDeleteProduct();

            }
            case 4 -> {//Редактирование товара
                var prodEdit = new ControllerEditProduct();
                prodEdit.controlEditProduct();
            }
            case 5 -> {//Выход
                var exitShop = new ExitShop();
                exitShop.exitShop();
            }
        }
    }

}
