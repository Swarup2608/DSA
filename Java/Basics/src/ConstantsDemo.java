/**
 * Companion code for: ../05-constants.md
 *
 * Run:
 *   javac ConstantsDemo.java
 *   java ConstantsDemo
 */
public class ConstantsDemo {

    // static final = the idiomatic Java "true constant": one value, shared, unchangeable
    static final double TAX_RATE = 0.18;
    static final int MAX_RETRIES = 3;

    public static void main(String[] args) {
        basicFinalDemo();
        staticFinalDemo();
        finalObjectMutationDemo();
    }

    static void basicFinalDemo() {
        System.out.println("--- Basic final ---");
        final int maxUsers = 100;
        System.out.println("maxUsers = " + maxUsers);
        // maxUsers = 200; // would NOT compile: "cannot assign a value to final variable maxUsers"
    }

    static void staticFinalDemo() {
        System.out.println("\n--- static final (class-wide constant) ---");
        double price = 200.0;
        double tax = price * TAX_RATE;
        System.out.println("Price: " + price + ", Tax (" + TAX_RATE + "): " + tax);
        System.out.println("MAX_RETRIES = " + MAX_RETRIES);
    }

    static void finalObjectMutationDemo() {
        System.out.println("\n--- final locks the reference, NOT the object's contents ---");
        final int[] scores = {1, 2, 3};
        System.out.print("Before mutation: ");
        printArray(scores);

        scores[0] = 99; // allowed — mutating the array's contents
        System.out.print("After scores[0] = 99: ");
        printArray(scores);

        // scores = new int[]{4, 5, 6}; // would NOT compile — reassigning a final reference
    }

    static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
