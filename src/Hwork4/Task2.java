package Hwork4;

import java.util.Random;

public class Task2 {

    //2)Вывести нечетные элементы находящиеся под главной
    //диагональю(включительно).
    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] array = new int[m][n];
        Random r = new Random();
        System.out.println("Массив:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = r.nextInt(10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("Нечетные элементы массива,\nнаходящиеся под главной диагональю(включительно):");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i >= j && array[i][j] % 2 != 0) {
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }
}
