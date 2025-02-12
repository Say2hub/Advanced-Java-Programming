import java.util.*;
class Campaign {
    private String name;

    public Campaign(String name) {
        this.name = name;
    }

    public void start() {
        System.out.println("Campaign " + name + " has started.");
    }

    public String getName() {
        return name;
    }
}

class CampaignStats {
    public void calculate(Campaign campaign) {
        System.out.println("All students of DJSCE have joined in the campaign : " + campaign.getName() + ".");
    }
}

class CampaignRepository {
    public void save(Campaign campaign) {
        System.out.println("Saving campaign " + campaign.getName() + " to the database.");
    }
}


public class fifthProgram{
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Ad Agency App");

        System.out.print("Enter campaign name: ");
        String campaignName = scanner.nextLine();

        Campaign campaign = new Campaign(campaignName);
        CampaignStats stats = new CampaignStats();
        CampaignRepository repository = new CampaignRepository();

        boolean exit = false;
        while (!exit) {
            System.out.println("\nWhat would you like to do?");
            System.out.println("1. Start Campaign");
            System.out.println("2. Calculate Campaign Stats");
            System.out.println("3. Save Campaign");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    campaign.start();
                    break;
                case 2:
                    stats.calculate(campaign);
                    break;
                case 3:
                    repository.save(campaign);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Exiting application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
    

