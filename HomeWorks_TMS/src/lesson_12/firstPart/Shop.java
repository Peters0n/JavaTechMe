package lesson_12.firstPart;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Shop {
    private Map<Integer, Product> productList = new HashMap<>();

    public Shop() {
        this.productList = productList;
    }

    public void addProduct(Product product){
        productList.putIfAbsent(product.getId(), product);
    }

    public void deleteProduct(int id){
        productList.remove(id);
    }

    public void replaceProduct(Product product){
        productList.put(product.getId(), product);
    }
    public void printProductList(){
        for(Map.Entry<Integer,Product> item : productList.entrySet()){
            System.out.printf("id: %d name: %s price: %d \n",
                    item.getKey(),
                    item.getValue().getName(),
                    item.getValue().getPrice());
        }
    }

    public void sortByPrice(){
        productList.values().stream().sorted(Comparator.comparing(Product::getPrice)).forEach(System.out::println);
    }

}
