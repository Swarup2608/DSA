/**
 * Companion code for: ../07-type-casting.md
 *
 * Run:
 *   javac TypeCastingDemo.java
 *   java TypeCastingDemo
 */
public class TypeCastingDemo {

    public static void main(String[] args) {
        wideningDemo();
        narrowingDemo();
        truncationVsRoundingDemo();
        bytePromotionDemo();
        objectCastingDemo();
    }

    static void wideningDemo() {
        System.out.println("--- Widening (automatic, safe) ---");
        int myInt = 100;
        long myLong = myInt;       // int -> long, automatic
        double myDouble = myLong;  // long -> double, automatic
        System.out.println("myInt=" + myInt + " myLong=" + myLong + " myDouble=" + myDouble);

        char myChar = 'A';
        int charCode = myChar;     // char -> int, automatic
        System.out.println("myChar=" + myChar + " charCode=" + charCode);
    }

    static void narrowingDemo() {
        System.out.println("\n--- Narrowing (explicit cast required) ---");
        double myDouble = 9.78;
        int myInt = (int) myDouble;   // must cast — truncates to 9
        System.out.println("(int) 9.78 = " + myInt);

        long bigNumber = 130L;
        byte myByte = (byte) bigNumber; // fits fine
        System.out.println("(byte) 130L = " + myByte);

        int overflowing = 300;
        byte tooSmall = (byte) overflowing; // compiles, but overflows silently
        System.out.println("(byte) 300 (overflowed!) = " + tooSmall);
    }

    static void truncationVsRoundingDemo() {
        System.out.println("\n--- Truncation vs Rounding ---");
        int truncated = (int) 9.78;
        int rounded = Math.round(9.78f);
        System.out.println("(int) 9.78     = " + truncated + "  (chops decimal, does NOT round)");
        System.out.println("Math.round(9.78f) = " + rounded + "  (actually rounds)");
    }

    static void bytePromotionDemo() {
        System.out.println("\n--- byte/short Arithmetic Always Promotes to int ---");
        byte a = 10;
        byte b = 20;
        // byte sum = a + b;       // would NOT compile — a + b is promoted to int
        byte sum = (byte) (a + b); // must cast back down explicitly
        System.out.println("(byte)(a + b) = " + sum);
    }

    static void objectCastingDemo() {
        System.out.println("\n--- Casting Object References ---");
        Object obj = "Hello";       // widening: String "is-a" Object, automatic
        String str = (String) obj;  // narrowing: must cast, can throw ClassCastException if wrong
        System.out.println("Cast back to String: " + str);
    }
}
