import java.util.*;

interface Observer {
    void update(float stockPrice);
}

class PriceAlert implements Observer {
    private String alertName;
    private float threshold;

    public PriceAlert(String alertName, float threshold) {
        this.alertName = alertName;
        this.threshold = threshold;
    }

    @Override
    public void update(float stockPrice) {
        if (stockPrice >= threshold) {
            System.out.println(alertName + ": Stock price has reached the threshold! Current price: " + stockPrice);
        } else {
            System.out.println(alertName + ": Stock price is below the threshold. Current price: " + stockPrice);
        }
    }

    public String getAlertName() {
        return alertName;
    }
}

class StockBoard {
    private List<Observer> observers = new ArrayList<>();

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers(float stockPrice) {
        for (Observer o : observers) {
            o.update(stockPrice);
        }
    }

    public List<Observer> getObservers() {
        return observers;
    }
}

public class ThirdProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StockBoard board = new StockBoard();

        String continueChoice;

        do {
            System.out.println("1. Register new Price Alert");
            System.out.println("2. Remove Price Alert");
            System.out.println("3. Enter Stock Price");
            System.out.println("4. Exit");

            int choice = sc.nextInt();
            sc.nextLine();  // consume the newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter alert name: ");
                    String alertName = sc.nextLine();
                    System.out.println("Enter threshold price: ");
                    float threshold = sc.nextFloat();
                    sc.nextLine();  // consume the newline character
                    PriceAlert newAlert = new PriceAlert(alertName, threshold);
                    board.registerObserver(newAlert);
                    System.out.println("Price Alert registered.");
                    break;

                case 2:
                    System.out.println("Enter alert name to remove: ");
                    String removeName = sc.nextLine();
                    PriceAlert toRemove = null;
                    for (Observer o : board.getObservers()) {
                        if (o instanceof PriceAlert && ((PriceAlert) o).getAlertName().equals(removeName)) {
                            toRemove = (PriceAlert) o;
                            break;
                        }
                    }
                    if (toRemove != null) {
                        board.removeObserver(toRemove);
                        System.out.println("Price Alert removed.");
                    } else {
                        System.out.println("No Price Alert found with that name.");
                    }
                    break;

                case 3:
                    System.out.println("Enter the stock price: ");
                    float stockPrice = sc.nextFloat();
                    board.notifyObservers(stockPrice);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    continueChoice = "no";
                    continue;
                    
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println("Do you want to continue? (yes/no): ");
            continueChoice = sc.nextLine();

        } while (continueChoice.equalsIgnoreCase("yes"));

        System.out.println("Thank you for using the stock price tracker!");
        sc.close();
    }
}
