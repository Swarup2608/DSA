/**
 * Companion code for: ../11-loops.md
 *
 * Run:
 *   javac LoopsDemo.java
 *   java LoopsDemo
 */
public class LoopsDemo {

    public static void main(String[] args) {
        forLoopDemo();
        whileLoopDemo();
        doWhileLoopDemo();
        nestedLoopDemo();
        breakDemo();
        continueDemo();
        labeledContinueDemo();
        patternPrintingDemo();
    }

    static void forLoopDemo() {
        System.out.println("--- for loop ---");
        for (int i = 0; i < 5; i++) {
            System.out.println("Iteration: " + i);
        }
    }

    static void whileLoopDemo() {
        System.out.println("\n--- while loop ---");
        int count = 0;
        while (count < 5) {
            System.out.println("Count: " + count);
            count++;
        }
    }

    static void doWhileLoopDemo() {
        System.out.println("\n--- do-while loop (runs at least once) ---");
        int count = 0;
        do {
            System.out.println("Count: " + count);
            count++;
        } while (count < 5);
    }

    static void nestedLoopDemo() {
        System.out.println("\n--- Nested loops ---");
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 3; j++) {
                System.out.print(i + "" + j + " ");
            }
        }
        System.out.println();
    }

    static void breakDemo() {
        System.out.println("\n--- break ---");
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                break; // exits the loop entirely
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void continueDemo() {
        System.out.println("\n--- continue ---");
        for (int i = 0; i < 5; i++) {
            if (i == 2) {
                continue; // skips printing 2, loop keeps going
            }
            System.out.print(i + " ");
        }
        System.out.println();
    }

    static void labeledContinueDemo() {
        System.out.println("\n--- labeled continue (escaping nested loops) ---");
        outer:
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (j == 1) {
                    continue outer; // skips to the NEXT iteration of the OUTER loop
                }
                System.out.println(i + "," + j);
            }
        }
    }

    static void patternPrintingDemo() {
        System.out.println("\n--- Pattern printing: right triangle ---");
        for (int i = 1; i <= 4; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
