# 12. Functions

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%2012%2F12-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> A function — Java calls it a **method** — is a named, reusable block of logic. Once you write it correctly, you never have to think about *how* it works again, only *what* it does. That's the entire point.

## 🎯 Why This Matters

Every program beyond "print one line" needs to break work into pieces you can name, reuse, and reason about independently. Methods are that mechanism. Get comfortable with declaring, calling, and passing data through methods now, and you're already halfway to understanding classes, interfaces, and eventually design patterns — they're all just methods organized differently.

## 📝 Method Declaration

The declaration is the method's full signature — everything the compiler needs to know before it sees the body.

```java
accessModifier returnType methodName(parameterList) {
    // method body
}
```

```java
public static int square(int number) {
    return number * number;
}
```

| Part | In the example | Meaning |
|---|---|---|
| Access modifier | `public` | Who can call this method |
| `static`? | `static` | Callable without creating an object first |
| Return type | `int` | The type of value this method sends back |
| Method name | `square` | How you refer to it when calling |
| Parameter list | `(int number)` | The inputs it needs |

## 🏗️ Method Definition — Declaration + Body

The **definition** is the declaration *plus* the actual code that runs:

```java
public static int add(int a, int b) {
    int sum = a + b;   // the "definition" — the real work happens here
    return sum;
}
```

Calling it:

```java
int result = add(3, 4);   // result = 7
System.out.println(result);
```

## 📥📤 Parameters & Return Types

**Parameters** are the inputs a method declares it needs. **Arguments** are the actual values you pass in when calling it — a subtle but real distinction ("parameter" is the placeholder, "argument" is the concrete value).

```java
static double calculateArea(double radius) {   // 'radius' is a parameter
    return Math.PI * radius * radius;
}

double area = calculateArea(5.0);   // 5.0 is the argument
```

### `void` — When There's Nothing to Return

```java
static void printGreeting(String name) {
    System.out.println("Hello, " + name + "!");
    // no return statement needed — 'void' means "returns nothing"
}
```

### Returning Early

`return` immediately exits the method — code after it in the same branch never runs. This is often used deliberately for early-exit guard clauses:

```java
static int safeDivide(int a, int b) {
    if (b == 0) {
        return 0;   // guard clause — avoid dividing by zero, exit immediately
    }
    return a / b;
}
```

### Multiple Parameters, Any Types

```java
static String formatName(String first, String last, int age) {
    return first + " " + last + " (" + age + ")";
}
```

## 🎭 Method Overloading — Same Name, Different Signatures

Java lets you define **multiple methods with the same name**, as long as their **parameter lists differ** (in number, order, or type). The compiler figures out which one you meant based on what you pass in.

```java
static int add(int a, int b) {
    return a + b;
}

static double add(double a, double b) {
    return a + b;
}

static int add(int a, int b, int c) {
    return a + b + c;
}
```

```java
add(2, 3);         // calls add(int, int)      -> 5
add(2.5, 3.5);      // calls add(double, double) -> 6.0
add(1, 2, 3);       // calls add(int, int, int)  -> 6
```

> ⚠️ **The return type alone does NOT count as a difference.** You cannot overload two methods that differ *only* in return type — the parameter list must differ.
> ```java
> int add(int a, int b) { return a + b; }
> double add(int a, int b) { return a + b; }  // ❌ compile error — duplicate method, same signature
> ```

## 🔁 Recursion — A Method That Calls Itself

A recursive method solves a problem by calling a smaller version of itself, until it reaches a case simple enough to answer directly.

```java
static int factorial(int n) {
    if (n == 0) {              // base case
        return 1;
    }
    return n * factorial(n - 1); // recursive case
}
```

```
factorial(4)
= 4 * factorial(3)
= 4 * (3 * factorial(2))
= 4 * (3 * (2 * factorial(1)))
= 4 * (3 * (2 * (1 * factorial(0))))
= 4 * (3 * (2 * (1 * 1)))
= 24
```

## 🧱 Base Case & Recursive Case — The Two Halves Every Recursive Method Needs

| Part | Job | Example (`factorial`) |
|---|---|---|
| **Base case** | Stops the recursion — answers directly, no further calls | `if (n == 0) return 1;` |
| **Recursive case** | Reduces the problem and calls itself again | `return n * factorial(n - 1);` |

**Every recursive method must have at least one base case, and every recursive call must move strictly closer to it.** Miss either rule and you get infinite recursion — which in Java doesn't loop forever silently, it crashes with a `StackOverflowError` once the call stack (see [Memory & Internals](../../Roadmap.md)) runs out of space.

```java
// ❌ Missing base case — infinite recursion, crashes with StackOverflowError
static int broken(int n) {
    return n * broken(n - 1);   // never stops!
}
```

## ⚠️ Common Mistakes

- **Forgetting `return` in a non-`void` method.** If a method promises a return type, every code path must actually return a value, or it won't compile.
- **Trying to overload by return type alone.** The parameter list must differ — the compiler won't accept two methods that only differ in what they return.
- **Missing or unreachable base case in recursion.** Both cause a `StackOverflowError` — one from infinite recursion, the other from a base case that technically exists but is never actually reached because the recursive case doesn't move toward it.
- **Confusing "parameter" and "argument."** Minor in casual conversation, but useful precision once you're reading error messages or documentation closely.

## ✅ Quick Recap

- A method's signature = access modifier + (optional `static`) + return type + name + parameter list.
- Parameters are placeholders in the declaration; arguments are the real values passed at the call site.
- Overloading lets you reuse a method name across different parameter lists — return type alone doesn't count.
- Every recursive method needs a base case (to stop) and a recursive case that provably moves toward it (to avoid a `StackOverflowError`).

## 🧪 Practice

1. Write an overloaded `max` method: one version for two `int`s, one for two `double`s, one for three `int`s.
2. Write a recursive `int sum(int n)` that returns `1 + 2 + ... + n`, with a correct base case for `n == 0`.
3. Deliberately remove the base case from your `sum` method, run it, and read the `StackOverflowError` — then put the base case back.

**Previous:** [← Loops](11-loops.md) · **Back to:** [Java Basics Index](README.md)
