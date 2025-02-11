import java.util.*;

interface Furniture {
    void createObjects();
}

class Table implements Furniture {
    private String size;
    private String material;
    private String color;

    public Table(String size, String material, String color) {
        this.size = size;
        this.material = material;
        this.color = color;
    }

    @Override
    public void createObjects() {
        System.out.println("Creating Table...");
        System.out.println("Size: " + size + ", Material: " + material + ", Color: " + color);
    }
}

class Chair implements Furniture {
    private String size;
    private String material;
    private String color;

    public Chair(String size, String material, String color) {
        this.size = size;
        this.material = material;
        this.color = color;
    }

    @Override
    public void createObjects() {
        System.out.println("Creating Chair...");
        System.out.println("Size: " + size + ", Material: " + material + ", Color: " + color);
    }
}

class Sofa implements Furniture {
    private String size;
    private String material;
    private String color;

    public Sofa(String size, String material, String color) {
        this.size = size;
        this.material = material;
        this.color = color;
    }

    @Override
    public void createObjects() {
        System.out.println("Creating Sofa...");
        System.out.println("Size: " + size + ", Material: " + material + ", Color: " + color);
    }
}

class FurnitureFactory {
    public Furniture getFurniture(String type, String size, String material, String color) {
        if (type.equalsIgnoreCase("table")) {
            return new Table(size, material, color);
        } else if (type.equalsIgnoreCase("chair")) {
            return new Chair(size, material, color);
        } else if (type.equalsIgnoreCase("sofa")) {
            return new Sofa(size, material, color);
        } else {
            return null;
        }
    }
}

public class SecondProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FurnitureFactory factory = new FurnitureFactory();
        String continueChoice;

        do {
            System.out.println("Enter the type of furniture (table, chair, sofa): ");
            String type = sc.nextLine();
            System.out.println("Enter the size: ");
            String size = sc.nextLine();
            System.out.println("Enter the material: ");
            String material = sc.nextLine();
            System.out.println("Enter the color: ");
            String color = sc.nextLine();

            Furniture furniture = factory.getFurniture(type, size, material, color);
            if (furniture != null) {
                furniture.createObjects();
            } else {
                System.out.println("Invalid furniture type!");
            }

            System.out.println("Do you want to create more furniture? (yes/no): ");
            continueChoice = sc.nextLine();
        } while (continueChoice.equalsIgnoreCase("yes"));

        System.out.println("Thank you for using the furniture factory!");
        sc.close();
    }
}
