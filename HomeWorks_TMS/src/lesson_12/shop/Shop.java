package lesson_12.shop;

import java.util.*;

public class Shop {
    private Map<Integer, Product> productList = new HashMap<>();

    public void addProduct(Product product) {
        productList.putIfAbsent(product.getId(), product);
    }

    public void setProductList(Map<Integer, Product> productList) {
        this.productList = productList;
    }

    public void deleteProduct(int id) {
        productList.remove(id);
    }

    public void editProduct(Product product) {
        productList.put(product.getId(), product);
    }

    public void printProductList() {
        for (Map.Entry<Integer, Product> item : productList.entrySet()) {
            System.out.printf("id: %d name: %s price: %d \n",
                    item.getKey(),
                    item.getValue().getName(),
                    item.getValue().getPrice());
        }
    }

    public void saveProductList() {
        var saver = new Storage();
        saver.saveDataBase(productList);
    }

    public Map<Integer, Product> readProductList() {
        var writer = new Storage();
        this.productList = writer.readerDataBase();
        return productList;
    }
}



