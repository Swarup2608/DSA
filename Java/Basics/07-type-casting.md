# 7. Type Casting (Widening / Narrowing)

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%207%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> Every value in Java has a type, and sometimes you need to move a value from one type to another. Java lets you do that — but it makes you say the quiet part out loud whenever there's a risk of losing information.

## 🎯 Why This Matters

Type casting bugs are sneaky because they often don't crash — they just quietly produce the *wrong number*, which is far more dangerous than a loud exception. Understanding widening vs. narrowing tells you exactly when Java will protect you automatically and when you're on your own.

## 📈 Widening Conversion (Implicit, Automatic, Safe)

Going from a **smaller** type to a **larger** one happens automatically, because no information can be lost.

```
byte → short → int → long → float → double
```

```java
int myInt = 100;
long myLong = myInt;     // widening — automatic, no cast needed
double myDouble = myLong; // widening again — still automatic
```

```java
char myChar = 'A';
int charCode = myChar;    // widening char -> int; charCode becomes 65 (the Unicode value)
```

> 💡 Notice `char` fits into this chain too — a `char` is really just a 16-bit unsigned integer under the hood, so it widens into `int` cleanly.

## 📉 Narrowing Conversion (Explicit, Manual, Risky)

Going from a **larger** type to a **smaller** one might lose data — so Java forces you to be explicit with a **cast**: `(type) value`.

```java
double myDouble = 9.78;
int myInt = (int) myDouble;    // must cast explicitly — myInt becomes 9 (decimal part truncated, not rounded!)

long bigNumber = 130L;
byte myByte = (byte) bigNumber; // fits fine within byte's range (-128 to 127)

int overflowing = 300;
byte tooSmall = (byte) overflowing; // DOES compile, but produces a garbage-looking result (44) due to overflow
```

### Why `(int) 9.78` gives `9`, not `10`

Casting a floating-point value to an integer type **truncates** — it simply chops off everything after the decimal point. It does **not** round. If you want rounding, use `Math.round()`:

```java
int truncated = (int) 9.78;         // 9
int rounded = Math.round(9.78f);    // 10 (note: Math.round(double) returns long, Math.round(float) returns int)
```

## 🧮 Type Promotion in Expressions

When you mix types in a single expression, Java automatically promotes smaller types to match the largest type present — you rarely notice this until it bites you:

```java
byte a = 10;
byte b = 20;
byte sum = a + b;          // ❌ compile error! a + b is promoted to int before adding
byte sum2 = (byte)(a + b); // ✅ must cast explicitly back down to byte
```

This is because arithmetic on `byte`/`short` in Java **always** produces an `int` result — there is no `byte`-level addition in the JVM's instruction set.

## 🔤 Casting Between Objects (a Sneak Peek)

Casting isn't just for primitives — object references can be cast too, within an inheritance hierarchy (covered fully in [OOP](../../README.md)). The same "widening is automatic, narrowing needs a cast" idea applies there as well:

```java
Object obj = "Hello";          // widening — String "is-a" Object, automatic
String str = (String) obj;      // narrowing — must cast, and can throw ClassCastException at runtime if wrong
```

## ⚠️ Common Mistakes

- **Assuming narrowing casts round.** `(int) 9.99` gives `9`, not `10`. Always truncates toward zero.
- **Silent overflow on narrowing.** `(byte)(200)` compiles and runs without error, but produces a nonsensical value because 200 doesn't fit in a `byte`'s range. Java doesn't check this for you at runtime.
- **Forgetting `byte`/`short` arithmetic always widens to `int`.** `byte c = a + b;` (with `byte a, b`) is a classic beginner compile error.
- **Losing precision silently with `float`.** Converting a `double` to `float` can silently drop precision without any compiler warning — always be deliberate about which one you actually need.

## ✅ Quick Recap

- Widening (small → large) is automatic and safe: `byte → short → int → long → float → double`.
- Narrowing (large → small) requires an explicit cast `(type)` and can silently lose data or overflow.
- Casting a floating-point number to an integer **truncates**, it does not round — use `Math.round()` for rounding.
- `byte`/`short` arithmetic always promotes to `int`; cast back explicitly if you need the smaller type.

## 🧪 Practice

1. Widen an `int` to a `double` and print both — confirm no cast is needed.
2. Narrow `9.99` to an `int` with an explicit cast and confirm the result is `9`, not `10`. Then use `Math.round()` to get `10`.
3. Deliberately cast `300` down to a `byte` and print the (nonsensical) result — this is what silent narrowing overflow looks like.

**Previous:** [← Data Types](06-data-types.md) · **Next:** [Operators →](08-operators.md)
