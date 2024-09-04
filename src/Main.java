import java.util.List;
import java.util.Scanner;

public class Main {

    private static final UserService userService = new UserService();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            printMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createUser();
                    break;
                case 2:
                    getUser();
                    break;
                case 3:
                    updateUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    getAllUsers();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void printMenu() {
        System.out.println("\n--- User Management System ---");
        System.out.println("1. Create User");
        System.out.println("2. Get User by ID");
        System.out.println("3. Update User");
        System.out.println("4. Delete User");
        System.out.println("5. Get All Users");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createUser() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        userService.addUser(name, email);
        System.out.println("User created successfully.");
    }

    private static void getUser() {
        System.out.print("Enter user ID: ");
        int id = Integer.parseInt(scanner.nextLine());

        User user = userService.getUser(id);
        if (user != null) {
            System.out.println("User ID: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User Email: " + user.getEmail());
        } else {
            System.out.println("User not found.");
        }
    }

    private static void updateUser() {
        System.out.print("Enter user ID to update: ");
        int id = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new email: ");
        String email = scanner.nextLine();

        userService.updateUser(id, name, email);
        System.out.println("User updated successfully.");
    }

    private static void deleteUser() {
        System.out.print("Enter user ID to delete: ");
        int id = Integer.parseInt(scanner.nextLine());

        userService.deleteUser(id);
        System.out.println("User deleted successfully.");
    }

    private static void getAllUsers() {
        List<User> users = userService.getAllUsers();
        if (!users.isEmpty()) {
            System.out.println("--- List of Users ---");
            for (User user : users) {
                System.out.println("ID: " + user.getId() + ", Name: " + user.getName() + ", Email: " + user.getEmail());
            }
        } else {
            System.out.println("No users found.");
        }
    }


}
