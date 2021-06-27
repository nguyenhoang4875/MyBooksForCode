package Chapter_02;

import java.util.Scanner;

public class TapConKphanTu {
    private int count = 0;

    public void generateTapCon() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter n: ");
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("Please enter k: ");
        int k = Integer.parseInt(scanner.nextLine());
        int[] array = new int[n];
        init(array);
        print(array);
        nextBinaryGenerate(array);
        System.out.println("sum is: " + count);
    }

    public void init(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = 0;
        }
    }

    public void nextTapCon(int[] array) {
        for (int i = array.length - 1; i >= 0; i--) {
            if (array[i] == 0) {
                array[i] = 1;
            } else {
                while (array[i] == 1 && i > 0) {
                    i--;
                }
                if (i == 0 && array[i] == 1) {
                    break;
                }
                array[i] = 1;
                for (int j = array.length - 1; j > i; j--) {
                    array[j] = 0;
                }
            }
            print(array);
            nextTapCon(array);
        }

    }

    public void print(int[] array) {
        count++;
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println();
    }
}
