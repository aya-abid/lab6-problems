package problem5;

import java.util.LinkedList;

public class BookQueue {
    private LinkedList<Book> books = new LinkedList<>();

    public void enqueue(Book book) {
        books.addLast(book);
    }

    public Book dequeue() {
        return books.removeFirst();
    }

    public Book peek() {
        return books.getFirst();
    }

    public void display() {
        System.out.println("Queue contents (front to back):");
        for (Book book : books) {
            System.out.println("- " + book);
        }
    }
}