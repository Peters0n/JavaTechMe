package Hwork4;

import java.util.Random;

public class Task5 {
    //5)Транспонировать матрицу(1 столбец станет 1-й строкой, 2-й столбец - 2-й строкой и т. д.)

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] array = new int[m][n];
        int[][] array2 = new int[m][n];
        Random r = new Random();
        System.out.println("Массив:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = r.nextInt(10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.println("Транспонированный массив:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array2[i][j] = array[j][i];
                System.out.print(array2[i][j] + " ");
            }
            System.out.println(" ");
        }
    }
}
