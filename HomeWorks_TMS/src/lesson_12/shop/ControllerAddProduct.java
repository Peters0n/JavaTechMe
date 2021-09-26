package lesson_12.shop;

import java.util.Scanner;

public class ControllerAddProduct {
    Storage storage = new Storage();
    Shop shop = new Shop();

    public void controlAddProduct() {

        System.out.println("Добвление товара:");
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
        } while (idProduct < 0);

        //Ввод имени товара
        System.out.println("Введите название товара:");
        var sc2 = new Scanner(System.in);
        sc2.hasNextLine();
        String nameProduct = sc2.nextLine();

        //Ввод цены товара
        int priceProduct;
        var sc3 = new Scanner(System.in);
        do {
            System.out.println("Введите цену товара:");
            while (!sc3.hasNextInt()) {
                System.out.println("Неверный ввод, введите число");
                sc3.next();
            }
            priceProduct = sc3.nextInt();
        } while (priceProduct < 0);

        //Добавление товара в список
        try {
            var productNew = new Product(idProduct, nameProduct, priceProduct);
            var list = shop.readProductList();
            shop.addProduct(productNew);
            shop.saveProductList();
            var shopcotroller = new ShopController();
            shopcotroller.process();
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
