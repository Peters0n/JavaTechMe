package lesson_12.firstPart;

public class ShopApp {
    public static void main(String[] args) {

        var bread = new Product(45, "bread", 10);
        var milk = new Product(12, "milk", 20);
        var meat = new Product(48, "meat", 400);
        var potato = new Product(7,"potato", 5);
        var butter = new Product(5, "butter", 200);
        var mushrooms = new Product(89, "mushroom", 350);

        Shop shoppp = new Shop();

        shoppp.addProduct(bread);
        shoppp.addProduct(milk);
        shoppp.addProduct(meat);
        shoppp.addProduct(potato);
        shoppp.addProduct(butter);
        shoppp.addProduct(mushrooms);

        System.out.println("List after adding to:");
        shoppp.printProductList();
        System.out.println("\nList after deleting:");
        shoppp.deleteProduct(12);
        shoppp.printProductList();
        System.out.println("\nList after replacing:");
        shoppp.replaceProduct(new Product(45, "tea", 50));
        shoppp.printProductList();
        System.out.println("\nList after sotring by price:");
        shoppp.sortByPrice();


    }
}
