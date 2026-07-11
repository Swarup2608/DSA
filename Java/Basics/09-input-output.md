# 9. Input / Output (`Scanner`, `BufferedReader`)

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%209%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> A program that can't talk to the outside world is just a calculator with extra steps. Output gets you started (`System.out.println`); input is what makes a program actually *interactive*.

## 🎯 Why This Matters

Nearly every competitive-programming problem and every real command-line tool needs to read input and print output. Java gives you more than one way to do this, and picking the right tool matters — `Scanner` is friendly for learning and small programs, but it's genuinely too slow for reading large competitive-programming inputs, where `BufferedReader` becomes necessary.

## 🖨️ Output — `System.out`

```java
System.out.println("Hello, World!");   // prints text, then moves to a new line
System.out.print("No newline here");   // prints text, stays on the same line
System.out.printf("Pi is %.2f%n", 3.14159); // formatted output — %.2f = 2 decimal places
```

| Method | Adds newline? | Use for |
|---|---|---|
| `print()` | No | Building output piece by piece |
| `println()` | Yes | Most everyday printing |
| `printf()` | No (unless you add `%n`) | Formatted, precise output |

## ⌨️ Input — `Scanner` (the friendly, beginner-first way)

`Scanner` lives in `java.util` and reads input token-by-token or line-by-line.

```java
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = sc.nextLine();       // reads a whole line

        System.out.print("Enter your age: ");
        int age = sc.nextInt();             // reads a single int token

        System.out.println("Hello, " + name + "! You are " + age + " years old.");

        sc.close();   // always close it when you're done with System.in
    }
}
```

### `Scanner`'s Reading Methods

| Method | Reads |
|---|---|
| `nextLine()` | An entire line of text (up to and including the newline) |
| `next()` | A single whitespace-separated token |
| `nextInt()` | The next token, parsed as an `int` |
| `nextDouble()` | The next token, parsed as a `double` |
| `hasNext()` / `hasNextInt()` | Whether more input is available (great for loops) |

### ⚠️ The Classic `nextInt()` + `nextLine()` Trap

```java
Scanner sc = new Scanner(System.in);
System.out.print("Enter age: ");
int age = sc.nextInt();          // reads "25", but leaves the trailing newline in the buffer

System.out.print("Enter name: ");
String name = sc.nextLine();     // reads that LEFTOVER newline immediately — "name" ends up empty!
```

`nextInt()` (and `next()`, `nextDouble()`, etc.) only consume the token itself, **not** the newline character after it. The very next `nextLine()` call then immediately grabs that leftover empty line instead of waiting for real user input.

**Fix:** add an extra `sc.nextLine()` to consume the leftover newline before reading the real line:

```java
int age = sc.nextInt();
sc.nextLine();              // consume the leftover newline
String name = sc.nextLine(); // now this works as expected
```

## ⚡ Input — `BufferedReader` (the fast way)

For programs that read a *lot* of input — think competitive programming with thousands of lines — `Scanner` is measurably slower because of the parsing overhead built into its convenience. `BufferedReader` reads raw text faster; you parse it yourself.

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BufferedReaderDemo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();               // reads one full line as a String
        int n = Integer.parseInt(line.trim());       // manual parsing — you do the conversion

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // split & parse tokens yourself
        }

        br.close();
    }
}
```

`StringTokenizer` splits a line into whitespace-separated tokens, similar to what `Scanner.next()` does automatically, but with far less overhead.

## 🥊 `Scanner` vs `BufferedReader` — When to Use Which

| | `Scanner` | `BufferedReader` |
|---|---|---|
| Ease of use | ✅ Very easy, built-in parsing | ⚠️ You parse manually |
| Speed | ❌ Slower | ✅ Much faster |
| Best for | Learning, small programs, simple CLIs | Competitive programming, large inputs |

> 💡 Rule of thumb: reach for `Scanner` while learning and for everyday small tools. Reach for `BufferedReader` + `StringTokenizer` the moment you're solving a problem with tight time limits and large input sizes (LeetCode/Codeforces-style).

## ⚠️ Common Mistakes

- **Forgetting to consume the leftover newline** after `nextInt()`/`next()` before calling `nextLine()`.
- **Not closing `Scanner`/`BufferedReader`** — minor in a short-lived program, a real resource leak in a long-running one. (`try-with-resources`, covered under Exception Handling, automates this.)
- **Using `Scanner` in a tight competitive-programming loop** reading thousands of numbers, then wondering why the program times out. Switch to `BufferedReader`.
- **Forgetting `BufferedReader.readLine()` can return `null`** at end-of-stream — always check before using it if reading in a loop.

## ✅ Quick Recap

- `System.out.print` / `println` / `printf` cover all your output needs.
- `Scanner` is the easy, beginner-friendly way to read input — but watch out for the `nextInt()` + `nextLine()` leftover-newline trap.
- `BufferedReader` + `StringTokenizer` is faster and preferred for large inputs (competitive programming).

## 🧪 Practice

1. Write a program that asks for a name (`nextLine`) and an age (`nextInt`), and print them back in a sentence.
2. Reproduce the `nextInt()` + `nextLine()` bug on purpose, observe the empty name, then fix it with the extra `sc.nextLine()`.
3. Rewrite the same program using `BufferedReader` and manual parsing.

**Previous:** [← Operators](08-operators.md) · **Next:** [Conditionals →](10-conditionals.md)
