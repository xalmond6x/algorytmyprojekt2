package zadanie3.QuickSort_with_insertion_sort;

public class abc {

    // Funkcja do sortowania QuickSort z wstawianiem
    private static void quickSort(String[] array, int low, int high) {
        if (low < high) {
            // Jeżeli długość podciągu jest mniejsza niż 10, użyj sortowania przez wstawianie
            if (high - low + 1 < 10) {
                insertionSort(array, low, high);
            } else {
                int partitionIndex = partition(array, low, high);

                // Rekurencyjne sortowanie przed i za indeksem partycji
                quickSort(array, low, partitionIndex - 1);
                quickSort(array, partitionIndex + 1, high);
            }
        }
    }

    // Funkcja do podziału tablicy na dwie części
    private static int partition(String[] array, int low, int high) {
        String pivot = array[high]; // Pivot

        int i = low - 1;

        for (int j = low; j < high; j++) {
            // Porównanie na podstawie leksykograficznego porządku
            if (array[j].compareToIgnoreCase(pivot) >= 0) {
                i++;

                // Zamiana miejscami elementów
                swap(array, i, j);
            }
        }

        // Zamiana miejscami pivotu i elementu na pozycji i+1
        swap(array, i + 1, high);

        return i + 1;
    }

    // Funkcja do sortowania przez wstawianie
    private static void insertionSort(String[] array, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            String key = array[i];
            int j = i - 1;

            // Przesuwanie elementów większych od klucza
            while (j >= low && array[j].compareToIgnoreCase(key) < 0) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = key;
        }
    }

    // Funkcja do zamiany miejscami dwóch elementów w tablicy
    private static void swap(String[] array, int i, int j) {
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    // Funkcja do wyświetlania tablicy łańcuchów znaków
    private static void printArray(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }

}
