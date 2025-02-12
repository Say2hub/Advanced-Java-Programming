import java.util.*;

interface IReader {
    void readPost();
}

interface IWriter extends IReader {
    void editPost();
}

interface IAdmin extends IWriter {
    void blockPost();
}

class Reader implements IReader {
    @Override
    public void readPost() {
        System.out.println("Reading a blog post.");
    }
}

class Writer implements IWriter {
    @Override
    public void readPost() {
        System.out.println("Reading a blog post.");
    }

    @Override
    public void editPost() {
        System.out.println("Editing a blog post.");
    }
}

class Admin implements IAdmin {
    @Override
    public void readPost() {
        System.out.println("Reading a blog post.");
    }

    @Override
    public void editPost() {
        System.out.println("Editing a blog post.");
    }

    @Override
    public void blockPost() {
        System.out.println("Blocking a post.");
    }
}

public class BlogApp {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            System.out.println("\nLogin as:");
            System.out.println("1. Reader");
            System.out.println("2. Writer");
            System.out.println("3. Admin");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    readerActions();
                    break;
                case 2:
                    writerActions();
                    break;
                case 3:
                    adminActions();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using BlogApp!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void readerActions() {
        Reader reader = new Reader();
        boolean exit = false;
        while (!exit) {
            System.out.println("\nReader Menu:");
            System.out.println("1. Read Post");
            System.out.println("2. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    reader.readPost();
                    break;
                case 2:
                    exit = true;
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void writerActions() {
        Writer writer = new Writer();
        boolean exit = false;
        while (!exit) {
            System.out.println("\nWriter Menu:");
            System.out.println("1. Read Post");
            System.out.println("2. Edit Post");
            System.out.println("3. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    writer.readPost();
                    break;
                case 2:
                    writer.editPost();
                    break;
                case 3:
                    exit = true;
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void adminActions() {
        Admin admin = new Admin();
        boolean exit = false;
        while (!exit) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. Read Post");
            System.out.println("2. Edit Post");
            System.out.println("3. Block Post");
            System.out.println("4. Logout");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    admin.readPost();
                    break;
                case 2:
                    admin.editPost();
                    break;
                case 3:
                    admin.blockPost();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Logging out.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
