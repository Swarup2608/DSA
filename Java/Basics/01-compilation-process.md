# 1. The Compilation Process (`javac` / `java`)

![Java Basics](https://img.shields.io/badge/Java%20Basics-Topic%201%2F11-orange?style=flat-square) ![Level](https://img.shields.io/badge/Level-Beginner-brightgreen?style=flat-square)

> "Write Once, Run Anywhere." Every Java developer has heard that slogan. Almost nobody has been told *why* it's true. Let's fix that.

## 🎯 Why This Matters

Before you can debug a real problem — a `ClassNotFoundException`, a mysterious version mismatch, a build that works on your machine but not on the server — you need a mental model of what happens between you hitting "save" on a `.java` file and a program actually running. Skip this, and every build error feels like magic. Understand it, and every build error becomes a puzzle with an obvious first move.

## 🏗️ The Big Picture

Java doesn't compile straight to machine code the way C++ does, and it isn't purely interpreted the way old-school scripting languages were. It does something in between, and that "in between" is the entire reason Java is portable.

```
YourFile.java  --[javac]-->  YourFile.class  --[java / JVM]-->  Running Program
   (source)                    (bytecode)                        (output)
```

### Step 1 — You write source code

You write human-readable code in a file ending in `.java`. This is plain text — the computer's CPU has no idea what to do with it yet.

### Step 2 — `javac` compiles it to bytecode

The **Java Compiler** (`javac`) reads your `.java` file and translates it into **bytecode**, saved in a `.class` file. Bytecode is *not* machine code for your specific CPU (x86, ARM, etc.) — it's an intermediate, platform-neutral instruction set that only the JVM understands.

```bash
javac HelloWorld.java
# produces: HelloWorld.class
```

### Step 3 — The JVM loads and runs the bytecode

The **Java Virtual Machine** (JVM) is a program that pretends to be a computer whose "machine code" is Java bytecode. When you run:

```bash
java HelloWorld
```

the JVM:
1. **Loads** the `.class` file (via the Class Loader)
2. **Verifies** the bytecode is safe and well-formed (Bytecode Verifier)
3. **Executes** it — usually via a mix of interpretation and **JIT (Just-In-Time) compilation**, which compiles hot code paths to real native machine code on the fly for speed

```
.class file --> Class Loader --> Bytecode Verifier --> Execution Engine (Interpreter + JIT) --> CPU
```

## 🌍 Why "Write Once, Run Anywhere" Is True

The JVM is platform-*specific* (there's a different JVM binary for Windows, macOS, Linux), but the **bytecode is platform-independent**. As long as a machine has a JVM installed, it can run your `.class` file — whether it was compiled on a Mac or a Linux server.

```
YourFile.java  --[javac, done once]-->  YourFile.class
                                              │
                    ┌─────────────────────────┼─────────────────────────┐
                    ▼                         ▼                         ▼
              JVM on Windows            JVM on Linux              JVM on macOS
```

You compile once. The bytecode runs anywhere a JVM exists.

## 🧩 JDK vs JRE vs JVM — The Trio That Confuses Everyone

| Term | Full Name | Contains | Use It To... |
|---|---|---|---|
| **JVM** | Java Virtual Machine | The engine that runs bytecode | Execute compiled programs |
| **JRE** | Java Runtime Environment | JVM + core libraries | Run Java programs (no compiler) |
| **JDK** | Java Development Kit | JRE + `javac` + dev tools | Write **and** run Java programs |

> 💡 Rule of thumb: if you're *developing* Java, you need the **JDK**. The JRE alone can't compile anything — it has no `javac`.

## 🛠️ Try It Yourself

```java
// HelloWorld.java
public class HelloWorld {
    public static void main(String[] args) {
        System.out.println("Compiled once, running here.");
    }
}
```

```bash
javac HelloWorld.java   # Step 1: source -> bytecode
ls                       # you'll see HelloWorld.class appear
java HelloWorld          # Step 2: JVM loads & runs the bytecode
```

## ⚠️ Common Mistakes

- **Confusing `javac` and `java`.** `javac` *compiles* (needs the `.java` file). `java` *runs* (needs the class name, **without** `.java` or `.class`).
- **Expecting `.class` files to be human-readable.** They're binary bytecode — open one in a text editor and you'll just see garbage. Use `javap -c` if you ever want to inspect bytecode.
- **Thinking Java is "purely interpreted."** It's compiled to bytecode first, then that bytecode is interpreted *and* JIT-compiled to native code at runtime. That's precisely why the JVM can be both portable and fast.

## ✅ Quick Recap

- `javac` turns `.java` source into platform-neutral `.class` bytecode.
- The JVM loads, verifies, and executes that bytecode — this is where "Write Once, Run Anywhere" comes from.
- JDK = JRE + compiler + tools. You need the JDK to develop Java.

## 🧪 Practice

1. Compile and run the `HelloWorld` example above.
2. Run `javap -c HelloWorld.class` and look at the bytecode instructions. You won't understand all of it yet — that's fine, just notice it's a low-level instruction list, nothing like your source code.
3. In one sentence, explain to a rubber duck (or a friend) why a `.class` file compiled on Windows can run unmodified on Linux.

**Next up:** [Structure of a Java Program →](02-structure-of-a-java-program.md)
