package zadanie2;

import java.util.Arrays;

public class QuickSortExample {

    public static void main(String[] args) {
        // Przykładowa tablica par napisów (imię, nazwisko)
        String[][] array = {
                {"Adam", "Josef"},
                {"Harry", "Potter"},
                {"Draco", "Malfoy"},
                {"Salazar", "Slytherin"},
                {"Godrick", "Griffindor"},
                {"Chris", "Hoyne"}
        };

        System.out.println("Tablica przed sortowaniem: ");
        printArray(array);

        // Wywołanie funkcji sortującej
        quickSort(array, 0, array.length - 1);

        System.out.println("\nTablica po sortowaniu: ");
        printArray(array);
    }

    // Funkcja do sortowania QuickSort
    private static void quickSort(String[][] array, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(array, low, high);

            // Rekurencyjne sortowanie przed i za indeksem partycji
            quickSort(array, low, partitionIndex - 1);
            quickSort(array, partitionIndex + 1, high);
        }
    }

    // Funkcja do podziału tablicy na dwie części
    private static int partition(String[][] array, int low, int high) {
        String pivot = array[high][1]; // Pivot jako nazwisko

        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Porównanie na podstawie nazwiska, a w przypadku równości imienia
            if (compare(array[j][1], pivot) >= 0) {
                i++;

                // Zamiana miejscami elementów
                swap(array, i, j);
            }
        }

        // Zamiana miejscami pivotu i elementu na pozycji i+1
        swap(array, i + 1, high);

        return i + 1;
    }

    // Funkcja do porównywania napisów na podstawie pola nazwisko, a w przypadku równości imienia
    private static int compare(String a, String b) {
        int result = a.compareTo(b);

        if (result == 0) {
            // Porównanie na podstawie imienia w przypadku równości nazwiska
            result = a.compareTo(b);
        }

        return result;
    }

    // Funkcja do zamiany miejscami dwóch elementów w tablicy
    private static void swap(String[][] array, int i, int j) {
        String[] temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Funkcja do wyświetlania tablicy par napisów
    private static void printArray(String[][] array) {
        for (String[] pair : array) {
            System.out.println(Arrays.toString(pair));
        }
    }
}

