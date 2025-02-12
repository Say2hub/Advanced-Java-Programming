import java.util.*;

class Order {
    private String id;
    private double totalPrice;
    private List<String> items;

    public Order(String id, double totalPrice, List<String> items) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.items = items;
    }

    public String getId() {
        return id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public List<String> getItems() {
        return items;
    }
}

class OrderDatabase {
    private List<Order> orders = new ArrayList<>();

    public void saveOrder(Order order) {
        orders.add(order);
        System.out.println("Order saved: " + order.getId());
    }

    public Order loadOrder(String id) {
        for (Order order : orders) {
            if (order.getId().equals(id)) {
                return order;
            }
        }
        return null;
    }
}

class OrderPresenter {
    public String mapToResponse(Order order) {
        return "Order ID: " + order.getId() + ", Total Price: " + order.getTotalPrice() + ", Items: " + order.getItems();
    }
}

class EmailService {
    public void sendOrderEmail(Order order) {
        String emailContent = "Order ID: " + order.getId() + ", Total Price: " + order.getTotalPrice() + ", Items: " + order.getItems();
        System.out.println("Sending email: \n" + emailContent);
    }
}

class OrderView {
    public void updateView(Order order) {
        System.out.println("Updated Order View: " + "Order ID: " + order.getId() + ", Total Price: " + order.getTotalPrice() + ", Items: " + order.getItems());
    }
}

class OrderController {
    private OrderDatabase orderDatabase;
    private OrderPresenter orderPresenter;
    private EmailService emailService;
    private OrderView orderView;

    public OrderController(OrderDatabase orderDatabase, OrderPresenter orderPresenter, EmailService emailService, OrderView orderView) {
        this.orderDatabase = orderDatabase;
        this.orderPresenter = orderPresenter;
        this.emailService = emailService;
        this.orderView = orderView;
    }

    public void createOrder(Order order) {
        orderDatabase.saveOrder(order);
        emailService.sendOrderEmail(order);
        orderView.updateView(order);
    }

    public void viewOrder(String id) {
        Order order = orderDatabase.loadOrder(id);
        if (order != null) {
            System.out.println(orderPresenter.mapToResponse(order));
        } else {
            System.out.println("Order not found");
        }
    }
}

public class FoodDeliveryApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Double> menu = new HashMap<>();

    static {
        menu.put("Pizza", 10.99);
        menu.put("Burger", 5.99);
        menu.put("Soda", 1.99);
        menu.put("Salad", 4.49);
        menu.put("Fries", 2.99);
    }

    public static void main(String[] args) {
        OrderDatabase orderDatabase = new OrderDatabase();
        OrderPresenter orderPresenter = new OrderPresenter();
        EmailService emailService = new EmailService();
        OrderView orderView = new OrderView();
        OrderController orderController = new OrderController(orderDatabase, orderPresenter, emailService, orderView);

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Create Order");
            System.out.println("2. View Order");
            System.out.println("3. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createOrder(orderController);
                    break;
                case 2:
                    viewOrder(orderController);
                    break;
                case 3:
                    exit = true;
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createOrder(OrderController orderController) {
        System.out.print("Enter order ID: ");
        String id = scanner.nextLine();

        List<String> items = new ArrayList<>();
        double totalPrice = 0.0;

        boolean addItem = true;
        while (addItem) {
            System.out.println("Menu:");
            for (String item : menu.keySet()) {
                System.out.println(item + ": $" + menu.get(item));
            }

            System.out.print("Enter item name to add to order: ");
            String itemName = scanner.nextLine();

            if (menu.containsKey(itemName)) {
                items.add(itemName);
                totalPrice += menu.get(itemName);
            } else {
                System.out.println("Item not found on menu. Please try again.");
            }

            System.out.print("Would you like to add another item? (yes/no): ");
            String response = scanner.nextLine();
            addItem = response.equalsIgnoreCase("yes");
        }

        Order order = new Order(id, totalPrice, items);
        orderController.createOrder(order);
    }

    private static void viewOrder(OrderController orderController) {
        System.out.print("Enter order ID to view: ");
        String id = scanner.nextLine();
        orderController.viewOrder(id);
    }
}
