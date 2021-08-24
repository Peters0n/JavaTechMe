package HWork3;

public class Task2 {
    public static void main(String[] args) {
        int c = 0;
        int k = 0;
        for (int j = 1; j < 100; j++) {
            if (j % 2 != 0) {
                k += 1;
            }
        }
        int[] array = new int[k];
        for (int j = 1; j < 100; j++) {
            if (j % 2 != 0) {
                array[c] = j;
                System.out.print(array[c] + " ");
                c += 1;
            }
        }
        System.out.println(" ");
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}

