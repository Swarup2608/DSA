/**
 * Companion code for: ../10-conditionals.md
 *
 * Run:
 *   javac ConditionalsDemo.java
 *   java ConditionalsDemo
 */
public class ConditionalsDemo {

    public static void main(String[] args) {
        ifElseDemo();
        elseIfChainDemo(72);
        elseIfChainDemo(95); // proves order matters — 95 must hit the "A" branch, not fall through
        nestedIfDemo();
        switchFallThroughDemo();
        modernSwitchDemo();
        ternaryDemo();
    }

    static void ifElseDemo() {
        System.out.println("--- if / else ---");
        int age = 15;
        if (age >= 18) {
            System.out.println("You can vote.");
        } else {
            System.out.println("You cannot vote yet.");
        }
    }

    static void elseIfChainDemo(int score) {
        System.out.println("\n--- else if chain (score=" + score + ") ---");
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
    }

    static void nestedIfDemo() {
        System.out.println("\n--- Nested if ---");
        int age = 20;
        boolean hasID = true;
        if (age >= 18) {
            if (hasID) {
                System.out.println("Entry allowed.");
            } else {
                System.out.println("ID required.");
            }
        } else {
            System.out.println("Too young.");
        }
    }

    static void switchFallThroughDemo() {
        System.out.println("\n--- switch with intentional fall-through ---");
        int day = 2;
        switch (day) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Weekday");
                break;
            case 6:
            case 7:
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Invalid day");
        }
    }

    static void modernSwitchDemo() {
        System.out.println("\n--- Modern arrow-style switch expression ---");
        int day = 6;
        String dayType = switch (day) {
            case 1, 2, 3, 4, 5 -> "Weekday";
            case 6, 7 -> "Weekend";
            default -> "Invalid day";
        };
        System.out.println("day " + day + " is a " + dayType);
    }

    static void ternaryDemo() {
        System.out.println("\n--- Ternary Operator ---");
        int a = 10, b = 20;
        int max = (a > b) ? a : b;
        System.out.println("max of " + a + " and " + b + " = " + max);
    }
}
