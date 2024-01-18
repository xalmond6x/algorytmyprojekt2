package zadanie1.Data.Data_from_file;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class file_txt {

    public static int[][] readFromFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));
            int rows = scanner.nextInt();
            int[][] array = new int[rows][2];

            for (int i = 0; i < rows; i++) {
                array[i][0] = scanner.nextInt();
                array[i][1] = scanner.nextInt();
            }

            return array;
        } catch (FileNotFoundException e) {
            System.err.println("Błąd wczytania z pliku: " + e.getMessage());
            return null;
        }
    }
}
