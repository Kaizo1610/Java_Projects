import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {

    static class Book {
        String title;
        boolean isBorrowed;

        Book(String title) {
            this.title = title;
            this.isBorrowed = false;
        }

        void borrowBook() {
            if (!isBorrowed) {
                isBorrowed = true;
                System.out.println("You have borrowed the book: " + title);
            } else {
                System.out.println("Sorry, this book is already borrowed.");
            }
        }

        void returnBook() {
            if (isBorrowed) {
                isBorrowed = false;
                System.out.println("You have returned the book: " + title);
            } else {
                System.out.println("This book was not borrowed.");
            }
        }
    }

    public static void main(String[] args) {
        ArrayList<Book> library = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter the book title: ");
                    String title = scanner.nextLine();
                    library.add(new Book(title));
                    System.out.println("Book added successfully!");
                    break;

                case 2:
                    System.out.println("\nAvailable Books:");
                    if (library.isEmpty()) {
                        System.out.println("No books in the library.");
                    } else {
                        for (int i = 0; i < library.size(); i++) {
                            Book book = library.get(i);
                            System.out.println((i + 1) + ". " + book.title + (book.isBorrowed ? " (Borrowed)" : ""));
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nEnter the number of the book to borrow: ");
                    for (int i = 0; i < library.size(); i++) {
                        Book book = library.get(i);
                        System.out.println((i + 1) + ". " + book.title + (book.isBorrowed ? " (Borrowed)" : ""));
                    }
                    int borrowIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (borrowIndex >= 0 && borrowIndex < library.size()) {
                        library.get(borrowIndex).borrowBook();
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 4:
                    System.out.println("\nEnter the number of the book to return: ");
                    for (int i = 0; i < library.size(); i++) {
                        Book book = library.get(i);
                        System.out.println((i + 1) + ". " + book.title + (book.isBorrowed ? " (Borrowed)" : ""));
                    }
                    int returnIndex = scanner.nextInt() - 1;
                    scanner.nextLine(); // Consume newline
                    if (returnIndex >= 0 && returnIndex < library.size()) {
                        library.get(returnIndex).returnBook();
                    } else {
                        System.out.println("Invalid book number.");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using the Library Management System. Goodbye!");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}