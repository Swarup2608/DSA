/**
 * Companion code for: ../08-operators.md
 *
 * Run:
 *   javac OperatorsDemo.java
 *   java OperatorsDemo
 */
public class OperatorsDemo {

    public static void main(String[] args) {
        arithmeticDemo();
        relationalDemo();
        logicalShortCircuitDemo();
        assignmentDemo();
        incrementDecrementDemo();
        precedenceDemo();
    }

    static void arithmeticDemo() {
        System.out.println("--- Arithmetic Operators ---");
        int a = 5, b = 2;
        System.out.println("a / b (int division)      = " + (a / b));          // 2
        System.out.println("(double) a / b            = " + ((double) a / b)); // 2.5
        System.out.println("a % b (remainder)         = " + (a % b));          // 1
    }

    static void relationalDemo() {
        System.out.println("\n--- Relational Operators ---");
        int x = 10, y = 20;
        System.out.println("x < y  -> " + (x < y));
        System.out.println("x == y -> " + (x == y));
    }

    static void logicalShortCircuitDemo() {
        System.out.println("\n--- Logical Operators & Short-Circuiting ---");
        int age = 25;
        boolean hasLicense = true;
        System.out.println("age >= 18 && hasLicense -> " + (age >= 18 && hasLicense));
        System.out.println("age < 18 || hasLicense  -> " + (age < 18 || hasLicense));
        System.out.println("!hasLicense              -> " + (!hasLicense));

        String name = null;
        // Safe because && short-circuits: name.length() is never called when name is null.
        if (name != null && name.length() > 0) {
            System.out.println("Has a name");
        } else {
            System.out.println("Safely handled a null name thanks to short-circuit &&");
        }
    }

    static void assignmentDemo() {
        System.out.println("\n--- Assignment Operators ---");
        int score = 10;
        score += 5; // score = score + 5
        System.out.println("after += 5: " + score);
        score *= 2; // score = score * 2
        System.out.println("after *= 2: " + score);
    }

    static void incrementDecrementDemo() {
        System.out.println("\n--- Increment / Decrement ---");
        int a = 5;
        int b = ++a; // a becomes 6 FIRST, then b = 6
        System.out.println("++a -> a=" + a + " b=" + b);

        int c = 5;
        int d = c++; // d = 5 (old value), THEN c becomes 6
        System.out.println("c++ -> c=" + c + " d=" + d);
    }

    static void precedenceDemo() {
        System.out.println("\n--- Operator Precedence ---");
        int result = 2 + 3 * 4;       // 14, multiplication first
        int clearer = 2 + (3 * 4);    // still 14, but unambiguous at a glance
        System.out.println("2 + 3 * 4 = " + result + " (== " + clearer + ")");
    }
}
