import java.util.*;

class Book {
    private String title, author, isbn;

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getISBN() { return isbn; }

    @Override
    public String toString() {
        return "Title: " + title + ", Author: " + author + ", ISBN: " + isbn;
    }
}

class Library {
    private ArrayList<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(String isbn) {
        books.removeIf(book -> book.getISBN().equals(isbn));
    }

    public void displayBooks() {
        books.forEach(System.out::println);
    }
}

class Stack<T> {
    private ArrayList<T> stack = new ArrayList<>();

    public void push(T item) {
        stack.add(item);
    }

    public T pop() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.remove(stack.size() - 1);
    }

    public T peek() {
        if (stack.isEmpty()) throw new EmptyStackException();
        return stack.get(stack.size() - 1);
    }
}

class TreeSetMerger {
    public static TreeSet<Integer> mergeTreeSets(TreeSet<Integer> set1, TreeSet<Integer> set2) {
        TreeSet<Integer> mergedSet = new TreeSet<>(set1);
        mergedSet.addAll(set2);
        return mergedSet;
    }
}

abstract class Shape {
    public abstract double area();
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double length, width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    public double area() {
        return length * width;
    }
}

class ShapeUtils {
    public static double totalArea(List<? extends Shape> shapes) {
        return shapes.stream().mapToDouble(Shape::area).sum();
    }
}

public class librarySystem {
    public static void main(String[] args) {
        // Task 1: Manage a Library
        Library library = new Library();
        library.addBook(new Book("Java Programming", "John Doe", "12345"));
        library.addBook(new Book("Data Science", "Jane Smith", "67890"));
        library.displayBooks();
        library.removeBook("12345");
        System.out.println("After removal:");
        library.displayBooks();

        // Task 2: Generic Stack
        Stack<String> stack = new Stack<>();
        stack.push("First");
        stack.push("Second");
        System.out.println("Top of stack: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Top of stack after pop: " + stack.peek());

        // Task 3: Merge Two TreeSets
        TreeSet<Integer> set1 = new TreeSet<>(Arrays.asList(1, 2, 3));
        TreeSet<Integer> set2 = new TreeSet<>(Arrays.asList(3, 4, 5));
        TreeSet<Integer> mergedSet = TreeSetMerger.mergeTreeSets(set1, set2);
        System.out.println("Merged TreeSet: " + mergedSet);

        // Task 4: Bounded Parameters with Shapes
        List<Shape> shapes = Arrays.asList(new Circle(2), new Rectangle(3, 4));
        System.out.println("Total area of shapes: " + ShapeUtils.totalArea(shapes));
    }
}
