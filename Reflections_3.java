import java.lang.reflect.Method;

class Calculator {
    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }
}

public class Reflections_3 {
    public static void main(String[] args) {
        Class<Calculator> calcClass = Calculator.class;

        // List all methods (including inherited ones)
        System.out.println("All methods in Calculator:");
        Method[] methods = calcClass.getMethods();
        for (Method method : methods) {
            System.out.print(method.getName() + "(");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        // Check if divide(int, int) exists
        boolean divideExists = false;
        try {
            calcClass.getDeclaredMethod("divide", int.class, int.class);
            divideExists = true;
        } catch (NoSuchMethodException e) {
            System.out.println("\nMethod 'divide(int, int)' does not exist.");
        }

        // Print parameter types of declared methods
        System.out.println("\nDeclared methods with parameter types:");
        Method[] declaredMethods = calcClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            System.out.print(method.getName() + "(");
            Class<?>[] paramTypes = method.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getSimpleName());
                if (i < paramTypes.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }
    }
}