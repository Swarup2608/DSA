# 11. Loops

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%2011%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> Computers are extraordinarily good at doing the same thing many times, quickly, without complaining. Loops are how you tell them exactly what "the same thing" is, and when to stop.

## 🎯 Why This Matters

Loops are the backbone of almost every algorithm you'll study in [Phase 2 of the Roadmap](../../Roadmap.md) — traversal, searching, sorting, sliding windows, all of it is loops with a specific twist. Getting comfortable with the three core loop shapes now means you'll spend your energy later on the *algorithm*, not on fighting the syntax.

## 🔁 The `for` Loop — When You Know the Count

Best when you know (or can compute) exactly how many times you need to repeat something, or you're iterating with an index.

```java
for (int i = 0; i < 5; i++) {
    System.out.println("Iteration: " + i);
}
```

The three parts of a `for` loop, in order:

| Part | Runs | Example |
|---|---|---|
| Initialization | Once, before anything else | `int i = 0` |
| Condition | Before *every* iteration | `i < 5` |
| Update | After *every* iteration's body | `i++` |

```
init --> [condition true?] --yes--> body --> update --> [condition true?] --> ...
                 │
                 no
                 ▼
              loop ends
```

## 🔄 The `while` Loop — When You Don't Know the Count

Best when the number of iterations depends on something that can only be determined *during* execution (like user input, or a condition that changes unpredictably).

```java
int count = 0;
while (count < 5) {
    System.out.println("Count: " + count);
    count++;
}
```

The condition is checked **before** the body runs. If it's `false` on the very first check, the body never executes at all.

## 🔂 The `do-while` Loop — Run At Least Once

Identical to `while`, except the condition is checked **after** the body — guaranteeing at least one execution, even if the condition would've been `false` from the start.

```java
int count = 0;
do {
    System.out.println("Count: " + count);
    count++;
} while (count < 5);
```

```java
// Classic use case: menu-driven programs that must show the menu at least once
int choice;
do {
    System.out.println("1. Start\n2. Exit");
    choice = sc.nextInt();
} while (choice != 2);
```

## 🧊 Nested Loops

A loop inside a loop — the inner loop completes **all** of its iterations for **every single** iteration of the outer loop.

```java
for (int i = 1; i <= 3; i++) {
    for (int j = 1; j <= 3; j++) {
        System.out.print(i + "" + j + " ");
    }
}
// Output: 11 12 13 21 22 23 31 32 33
```

This is the mechanism behind matrix traversal, pattern printing, and comparing every pair of elements in an array.

## 🛑 `break` — Exit the Loop Immediately

```java
for (int i = 0; i < 10; i++) {
    if (i == 5) {
        break;   // exits the loop entirely the moment i reaches 5
    }
    System.out.println(i);
}
// Output: 0 1 2 3 4
```

## ⏭️ `continue` — Skip to the Next Iteration

```java
for (int i = 0; i < 5; i++) {
    if (i == 2) {
        continue;   // skips printing 2, but the loop keeps going
    }
    System.out.println(i);
}
// Output: 0 1 3 4
```

**`break` stops the loop entirely. `continue` only skips the rest of the current iteration's body and moves on to the next one.** Mixing these up mid-debugging is a very common early confusion.

## 🏷️ Labeled Break/Continue — Escaping Nested Loops

By default, `break`/`continue` only affects the *innermost* loop they're in. To affect an outer loop from inside a nested one, label it:

```java
outer:
for (int i = 0; i < 3; i++) {
    for (int j = 0; j < 3; j++) {
        if (j == 1) {
            continue outer;   // skips to the NEXT iteration of the outer loop, not the inner one
        }
        System.out.println(i + "," + j);
    }
}
```

## 🎨 Pattern Printing — Loops as a Skill Builder

Pattern printing is a rite of passage — not because triangles of stars are useful in production, but because they force you to think precisely about the relationship between an outer loop's index (the row) and an inner loop's bounds (how many characters that row needs).

```java
// Right triangle:
// *
// **
// ***
// ****
for (int i = 1; i <= 4; i++) {
    for (int j = 1; j <= i; j++) {
        System.out.print("*");
    }
    System.out.println();     // move to the next row
}
```

> 💡 The trick to any pattern problem: figure out, in words, "how many of X does row `i` need?" *before* writing any code. The inner loop's bound is almost always a small formula in terms of `i`.

## ⚠️ Common Mistakes

- **Off-by-one errors.** `i < 5` gives 5 iterations (0-4); `i <= 5` gives 6 (0-5). Always double check whether your bound should be `<` or `<=` against what you actually want to include.
- **Infinite loops.** Forgetting to update the loop variable (`i++`) in a `while` loop, or writing a condition that never becomes false.
  ```java
  int i = 0;
  while (i < 5) {
      System.out.println(i);
      // forgot i++ !!  This loop never ends.
  }
  ```
- **Using `do-while` when `while` was actually correct**, and accidentally running a body once on input that should have skipped it entirely.
- **Confusing `break` and `continue`**, especially inside nested loops without labels — `break` in an inner loop only escapes that inner loop, the outer one keeps going.

## ✅ Quick Recap

- `for`: know your count in advance. `while`: condition-driven, checked before the body. `do-while`: same as `while`, but guarantees at least one run.
- `break` exits the loop entirely; `continue` skips just the current iteration.
- Labeled `break`/`continue` let you control an *outer* loop from inside a nested one.
- Off-by-one errors and infinite loops are the two most common loop bugs — check your bounds and your update step every time.

## 🧪 Practice

1. Print numbers 1 to 10 using a `for` loop, then rewrite it using a `while` loop, then a `do-while` loop.
2. Write nested loops that print a 5x5 grid of `*` characters, then modify it to print a right-triangle pattern like the example above.
3. Write a loop from 1 to 20 that uses `continue` to skip multiples of 3 and `break` to stop entirely once it hits 15.

**Previous:** [← Conditionals](10-conditionals.md) · **Next:** [Functions →](12-functions.md)
