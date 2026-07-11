# 5. Constants (`final`)

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%205%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> A constant is a variable with a promise attached: "I will never change." Java enforces that promise for you, at compile time, so you never have to trust yourself (or a teammate) to keep it by convention alone.

## 🎯 Why This Matters

Magic numbers scattered through code (`if (status == 3)` — what *is* 3?) are one of the fastest ways to make a codebase unreadable and unmaintainable. Constants give meaning to values and, just as importantly, give the compiler a way to catch you if you accidentally try to change something that should never change.

## 🔒 Declaring a Constant

Java has no dedicated `const` keyword (unlike C++/JavaScript). Instead, you use `final`:

```java
final double PI = 3.14159;
final int MAX_USERS = 100;
```

Once assigned, a `final` variable cannot be reassigned:

```java
final int MAX_USERS = 100;
MAX_USERS = 200;   // ❌ compile error: "cannot assign a value to final variable MAX_USERS"
```

## 🏷️ Naming Convention: `UPPER_SNAKE_CASE`

This isn't enforced by the compiler, but it's a near-universal convention — the moment you see `ALL_CAPS_WITH_UNDERSCORES`, you know it's a constant.

```java
final int MAX_RETRIES = 3;
final String DEFAULT_NAME = "Guest";
```

## 🏛️ `static final` — the True Class-Wide Constant

A plain `final` field is still per-instance (each object could theoretically get a different value at construction time, just never change it afterward). To get one single, shared, unchanging value for the entire class, combine `static` with `final`:

```java
public class Physics {
    public static final double GRAVITY = 9.8;   // one value, shared by everyone, forever
}

// Usage elsewhere:
double g = Physics.GRAVITY;
```

| Modifier combo | Meaning |
|---|---|
| `final` | This instance's value can't change once set |
| `static` | One value shared across all instances |
| `static final` | The idiomatic Java "true constant" |

## 🧊 `final` on Objects — A Subtlety That Trips Everyone Up

`final` prevents **reassignment**, not **mutation**. If a `final` variable holds a reference to a mutable object (like an `ArrayList`), the reference can't be pointed at a new object — but the object it points to can still be changed internally.

```java
final int[] scores = {1, 2, 3};
scores[0] = 99;              // ✅ allowed — you're mutating the array's contents
scores = new int[]{4, 5, 6}; // ❌ not allowed — you're reassigning the reference
```

Think of `final` as gluing the label to one specific box — you can still put different things *inside* that box; you just can't move the label to a different box.

## 🧩 `final` on Methods and Classes (Preview)

`final` shows up in two other contexts you'll meet later in [OOP](../../README.md):

- `final` method → cannot be overridden by a subclass.
- `final` class → cannot be subclassed at all (e.g., `String` is a `final` class).

For now, just know the keyword means "locked" wherever it appears.

## ⚠️ Common Mistakes

- **Thinking Java has a `const` keyword.** It doesn't — some learners coming from JavaScript/C++ instinctively type `const`, and it simply won't compile.
- **Assuming `final` deep-freezes an object.** It only locks the reference, not the object's internal state (see the array example above).
- **Forgetting `static` on true constants.** Without `static`, every single object gets its own copy of the constant in memory — wasteful and not really "constant" in the shared sense.
- **Not initializing a `final` local variable.** Unlike regular locals, if you declare `final int x;` without an initializer, you must assign it exactly once before use — the compiler tracks this ("definite assignment").

## ✅ Quick Recap

- Java's constant keyword is `final`, not `const`.
- `static final` is the idiomatic way to declare a true, class-wide constant.
- `final` locks the *reference*, not necessarily the object it points to.
- Convention: name constants in `UPPER_SNAKE_CASE`.

## 🧪 Practice

1. Declare `static final double TAX_RATE = 0.18;` in a class and use it in a calculation elsewhere.
2. Create a `final int[] data` array, mutate one of its elements successfully, then try to reassign `data` to a brand-new array and observe the compile error.
3. Explain in one sentence why `public static final` constants are so common at the top of Java classes.

**Previous:** [← Variables](04-variables.md) · **Next:** [Data Types →](06-data-types.md)
