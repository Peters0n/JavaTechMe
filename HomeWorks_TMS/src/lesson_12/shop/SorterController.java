package lesson_12.shop;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class SorterController {
    public void sortByPriceToUpper(Map<Integer, Product> productList) {
        productList.values().stream().sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }

    public void sortByPriceToLower(Map<Integer, Product> productList) {
        productList.values().stream().sorted(Collections.reverseOrder(Comparator.comparing(Product::getPrice)))
                .forEach(System.out::println);
    }
}
