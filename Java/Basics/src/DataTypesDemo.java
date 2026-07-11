import java.util.ArrayList;
import java.util.List;

/**
 * Companion code for: ../06-data-types.md
 *
 * Run:
 *   javac DataTypesDemo.java
 *   java DataTypesDemo
 */
public class DataTypesDemo {

    public static void main(String[] args) {
        primitiveTypesDemo();
        referenceTypeDemo();
        autoboxingDemo();
        wrapperEqualsVsDoubleEqualsDemo();
        integerOverflowDemo();
    }

    static void primitiveTypesDemo() {
        System.out.println("--- The 8 Primitive Types ---");
        byte b = 100;
        short s = 30000;
        int i = 42;
        long l = 8_000_000_000L;      // 'L' suffix required — too big for int
        float f = 3.14f;               // 'f' suffix required — literal is double by default
        double d = 3.14159;
        char c = 'A';
        boolean flag = true;

        System.out.println("byte=" + b + " short=" + s + " int=" + i + " long=" + l);
        System.out.println("float=" + f + " double=" + d + " char=" + c + " boolean=" + flag);
    }

    static void referenceTypeDemo() {
        System.out.println("\n--- Reference Types ---");
        String name = "Alice";        // reference to a String object
        int[] numbers = {1, 2, 3};    // arrays are reference types too
        System.out.println("name = " + name + ", numbers[1] = " + numbers[1]);
    }

    static void autoboxingDemo() {
        System.out.println("\n--- Autoboxing / Unboxing ---");
        int primitiveAge = 25;
        Integer wrappedAge = primitiveAge;  // autoboxing
        int backToPrimitive = wrappedAge;   // unboxing
        System.out.println("wrappedAge=" + wrappedAge + " backToPrimitive=" + backToPrimitive);

        List<Integer> scores = new ArrayList<>();
        scores.add(95);              // int autoboxed into Integer
        int first = scores.get(0);   // Integer unboxed into int
        System.out.println("scores.get(0) unboxed = " + first);
    }

    static void wrapperEqualsVsDoubleEqualsDemo() {
        System.out.println("\n--- Integer Caching Gotcha: == vs .equals() ---");
        Integer a = 100, b = 100;
        System.out.println("a == b (both 100, within cache range) -> " + (a == b)); // true

        Integer x = 200, y = 200;
        System.out.println("x == y (both 200, outside cache range) -> " + (x == y)); // false!
        System.out.println("x.equals(y) -> " + x.equals(y)); // true — always correct
    }

    static void integerOverflowDemo() {
        System.out.println("\n--- Silent Integer Overflow ---");
        int max = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE       = " + max);
        System.out.println("Integer.MAX_VALUE + 1   = " + (max + 1) + "  <-- wraps around silently!");

        long safe = (long) max + 1;
        System.out.println("Using long instead      = " + safe);
    }
}
