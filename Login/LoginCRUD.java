import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class User {
    private String username;
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String newPassword) {
    }
}

class UserDatabase {
    private List<User> users;

    public UserDatabase() {
        users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public void updateUser(User user) {
        // Implement your logic to update a user in the database
    }

    public void deleteUser(User user) {
        users.remove(user);
    }
}

public class LoginCRUD {
    private static UserDatabase userDatabase = new UserDatabase();
    private static Scanner scanner = new Scanner(System.in);

    private static void createUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();
        User user = new User(username, password);
        userDatabase.addUser(user);
        System.out.println("User created successfully.");
    }

    private static void readUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = userDatabase.getUserByUsername(username);
        if (user != null) {
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
        } else {
            System.out.println("User not found.");
        }
    }

    private static void updateUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        User user = userDatabase.getUserByUsername(username);
        if (user != null) {
            System.out.print("Enter new password: ");
            String newPassword = scanner.nextLine();
            user.setPassword(newPassword);
            userDatabase.updateUser(user);
            System.out.println("User updated successfully.");
        } else {
            System.out.println("User not found.");
        }
    }
}