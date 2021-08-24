package HWork3;

import java.util.Random;

public class Task3 {
    public static void main(String[] args) {
        int count = 0;
        int[] array = new int[15];
        System.out.println("Массив:");
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(99);
            System.out.print(array[i] + " ");
            if (array[i] % 2 == 0) {
                count++;
            }
        }
        System.out.println("\nКоличество четных чисел в массиве: " + count);
    }
}

