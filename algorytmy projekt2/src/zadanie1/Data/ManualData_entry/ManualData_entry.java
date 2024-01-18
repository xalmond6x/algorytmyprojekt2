package zadanie1.Data.ManualData_entry;

import java.util.Scanner;

public class ManualData_entry {

    public static int[][] readManually() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj ilość par liczb całkowitych: ");
        int rows = scanner.nextInt();

        int[][] array = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            System.out.print("Podaj pierwszą współrzędną " + (i + 1) + ": ");
            array[i][0] = scanner.nextInt();

            System.out.print("Podaj drugą współrzędną " + (i + 1) + ": ");
            array[i][1] = scanner.nextInt();
        }

        return array;
    }
}
