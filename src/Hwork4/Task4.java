package Hwork4;

import java.util.Random;

public class Task4 {
    //4)Посчитать сумму четных элементов стоящих над побочной диагональю (не включительно)

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] array = new int[m][n];
        Random r = new Random();
        int sumChet = 0;
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
                if (i + j < m - 1 && array[i][j] % 2 == 0) {
                    sumChet += array[i][j];
                }
            }
        }
        System.out.println("Сумма четных элементов массива,\nнаходящиеся над побочной диагональю (не включительно): " + sumChet);
    }
}
