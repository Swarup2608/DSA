# 2. Structure of a Java Program

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%202%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> Every Java program you will ever write — from a "Hello World" to a distributed banking system — follows the same skeleton. Learn the skeleton once, and you'll never be confused by "where does this go" again.

## 🎯 Why This Matters

New learners often type Java code by pattern-matching what they've seen online, without understanding *why* each piece is where it is. That works until it doesn't — the moment you need two classes, or a package, or a static field, the cargo-cult approach falls apart. Understanding the structure means you can *reason* about any Java file you open, even one you've never seen before.

## 🧱 The Anatomy of a Java File

```java
package com.example.myapp;              // 1. Package declaration (optional, must be first)

import java.util.Scanner;               // 2. Import statements

public class HelloWorld {               // 3. Class declaration

    static int counter = 0;              // 4. Fields (class-level variables)

    public static void main(String[] args) {  // 5. The main method — entry point
        System.out.println("Hello, World!");  // 6. Statements
    }

    static void helper() {               // 7. Other methods
        // ...
    }
}
```

Let's take these apart one at a time.

### 1. Package Declaration

```java
package com.example.myapp;
```

A **package** is a namespace — a folder-like grouping for related classes, used to avoid naming collisions (there could be a hundred `Utils` classes in the world; packages keep them from colliding). If present, it **must** be the very first line in the file (comments aside). It's optional — omit it and your class lives in the unnamed "default package," which is fine for small exercises but frowned upon in real projects.

### 2. Import Statements

```java
import java.util.Scanner;
```

Java's standard library is enormous, so classes aren't automatically visible — you `import` the ones you use. Think of it as telling the compiler "when I say `Scanner`, I mean `java.util.Scanner`, not something else."

### 3. Class Declaration

```java
public class HelloWorld {
```

Everything in Java lives inside a **class** (or an interface, enum, or record — but let's not get ahead of ourselves). `public` means this class is accessible from anywhere. Critically:

> ⚠️ **The public class name must exactly match the filename.** `public class HelloWorld` must live in a file named `HelloWorld.java`. Get this wrong and the compiler will refuse to help you guess what you meant.

### 4. Fields

Variables declared directly inside the class (outside any method) are called **fields** or **member variables**. They represent the state that belongs to the class or its objects.

### 5. The `main` Method — Your Program's Front Door

```java
public static void main(String[] args) {
```

This exact signature is how the JVM knows where to start:

| Keyword | Meaning |
|---|---|
| `public` | JVM (outside the class) must be able to call it |
| `static` | Runs without needing an object of the class first |
| `void` | Returns nothing |
| `main` | The magic name the JVM looks for |
| `String[] args` | Command-line arguments, as an array of strings |

If any of these are wrong — say you write `private static void main`, or `public void main` (missing `static`) — the JVM will refuse to launch with a `NoSuchMethodError: main`.

### 6. Statements

Individual instructions inside a method, each ending in a semicolon `;`. `System.out.println("Hello, World!");` is one statement.

### 7. Other Methods

Additional behavior your class needs, defined alongside `main`.

## 🗂️ One Public Class Per File

A `.java` file can contain multiple classes, but only **one** of them may be `public`, and it must share the file's name.

```java
// FileOps.java
public class FileOps {          // must match filename
    // ...
}

class Helper {                  // package-private, fine to coexist
    // ...
}
```

## ⚠️ Common Mistakes

- **Filename/class name mismatch.** `public class Main` saved as `App.java` → compile error: *"class Main is public, should be declared in a file named Main.java."*
- **Forgetting `static` on `main`.** The JVM literally cannot find an entry point without it.
- **Putting the package statement after imports.** It must come first, full stop.
- **Confusing a class with an object.** The class is the blueprint (`HelloWorld`); an object is an instance built from that blueprint (`new HelloWorld()`). `main` itself doesn't need an object because it's `static`.

## ✅ Quick Recap

- Structure, top to bottom: `package` → `import`s → `class` → fields → `main`/other methods.
- `public class` name **must** match the filename.
- `main`'s signature (`public static void main(String[] args)`) is fixed — the JVM looks for it exactly.

## 🧪 Practice

1. Write a file `Greeter.java` with a `public class Greeter`, a field `String name = "World"`, and a `main` method that prints `"Hello, " + name`.
2. Deliberately rename the file to something else and try to compile it. Read the exact error message the compiler gives you.
3. Add a second, non-public class to the same file. Confirm it still compiles.

**Previous:** [← Compilation Process](01-compilation-process.md) · **Next:** [Basic Syntax →](03-basic-syntax.md)
