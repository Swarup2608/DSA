/**
 * Companion code for: ../03-basic-syntax.md
 *
 * Run:
 *   javac BasicSyntaxDemo.java
 *   java BasicSyntaxDemo
 */
public class BasicSyntaxDemo {

    // Case sensitivity: these are three DIFFERENT variables.
    static int myVariable = 1;
    static int MyVariable = 2;
    static int MYVARIABLE = 3;

    public static void main(String[] args) {
        caseSensitivityDemo();
        identifierDemo();
        blockScopeDemo();
        commentStyles();
    }

    static void caseSensitivityDemo() {
        System.out.println("--- Case Sensitivity ---");
        System.out.println("myVariable = " + myVariable);
        System.out.println("MyVariable = " + MyVariable);
        System.out.println("MYVARIABLE = " + MYVARIABLE);
    }

    static void identifierDemo() {
        System.out.println("\n--- Identifiers & Naming Conventions ---");
        int totalPrice = 100;        // camelCase for variables
        final int MAX_RETRIES = 3;   // UPPER_SNAKE_CASE for constants
        System.out.println("totalPrice = " + totalPrice);
        System.out.println("MAX_RETRIES = " + MAX_RETRIES);
    }

    static void blockScopeDemo() {
        System.out.println("\n--- Blocks & Scope ---");
        {
            int x = 10;
            System.out.println("Inside block, x = " + x);
        }
        // System.out.println(x); // would NOT compile here — x is out of scope
        System.out.println("Outside the block, x no longer exists.");
    }

    /**
     * Javadoc comment: describes what a method does, used to generate docs.
     * @param a first number
     * @param b second number
     * @return the sum of a and b
     */
    static int add(int a, int b) {
        // Single-line comment: explains why, not what.
        /*
         * Multi-line comment:
         * useful for longer explanations.
         */
        return a + b;
    }

    static void commentStyles() {
        System.out.println("\n--- Comments ---");
        System.out.println("2 + 3 = " + add(2, 3));
    }
}
