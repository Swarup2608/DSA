/**
 * Companion code for: ../04-variables.md
 *
 * Run:
 *   javac VariablesDemo.java
 *   java VariablesDemo
 */
public class VariablesDemo {

    // Instance variable — one copy per object, defaults to 0 if not set
    int id;

    // Static variable — ONE copy shared by every object of this class
    static int totalCounters = 0;

    VariablesDemo() {
        totalCounters++;
        id = totalCounters;
    }

    public static void main(String[] args) {
        declarationDemo();
        defaultValueDemo();
        scopeDemo();
        instanceVsStaticDemo();
        shadowingDemo();
    }

    static void declarationDemo() {
        System.out.println("--- Declaration & Initialization ---");
        int age;      // declared, not yet initialized
        age = 25;     // now initialized
        int score = 100; // declared + initialized together
        System.out.println("age = " + age + ", score = " + score);
    }

    static void defaultValueDemo() {
        System.out.println("\n--- Default Values (fields only) ---");
        VariablesDemo v = new VariablesDemo();
        System.out.println("A freshly created object's id (auto-assigned) = " + v.id);
    }

    static void scopeDemo() {
        System.out.println("\n--- Scope ---");
        int localVar = 2;
        if (true) {
            int blockVar = 3;
            System.out.println("Inside if-block: localVar=" + localVar + ", blockVar=" + blockVar);
        }
        // blockVar is NOT visible here — it's out of scope.
        System.out.println("Outside if-block: localVar=" + localVar + " (blockVar no longer exists)");
    }

    static void instanceVsStaticDemo() {
        System.out.println("\n--- Instance vs Static ---");
        VariablesDemo a = new VariablesDemo();
        VariablesDemo b = new VariablesDemo();
        VariablesDemo c = new VariablesDemo();
        System.out.println("a.id=" + a.id + " b.id=" + b.id + " c.id=" + c.id);
        System.out.println("totalCounters (shared, static) = " + totalCounters);
    }

    int value = 10;

    void set(int value) {
        // 'value' parameter shadows the field 'value'
        this.value = value; // explicit reference to the field
    }

    static void shadowingDemo() {
        System.out.println("\n--- Shadowing ---");
        VariablesDemo obj = new VariablesDemo();
        System.out.println("Before set(): value = " + obj.value);
        obj.set(99);
        System.out.println("After set(99): value = " + obj.value);
    }
}
