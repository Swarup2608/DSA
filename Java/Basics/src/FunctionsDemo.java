/**
 * Companion code for: ../12-functions.md
 *
 * Run:
 *   javac FunctionsDemo.java
 *   java FunctionsDemo
 */
public class FunctionsDemo {

    public static void main(String[] args) {
        declarationAndDefinitionDemo();
        parametersAndReturnTypesDemo();
        voidAndEarlyReturnDemo();
        overloadingDemo();
        recursionDemo();
    }

    // --- Method Declaration & Definition ---

    static int square(int number) {
        return number * number;
    }

    static void declarationAndDefinitionDemo() {
        System.out.println("--- Method Declaration & Definition ---");
        System.out.println("square(5) = " + square(5));
    }

    // --- Parameters & Return Types ---

    static double calculateArea(double radius) {
        return Math.PI * radius * radius;
    }

    static String formatName(String first, String last, int age) {
        return first + " " + last + " (" + age + ")";
    }

    static void parametersAndReturnTypesDemo() {
        System.out.println("\n--- Parameters & Return Types ---");
        double area = calculateArea(5.0);
        System.out.println("calculateArea(5.0) = " + area);
        System.out.println(formatName("Ada", "Lovelace", 28));
    }

    // --- void methods & early return (guard clause) ---

    static void printGreeting(String name) {
        System.out.println("Hello, " + name + "!");
    }

    static int safeDivide(int a, int b) {
        if (b == 0) {
            return 0; // guard clause — avoid dividing by zero, exit immediately
        }
        return a / b;
    }

    static void voidAndEarlyReturnDemo() {
        System.out.println("\n--- void Methods & Early Return ---");
        printGreeting("World");
        System.out.println("safeDivide(10, 2) = " + safeDivide(10, 2));
        System.out.println("safeDivide(10, 0) = " + safeDivide(10, 0) + " (guarded, no crash)");
    }

    // --- Method Overloading ---

    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    static void overloadingDemo() {
        System.out.println("\n--- Method Overloading ---");
        System.out.println("add(2, 3)        -> " + add(2, 3));           // int,int
        System.out.println("add(2.5, 3.5)    -> " + add(2.5, 3.5));       // double,double
        System.out.println("add(1, 2, 3)     -> " + add(1, 2, 3));        // int,int,int
    }

    // --- Recursion: base case & recursive case ---

    static int factorial(int n) {
        if (n == 0) {              // base case
            return 1;
        }
        return n * factorial(n - 1); // recursive case
    }

    static int sum(int n) {
        if (n == 0) {              // base case
            return 0;
        }
        return n + sum(n - 1);      // recursive case
    }

    static void recursionDemo() {
        System.out.println("\n--- Recursion: Base Case & Recursive Case ---");
        System.out.println("factorial(4) = " + factorial(4));
        System.out.println("sum(5) = " + sum(5) + "  (1+2+3+4+5)");

        // Uncomment to see a real StackOverflowError from a missing base case:
        // brokenRecursion(5);
    }

    // Deliberately broken — no base case, demonstrates StackOverflowError if called.
    static int brokenRecursion(int n) {
        return n * brokenRecursion(n - 1); // never stops!
    }
}
