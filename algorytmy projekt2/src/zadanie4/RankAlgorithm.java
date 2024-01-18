package zadanie4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RankAlgorithm {

    public static void main(String[] args) {
        // Wczytaj dane z pliku i zaimplementuj algorytm
        Student[] students = readStudentsFromFile("dane_studentow.txt");

        // Sortuj studentów malejąco według sumy punktów
        Arrays.sort(students, Comparator.comparingInt(Student::getTotalPoints).reversed());

        // Wprowadź numer indeksu studenta, dla którego chcesz uzyskać miejsce w rankingu
        int targetIndex = 123456;

        // Znajdź miejsce studenta o podanym numerze indeksu
        int place = findStudentPlace(students, targetIndex);

        // Wyświetl wynik
        System.out.println("Student o numerze indeksu " + targetIndex + " zajmuje miejsce " + place + " w rankingu.");
    }

    // Klasa reprezentująca studenta
    static class Student {
        int indexNumber;
        int[] points; // Punkty z zajęć

        public Student(int indexNumber, int[] points) {
            this.indexNumber = indexNumber;
            this.points = points;
        }

        public int getTotalPoints() {
            return Arrays.stream(points).sum();
        }

        public int getIndexNumber() {
            return indexNumber;
        }
    }

    // Funkcja do wczytywania danych z pliku tekstowego
    private static Student[] readStudentsFromFile(String filename) {
        try {
            Scanner scanner = new Scanner(new File(filename));

            int numberOfStudents = scanner.nextInt();
            Student[] students = new Student[numberOfStudents];

            for (int i = 0; i < numberOfStudents; i++) {
                int indexNumber = scanner.nextInt();
                int[] points = new int[15];

                for (int j = 0; j < 15; j++) {
                    points[j] = scanner.nextInt();
                }

                students[i] = new Student(indexNumber, points);
            }

            return students;
        } catch (FileNotFoundException e) {
            System.err.println("Błąd wczytywania z pliku: " + e.getMessage());
            return null;
        }
    }

    // Funkcja do znajdowania miejsca studenta o podanym numerze indeksu w rankingu
    private static int findStudentPlace(Student[] students, int targetIndex) {
        for (int i = 0; i < students.length; i++) {
            if (students[i].getIndexNumber() == targetIndex) {
                return i + 1; // Zwróć miejsce, indeksy zaczynają się od 1
            }
        }

        return -1; // Zwróć -1, jeśli student o podanym numerze indeksu nie został znaleziony
    }
}
