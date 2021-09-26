package lesson_12.shop;

import java.util.Scanner;

public class ControllerEditProduct {
    Storage storage = new Storage();
    Shop shop = new Shop();

    public void controlEditProduct() {
        System.out.println("Редактирование товара:");
        var sc = new Scanner(System.in);

        // Ввод ID продукта
        int idProduct;
        do {
            System.out.println("Введите ID товара:");
            while (!sc.hasNextInt()) {
                System.out.println("Неверный ввод, введите число");
                sc.next();
            }
            idProduct = sc.nextInt();
        } while (idProduct < 1);

        //Ввод имени товара
        System.out.println("Введите название товара:");
        var sc2 = new Scanner(System.in);
        sc2.hasNextLine();
        String nameProduct = sc2.nextLine();

        //Ввод цены товара
        int priceProduct;
        do {
            System.out.println("Введите цену товара:");
            while (!sc.hasNextInt()) {
                System.out.println("Неверный ввод, введите число");
                sc.next();
            }
            priceProduct = sc.nextInt();
        } while (priceProduct < 0);

        //Добавление товара в список
        try {
            var productNew = new Product(idProduct, nameProduct, priceProduct);

            var list = shop.readProductList();
            shop.editProduct(productNew);
            shop.saveProductList();
            var shopcotroller = new ShopController();
            shopcotroller.process();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
