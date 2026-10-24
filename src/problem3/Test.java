package problem3;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter library capacity: ");
        int n = sc.nextInt();
        sc.nextLine();


        Library library = new Library(n);

        library.add(new Novel("The Alchemist", "Paulo Coelho", 200, 90));
        library.add(new Magazine("Science Today", "October", 2026));

        int choice;

        do {
            System.out.println("\n--- LIBRARY MENU ---");
            System.out.println("1. Add document");
            System.out.println("2. Display documents");
            System.out.println("3. Delete document");
            System.out.println("4. Search document");
            System.out.println("5. Display authors");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("1. Book");
                    System.out.println("2. Novel");
                    System.out.println("3. Textbook");
                    System.out.println("4. Magazine");
                    System.out.println("5. Dictionary");
                    System.out.print("Type: ");
                    int type = sc.nextInt();
                    sc.nextLine();

                    if (type < 1 || type > 5) {
                        System.out.println("Invalid type");
                        break;
                    }

                    System.out.print("Title: ");
                    String title = sc.nextLine();

                    Document doc = null;

                    if (type >= 1 && type <= 3) {
                        System.out.print("Author: ");
                        String author = sc.nextLine();
                        System.out.print("Pages: ");
                        int pages = sc.nextInt();
                        sc.nextLine();

                        if (type == 1) {
                            doc = new Book(title, author, pages);
                        } else if (type == 2) {
                            System.out.print("Price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();
                            doc = new Novel(title, author, pages, price);
                        } else {
                            System.out.print("Level: ");
                            String level = sc.nextLine();
                            doc = new Textbook(title, author, pages, level);
                        }
                    } else if (type == 4) {
                        System.out.print("Month: ");
                        String month = sc.nextLine();
                        System.out.print("Year: ");
                        int year = sc.nextInt();
                        sc.nextLine();
                        doc = new Magazine(title, month, year);
                    } else {
                        System.out.print("Language: ");
                        String language = sc.nextLine();
                        doc = new Dictionary(title, language);
                    }

                    if (library.add(doc)) {
                        System.out.println("Document added");
                    } else {
                        System.out.println("Library is full");
                    }
                    break;

                case 2:
                    library.displayDocuments();
                    break;

                case 3:
                    System.out.print("Document number: ");
                    int deleteNum = sc.nextInt();
                    Document toDelete = library.document(deleteNum);

                    if (toDelete != null && library.delete(toDelete)) {
                        System.out.println("Document deleted");
                    } else {
                        System.out.println("Document not found");
                    }
                    break;

                case 4:
                    System.out.print("Document number: ");
                    int searchNum = sc.nextInt();
                    Document found = library.document(searchNum);

                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Document not found");
                    }
                    break;

                case 5:
                    library.displayAuthors();
                    break;

                case 0:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice");
            }

        } while (choice != 0);

        sc.close();
    }
}