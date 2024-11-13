import java.util.List;
import java.util.Optional;

class User {
    private int id;
    private String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{id=" + id + ", name='" + name + "'}";
    }
}

public class ex3 {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User(1, "Alice"),
                new User(2, "Bob"),
                new User(3, "Charlie")
        );

        int userIdToFind = 2;
        Optional<User> user = findUserById(users, userIdToFind);

        // Виведення результату
        user.ifPresentOrElse(
                u -> System.out.println("Знайдено користувача: " + u),
                () -> System.out.println("Користувача з таким ID не знайдено.")
        );
    }

    public static Optional<User> findUserById(List<User> users, int id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }
}

