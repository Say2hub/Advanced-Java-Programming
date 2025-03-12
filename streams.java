import java.util.*;
import java.util.stream.Collectors;

public class streams {

    // Task 1: Count Words Starting with Vowels
    public static int countWordsStartingWithVowels(String[] words) {
        return (int) Arrays.stream(words)
                .filter(word -> word.matches("(?i)^[aeiou].*"))
                .count();
    }

    // Task 2: Group Words by First Letter into a Map
    public static Map<Character, List<String>> groupWordsByFirstLetter(String[] words) {
        return Arrays.stream(words)
                .sorted()
                .collect(Collectors.groupingBy(
                        word -> Character.toUpperCase(word.charAt(0)),
                        Collectors.toList()
                ));
    }

    // Task 3: Simulate Customer Orders with Item Categories
    public static void main(String[] args) {
        // Sample data for Task 3
        class OrderItem {
            String name;
            double price;
            String category;

            public OrderItem(String name, double price, String category) {
                this.name = name;
                this.price = price;
                this.category = category;
            }
        }

        List<OrderItem> orders = Arrays.asList(
                new OrderItem("Laptop", 1200, "Electronics"),
                new OrderItem("Bread", 2.5, "Groceries"),
                new OrderItem("Phone", 800, "Electronics"),
                new OrderItem("Milk", 1.5, "Groceries"),
                new OrderItem("TV", 1500, "Electronics")
        );

        // Calculate total sales per category
        Map<String, Double> totalSalesPerCategory = orders.stream()
                .collect(Collectors.groupingBy(
                        item -> item.category,
                        Collectors.summingDouble(item -> item.price)
                ));

        // Display results in a user-friendly format
        System.out.println("Total Sales Per Category:");
        totalSalesPerCategory.forEach((category, total) ->
                System.out.printf("%s: $%.2f%n", category, total));

        // Demonstrate Task 1 and Task 2
        String[] words = {"apple", "banana", "orange", "umbrella", "grape", "elephant"};

        // Task 1: Count words starting with vowels
        System.out.println("\nTask 1: Count of words starting with vowels: " +
                countWordsStartingWithVowels(words));

        // Task 2: Group words by first letter
        System.out.println("\nTask 2: Grouped words by first letter:");
        Map<Character, List<String>> groupedWords = groupWordsByFirstLetter(words);
        groupedWords.forEach((letter, wordList) ->
                System.out.println(letter + ": " + wordList));
    }
}
