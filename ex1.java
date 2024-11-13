import java.util.Scanner;

@FunctionalInterface
interface WordSearch {
    boolean search(String text, String word);
}

@FunctionalInterface
interface WordReplace {
    String replace(String text, String target, String replacement);
}

@FunctionalInterface
interface WordCount {
    int count(String text);
}

// Головний клас
public class ex1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введіть текст:");
        String text = scanner.nextLine();

        WordSearch wordSearch = (t, w) -> t.contains(w);

        WordReplace wordReplace = (t, target, replacement) -> t.replaceAll(target, replacement);

        WordCount wordCount = t -> t.split("\s+").length;

        while (true) {
            System.out.println("\nВиберіть операцію:");
            System.out.println("1 - Пошук слова");
            System.out.println("2 - Замінити слово");
            System.out.println("3 - Підрахунок кількості слів");
            System.out.println("0 - Вихід");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Введіть слово для пошуку:");
                    String searchWord = scanner.nextLine();
                    boolean found = wordSearch.search(text, searchWord);
                    System.out.println("Результат пошуку: " + (found ? "Знайдено" : "Не знайдено"));
                    break;

                case 2:
                    System.out.println("Введіть слово для заміни:");
                    String targetWord = scanner.nextLine();
                    System.out.println("Введіть нове слово:");
                    String replacementWord = scanner.nextLine();
                    text = wordReplace.replace(text, targetWord, replacementWord);
                    System.out.println("Оновлений текст: " + text);
                    break;

                case 3:
                    int count = wordCount.count(text);
                    System.out.println("Кількість слів у тексті: " + count);
                    break;

                case 0:
                    System.out.println("Вихід з програми.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Невірний вибір. Спробуйте ще раз.");
                    break;
            }
        }
    }
}