import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.*;
import java.util.stream.Stream;

public class ex2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Виберіть джерело тексту:");
        System.out.println("1 - Зчитати текст з файлу");
        System.out.println("2 - Ввести текст вручну");

        int choice;


        if (scanner.hasNextInt()) {
            choice = scanner.nextInt();
        } else {
            System.out.println("Невірний вибір. Завершення програми.");
            return;
        }
        scanner.nextLine();

        String text;

        if (choice == 1) {
            System.out.println("Введіть шлях до файлу:");
            String filePath = scanner.nextLine();
            try {
                text = Files.readString(Path.of(filePath));
            } catch (IOException e) {
                System.out.println("Помилка зчитування файлу: " + e.getMessage());
                return;
            }
        } else if (choice == 2) {
            System.out.println("Введіть текст:");
            text = scanner.nextLine();
        } else {
            System.out.println("Невірний вибір. Завершення програми.");
            return;
        }

        List<String> words = Stream.of(text.split("[\\s\\p{Punct}]+"))
                .filter(word -> !word.isEmpty())
                .toList();

        System.out.println("Введіть букву для фільтрації слів:");
        String letter = scanner.nextLine().toLowerCase();

        List<String> filteredWords = words.stream()
                .filter(word -> word.toLowerCase().startsWith(letter))
                .toList();

        List<String> sortedWords = words.stream()
                .sorted(String::compareToIgnoreCase)
                .toList();

        long uniqueWordCount = words.stream()
                .map(String::toLowerCase)
                .distinct()
                .count();

        System.out.println("\nВсі слова:");
        words.forEach(System.out::println);

        System.out.println("\nСлова, що починаються з " + letter + ":");
        filteredWords.forEach(System.out::println);

        System.out.println("\nВідсортовані слова:");
        sortedWords.forEach(System.out::println);

        System.out.println("\nКількість унікальних слів: " + uniqueWordCount);
    }
}


