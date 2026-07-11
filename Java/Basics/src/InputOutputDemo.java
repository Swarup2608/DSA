import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Companion code for: ../09-input-output.md
 *
 * Run interactively:
 *   javac InputOutputDemo.java
 *   java InputOutputDemo
 *
 * This demo reads your name and age with Scanner (fixing the classic
 * nextInt()/nextLine() trap). The BufferedReader demo then parses a
 * SIMULATED line of input (via StringReader) rather than real System.in —
 * mixing a Scanner read and a fresh BufferedReader on the SAME System.in
 * in one program is itself a classic gotcha: Scanner buffers ahead
 * internally, so a BufferedReader created afterwards can miss data that
 * Scanner already pulled in. In a real program you'd pick ONE of the two
 * to read System.in, not both — here we swap in StringReader purely so
 * this file stays runnable end-to-end without needing real stdin twice.
 */
public class InputOutputDemo {

    public static void main(String[] args) throws IOException {
        outputStylesDemo();
        scannerDemo();
        bufferedReaderDemo();
    }

    static void outputStylesDemo() {
        System.out.println("--- Output Styles ---");
        System.out.print("print: no newline... ");
        System.out.println("println: adds a newline");
        System.out.printf("printf: pi is %.2f%n", 3.14159);
    }

    static void scannerDemo() {
        System.out.println("\n--- Scanner (type input and press Enter) ---");
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your age: ");
        int age = sc.nextInt();
        sc.nextLine(); // IMPORTANT: consume the leftover newline left by nextInt()

        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello, " + name + "! You are " + age + " years old.");
    }

    static void bufferedReaderDemo() throws IOException {
        System.out.println("\n--- BufferedReader (fast input, e.g. competitive programming) ---");
        System.out.println("(Using simulated input here — see the class-level comment for why.)");

        // In a REAL competitive-programming program, replace this line with:
        //   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new StringReader("5\n10 20 30 40 50"));

        int n = Integer.parseInt(br.readLine().trim());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        for (int val : arr) {
            sum += val;
        }
        System.out.println("N = " + n + ", sum of the " + n + " numbers = " + sum);
    }
}
