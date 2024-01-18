package zadanie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class MergeSortExample {

    public static void main(String[] args) {
        int[][] array;

//         Wybierz jedną z poniższych metod wczytywania danych
//         array = readFromFile("plik.txt");
//         array = readManually();
         array = generateRandom(6, 10);

        System.out.println("Tablica przed sortowaniem: ");
        printArray(array);

        // Wywołanie funkcji sortującej
        mergeSort(array, 0, array.length - 1);

        System.out.println("\n Tablica po sortowaniu: ");
        printArray(array);
    }

    // Funkcja do sortowania przez scalanie
    private static void mergeSort(int[][] array, int left, int right) {
        if (left < right) {
            // Znalezienie środka tablicy
            int middle = (left + right) / 2;

            // Sortowanie dwóch połówek
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);

            // Scalanie dwóch posortowanych połówek
            merge(array, left, middle, right);
        }
    }

    // Funkcja do scalania dwóch podtablic
    private static void merge(int[][] array, int left, int middle, int right) {
        int n1 = middle - left + 1;
        int n2 = right - middle;

        // Tworzenie tymczasowych tablic pomocniczych
        int[][] leftArray = Arrays.copyOfRange(array, left, left + n1);
        int[][] rightArray = Arrays.copyOfRange(array, middle + 1, middle + 1 + n2);

        // Indeksy pomocnicze
        int i = 0, j = 0, k = left;

        // Scalanie tablic pomocniczych z powrotem do oryginalnej tablicy
        while (i < n1 && j < n2) {
            if (compare(leftArray[i], rightArray[j]) <= 0) {
                array[k++] = leftArray[i++];
            } else {
                array[k++] = rightArray[j++];
            }
        }

        // Kopiowanie pozostałych elementów z lewej tablicy (jeśli są)
        while (i < n1) {
            array[k++] = leftArray[i++];
        }

        // Kopiowanie pozostałych elementów z prawej tablicy (jeśli są)
        while (j < n2) {
            array[k++] = rightArray[j++];
        }
    }

    // Funkcja porównująca pary liczb całkowitych według zadanego kryterium
    private static int compare(int[] a, int[] b) {
        // Pierwsze porównanie po pierwszych współrzędnych
        int compareResult = Integer.compare(a[0], b[0]);

        // Jeśli pierwsze współrzędne są równe, porównaj drugie współrzędne
        if (compareResult == 0) {
            compareResult = Integer.compare(a[1], b[1]);
        }

        return compareResult;
    }

    // Funkcja do wyświetlania tablicy par liczb całkowitych
    private static void printArray(int[][] array) {
        for (int[] pair : array) {
            System.out.println(Arrays.toString(pair));
        }
    }

    // Metoda do wczytywania danych z pliku tekstowego
    private static int[][] readFromFile(String filename) {
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
            System.err.println("Błąd wczytywania z pliku: " + e.getMessage());
            return null;
        }
    }

    // Metoda do ręcznego wprowadzania danych
    private static int[][] readManually() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Podaj liczbę par liczb całkowitych: ");
        int rows = scanner.nextInt();

        int[][] array = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            System.out.print("Podaj pierwszą współrzędną dla pary " + (i + 1) + ": ");
            array[i][0] = scanner.nextInt();

            System.out.print("Podaj drugą współrzędną dla pary " + (i + 1) + ": ");
            array[i][1] = scanner.nextInt();
        }

        return array;
    }

    // Metoda do generowania losowych danych
    private static int[][] generateRandom(int rows, int maxValue) {
        Random random = new Random();
        int[][] array = new int[rows][2];

        for (int i = 0; i < rows; i++) {
            array[i][0] = random.nextInt(maxValue);
            array[i][1] = random.nextInt(maxValue);
        }

        return array;
    }

}
