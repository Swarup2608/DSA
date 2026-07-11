# 10. Conditionals

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%2010%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> A program that always does the same thing regardless of input isn't very useful. Conditionals are how your code makes decisions — the difference between a calculator and one that refuses to divide by zero.

## 🎯 Why This Matters

Almost every interesting bug in software is a conditional that didn't cover the case that actually happened in production. Learning to write conditionals clearly — and to *exhaust* the cases you actually need — is one of the highest-leverage skills in this entire roadmap.

## ✅ `if`

```java
int age = 20;
if (age >= 18) {
    System.out.println("You can vote.");
}
```

The block runs only if the condition inside `( )` evaluates to `true`. Java requires a genuine `boolean` here — unlike some languages, `if (1)` will **not** compile; there's no implicit "truthy" conversion from `int` to `boolean`.

## 🔀 `if-else`

```java
int age = 15;
if (age >= 18) {
    System.out.println("You can vote.");
} else {
    System.out.println("You cannot vote yet.");
}
```

Exactly one of the two branches runs.

## 🪜 `else if` — Chaining Multiple Conditions

```java
int score = 72;
if (score >= 90) {
    System.out.println("Grade: A");
} else if (score >= 80) {
    System.out.println("Grade: B");
} else if (score >= 70) {
    System.out.println("Grade: C");
} else {
    System.out.println("Grade: F");
}
```

Conditions are checked **top to bottom**, and the **first** one that's `true` wins — the rest are skipped entirely, even if they'd also be `true`. Order matters: if you swapped `score >= 70` above `score >= 90`, a score of 95 would incorrectly land in the "C" bucket.

## 🪆 Nested `if`

An `if` inside another `if`, for conditions that depend on each other.

```java
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
```

> 💡 Nesting is sometimes clearer written as a combined condition instead: `if (age >= 18 && hasID)`. Prefer combining conditions when the logic is genuinely one decision, and keep nesting for when the branches truly need separate handling (like the "ID required" message above, which a combined condition couldn't express as clearly).

## 🎚️ `switch`

`switch` is a cleaner alternative to a long `else if` chain when you're comparing **one variable** against several **exact** values.

```java
int day = 3;
switch (day) {
    case 1:
        System.out.println("Monday");
        break;
    case 2:
        System.out.println("Tuesday");
        break;
    case 3:
        System.out.println("Wednesday");
        break;
    default:
        System.out.println("Some other day");
}
```

### ⚠️ Fall-Through — `switch`'s Most Famous Gotcha

Without a `break`, execution **falls through** to the next case, running its code too:

```java
int day = 2;
switch (day) {
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
        System.out.println("Weekday");   // cases 1-5 all share this one line — intentional fall-through
        break;
    case 6:
    case 7:
        System.out.println("Weekend");
        break;
}
```

Grouping cases like `case 1: case 2: case 3:` (no `break` between them) is a deliberate, useful pattern — sharing one action across several values. **Forgetting** a `break` when you *didn't* mean to share logic is the bug version of the same mechanism.

### Modern Java `switch` Expressions (Java 14+)

Newer Java versions offer an arrow-based form that returns a value directly and doesn't fall through:

```java
String dayType = switch (day) {
    case 1, 2, 3, 4, 5 -> "Weekday";
    case 6, 7 -> "Weekend";
    default -> "Invalid day";
};
```

No `break` needed — each `case` is its own isolated arm. Prefer this style when your Java version supports it; it removes the fall-through footgun entirely.

## ❓ Ternary Operator

A compact `if-else` that **produces a value** — useful for simple, single-expression decisions.

```java
int age = 20;
String status = (age >= 18) ? "Adult" : "Minor";
```

Reads as: *condition* `?` *value if true* `:` *value if false*.

```java
int a = 10, b = 20;
int max = (a > b) ? a : b;   // max becomes 20
```

> 💡 Ternaries are great for a single, simple assignment. Nesting them (`a ? b : (c ? d : e)`) trades a small amount of typing for a real hit to readability — prefer a regular `if-else` once it's not a single clean decision.

## ⚠️ Common Mistakes

- **Using `=` instead of `==`.** `if (age = 18)` is a compile error in Java for `boolean` contexts (unlike C, where this silently compiles and is a classic bug) — one place where Java's strictness genuinely protects you.
- **Forgetting `break` in a `switch`** when fall-through wasn't intended.
- **Ordering `else if` conditions wrong**, so a more specific case never gets reached because a broader one above it already caught it.
- **Comparing objects (like `String`) with `switch`/`==` incorrectly** — `switch` on `String` compares by *value* (using `.equals()` internally), which is a pleasant exception to the usual `==`-vs-`.equals()` rule, but only for `switch`.

## ✅ Quick Recap

- `if` / `else if` / `else` chains run top-to-bottom; the first `true` condition wins.
- `switch` compares one variable against exact values; forgetting `break` causes fall-through.
- Java's newer arrow-style `switch` expressions avoid fall-through entirely and can return a value.
- The ternary operator (`cond ? a : b`) is a compact `if-else` that produces a value — best kept to single, simple decisions.

## 🧪 Practice

1. Write a grade calculator using `else if` that correctly handles A/B/C/F, and verify the ordering matters by testing a boundary score like exactly `90`.
2. Write a `switch` on an `int` month (1-12) that prints the season, using grouped fall-through cases (e.g., 12, 1, 2 → "Winter").
3. Rewrite one simple `if-else` (e.g., choosing the larger of two numbers) as a ternary expression.

**Previous:** [← Input / Output](09-input-output.md) · **Next:** [Loops →](11-loops.md)
