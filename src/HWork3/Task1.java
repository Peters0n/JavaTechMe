package HWork3;

public class Task1 {
    public static void main(String[] args) {
        int[] array = new int[10];
        int i = 0;
        for (int j = 2; j <= 20; j++) {
            if (j % 2 == 0) {
                array[i] = j;
                System.out.print(array[i] + " ");
                i += 1;
            }
        }
        System.out.println(" ");
        for (i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}



