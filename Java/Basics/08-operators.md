# 8. Operators

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%208%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> Operators are the verbs of programming — they *do* things to your values. You've used most of these since grade-school arithmetic; Java just adds a few new ones and a couple of sharp edges.

## 🎯 Why This Matters

Almost every line of real logic — a condition, a calculation, a loop counter update — leans on operators. Knowing precedence and the subtle behavior of a few of them (integer division, short-circuiting) prevents a whole class of "why is my answer wrong" bugs.

## ➕ Arithmetic Operators

| Operator | Meaning | Example | Result |
|---|---|---|---|
| `+` | Addition | `5 + 2` | `7` |
| `-` | Subtraction | `5 - 2` | `3` |
| `*` | Multiplication | `5 * 2` | `10` |
| `/` | Division | `5 / 2` | `2` ⚠️ (integer division!) |
| `%` | Modulus (remainder) | `5 % 2` | `1` |

```java
int a = 5, b = 2;
System.out.println(a / b);           // 2  — integer division truncates the decimal!
System.out.println((double) a / b);  // 2.5 — cast one operand to get a real division
System.out.println(a % b);           // 1  — the remainder
```

> ⚠️ **The #1 arithmetic gotcha in Java:** dividing two `int`s always gives an `int` result — the fractional part is silently discarded, no exception thrown. If you want a decimal answer, at least one operand must be a `double`/`float`.

## ⚖️ Relational (Comparison) Operators

All of these produce a `boolean` result.

| Operator | Meaning |
|---|---|
| `==` | Equal to |
| `!=` | Not equal to |
| `>` | Greater than |
| `<` | Less than |
| `>=` | Greater than or equal to |
| `<=` | Less than or equal to |

```java
int x = 10, y = 20;
System.out.println(x < y);   // true
System.out.println(x == y);  // false
```

> ⚠️ For objects (like `String`), `==` compares references, not content. Use `.equals()` to compare values — see [Data Types](06-data-types.md) for the full explanation with wrapper classes.

## 🔗 Logical Operators

| Operator | Meaning | Short-circuits? |
|---|---|---|
| `&&` | Logical AND | ✅ Yes |
| `\|\|` | Logical OR | ✅ Yes |
| `!` | Logical NOT | — |

```java
int age = 25;
boolean hasLicense = true;
System.out.println(age >= 18 && hasLicense);  // true
System.out.println(age < 18 || hasLicense);   // true
System.out.println(!hasLicense);              // false
```

### Short-Circuit Evaluation — Not Just a Performance Trick

`&&` and `||` **skip evaluating the right side if the left side already decides the answer**. This isn't just an optimization — it's often load-bearing for correctness:

```java
String name = null;
if (name != null && name.length() > 0) {   // safe: if name IS null, name.length() is NEVER called
    System.out.println("Has a name");
}
```

If you used the non-short-circuiting bitwise `&`/`|` here instead of `&&`/`||`, `name.length()` would be evaluated even when `name` is `null`, throwing a `NullPointerException`. **Always prefer `&&`/`||` over `&`/`|` for boolean logic.**

## 🟰 Assignment Operators

| Operator | Equivalent To | Example |
|---|---|---|
| `=` | — | `x = 5` |
| `+=` | `x = x + 5` | `x += 5` |
| `-=` | `x = x - 5` | `x -= 5` |
| `*=` | `x = x * 5` | `x *= 5` |
| `/=` | `x = x / 5` | `x /= 5` |
| `%=` | `x = x % 5` | `x %= 5` |

```java
int score = 10;
score += 5;   // score is now 15
score *= 2;   // score is now 30
```

## ⏫⏬ Increment / Decrement Operators

| Operator | Meaning |
|---|---|
| `++x` | Pre-increment: increment first, *then* use the value |
| `x++` | Post-increment: use the value first, *then* increment |
| `--x` / `x--` | Same idea, but decrementing |

```java
int a = 5;
int b = ++a;   // a becomes 6 first, THEN b = 6.  Both a and b are 6.
int c = 5;
int d = c++;   // d = 5 (old value used first), THEN c becomes 6. d is 5, c is 6.
```

This is the classic interview gotcha — `x++` returns the *old* value; `++x` returns the *new* one.

## 📐 Operator Precedence — The Short Version

```
()  (highest)
++  --   !          (unary)
*   /   %
+   -
<  <=  >  >=
==  !=
&&
||
=  +=  -=  ...       (lowest)
```

When in doubt, **use parentheses**. `a + b * c` is `a + (b * c)` — multiplication before addition, just like school math — but don't make your reader (or future you) verify that from memory.

```java
int result = 2 + 3 * 4;      // 14, not 20 — multiplication happens first
int clearer = 2 + (3 * 4);   // also 14, but unambiguous at a glance
```

## ⚠️ Common Mistakes

- **Expecting `5 / 2` to be `2.5`.** It's `2` — integer division. Cast to `double` if you need a fractional result.
- **Using `&`/`|` instead of `&&`/`||`.** They work for booleans too, but they don't short-circuit, which can crash on a `null` check that would otherwise be safe.
- **Confusing `x++` with `++x`** when the return value matters, e.g., inside an array index or a larger expression.
- **Forgetting operator precedence.** Multiplication/division bind tighter than addition/subtraction; comparisons bind tighter than `&&`/`||`.

## ✅ Quick Recap

- Integer division truncates; cast to `double` for fractional results.
- `&&`/`||` short-circuit — this is often *required* for safety (e.g., null checks), not just speed.
- `x++` (post) returns the old value then increments; `++x` (pre) increments then returns the new value.
- When precedence isn't obvious at a glance, add parentheses — free readability, zero downside.

## 🧪 Practice

1. Print `7 / 2` and `(double) 7 / 2` side by side and explain the difference.
2. Write an `if` using `&&` that safely checks a possibly-`null` `String` isn't null *and* isn't empty, in that order.
3. Predict the output of `int i = 5; System.out.println(i++ + ++i);` on paper before running it. (Hint: work through each sub-expression left to right, tracking `i`'s value at each step.)

**Previous:** [← Type Casting](07-type-casting.md) · **Next:** [Input / Output →](09-input-output.md)
