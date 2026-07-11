# 3. Basic Syntax

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%203%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> Syntax is the grammar of programming. You don't need to love grammar to use it correctly — you just need enough of it to stop the compiler from yelling at you.

## 🎯 Why This Matters

Every "unexpected token" or "';' expected" error you'll hit in your first month comes down to a handful of syntax rules. Learn them once, deliberately, and you'll stop bleeding time on typos and start spending it on actual logic.

## 🔤 Case Sensitivity

Java is **case-sensitive**. `myVariable`, `MyVariable`, and `MYVARIABLE` are three completely different identifiers.

```java
int age = 25;
int Age = 30;   // a totally different variable — legal, but a terrible idea
```

## 🧱 Identifiers — Naming Things

An **identifier** is any name you give to a variable, method, class, etc. Rules:

- Must start with a letter, `_`, or `$` (not a digit)
- Can contain letters, digits, `_`, `$` after that
- Cannot be a reserved keyword (`class`, `int`, `if`, ...)

```java
int score;        // ✅ valid
int _count;       // ✅ valid (unconventional)
int 2ndPlace;     // ❌ invalid — starts with a digit
int class;         // ❌ invalid — reserved keyword
```

### Naming Conventions (not enforced by the compiler, enforced by your teammates)

| Element | Convention | Example |
|---|---|---|
| Variables & methods | `camelCase` | `totalPrice`, `calculateTotal()` |
| Classes & interfaces | `PascalCase` | `BankAccount`, `Runnable` |
| Constants | `UPPER_SNAKE_CASE` | `MAX_SPEED` |
| Packages | `lowercase.dotted` | `com.example.app` |

## 🧾 Statements & Semicolons

Every statement ends with a semicolon `;`. This is not a suggestion.

```java
int x = 5;
System.out.println(x);
```

## 📦 Blocks & Curly Braces

A **block** is a group of statements wrapped in `{ }`. Blocks define scope — variables declared inside a block don't exist outside it.

```java
{
    int x = 10;
    System.out.println(x);
}
// x no longer exists here
```

Classes, methods, loops, and conditionals all use blocks:

```java
public class Demo {                 // class block
    public static void main(String[] args) {   // method block
        if (true) {                  // if-block
            System.out.println("Inside a block");
        }
    }
}
```

## 💬 Comments

Comments are ignored by the compiler — they're notes for humans.

```java
// Single-line comment

/*
 * Multi-line comment
 * spans several lines
 */

/**
 * Javadoc comment — used to auto-generate documentation.
 * @param name the person to greet
 */
void greet(String name) { }
```

> 💡 A comment should explain **why**, not **what**. `// increment i` next to `i++` teaches nothing. `// skip index 0, it's the sentinel value` teaches something.

## 🔠 Keywords You Can't Use as Names

Java reserves words like `if`, `else`, `class`, `public`, `static`, `void`, `int`, `return`, `new`, `this`, `super`, `try`, `catch`, and about 40 others. The compiler will reject any attempt to use them as identifiers.

## ⚠️ Common Mistakes

- **Missing semicolons.** The single most common first-week compile error.
- **Mismatched braces.** Every `{` needs a matching `}`. Modern editors highlight pairs — use that.
- **Case mismatches.** Calling `println` as `Println` or a variable `Total` when you declared `total`.
- **Using a keyword as a variable name**, e.g. `int class = 5;` — instant compile error.

## ✅ Quick Recap

- Java is case-sensitive; identifiers follow strict naming rules, plus community conventions (camelCase, PascalCase, UPPER_SNAKE_CASE).
- Every statement ends in `;`; every block is wrapped in `{ }` and defines its own scope.
- Three comment styles exist: `//`, `/* */`, and `/** */` (Javadoc).

## 🧪 Practice

1. Write three variables that would compile fine but confuse a teammate purely due to case differences (`total`, `Total`, `TOTAL`). Then delete two of them — this is why the convention exists.
2. Intentionally remove a semicolon from a working program and read the compiler's exact complaint.
3. Write a Javadoc comment for a method `int add(int a, int b)`.

**Previous:** [← Structure of a Java Program](02-structure-of-a-java-program.md) · **Next:** [Variables →](04-variables.md)
