package Hwork4;

import java.util.Random;

public class Task1 {
    //1) Почитать сумму четных элементов стоящих на главной диагонали.

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] array = new int[m][n];
        Random r = new Random();
        int k;
        int sum = 0;
        System.out.println("Массив:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = r.nextInt(10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j && array[i][j] % 2 == 0) {
                    k = array[i][j];
                    sum = sum + k;
                }
            }
        }
        System.out.println("Сумма четных элементов массива,\nстоящих на главной диагонали: " + sum);
    }
}
