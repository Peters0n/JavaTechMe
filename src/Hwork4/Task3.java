package Hwork4;

import java.util.Random;

public class Task3 {
    //3)Проверить произведение элементов какой диагонали больше.

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] array = new int[m][n];
        Random r = new Random();
        int k, h;
        int multipl1 = 1;
        int multipl2 = 1;
        System.out.println("Массив:");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = r.nextInt(10);
                System.out.print(array[i][j] + " ");
            }
            System.out.println(" ");
        }
        System.out.print("Главная диагональ: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    k = array[i][j];
                    multipl1 = multipl1 * k;
                    System.out.print(k + " ");
                }
            }
        }
        System.out.print("\nПобочная диагональ: ");
        for (int i = m - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (i + j == m - 1) {
                    h = array[i][j];
                    multipl2 = multipl2 * h;
                    System.out.print(h + " ");
                }
            }
        }
        System.out.println("\nПроизведение элементов основной диагонали: " + multipl1);
        System.out.println("Произведение элементов побочной диагонали: " + multipl2);
        if (multipl1 > multipl2) {
            System.out.println("Произведение элементов основной диагонали больше \nпроизведения элементов побочной");
        } else if (multipl2 > multipl1) {
            System.out.println("Произведение элементов побочной диагонали больше \nпроизведения элементов основной");
        } else {
            System.out.println("Произведениe элементов основной и побочной диагоналей равны");
        }
    }
}
