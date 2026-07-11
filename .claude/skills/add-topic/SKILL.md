---
name: add-topic
description: Given one or more Java/DSA topic names (e.g. "OOP", "Collections", "Recursion & Backtracking"), generate a teacher-style lesson .md file in the correct repo folder plus a matching runnable .java demo file with detailed, verified code examples. Use whenever the user asks to "generate", "add", or "create" notes/files for a named programming topic in this repo.
---

# Add Topic

This repo (`DSA/`) teaches Java + DSA through paired files: a `NN-topic-name.md` lesson and a `TopicNameDemo.java` companion in the same folder's `src/`. This skill reproduces that pattern for any new topic so every future addition looks and behaves like the existing ones.

## Reference material — read before generating anything

- `Java/Basics/README.md` and its 12 lesson files (`01-compilation-process.md` … `12-functions.md`) are the canonical style reference. Read at least 2 of them (e.g. `04-variables.md` and `10-conditionals.md`) to recalibrate tone/structure before writing a new one — don't work from memory of the format.
- `Java/Basics/src/*.java` are the canonical code-companion reference.
- `README.md` and `Roadmap.md` at the repo root list every topic this repo intends to cover, organized by phase/section. Use them to figure out which folder a new topic belongs to and whether a checkbox should flip to `[x]`.

## Step 1 — Resolve the target folder

Map the requested topic to a folder using this table. If the user names a topic not listed here, pick the closest phase from `Roadmap.md`/`README.md` and create a new folder following the same `Java/<Section>/` or `DSA/<Section>/` convention (with its own `README.md` index and `src/` subfolder, mirroring `Java/Basics/`).

| Topic keywords | Folder |
|---|---|
| compilation, structure, syntax, variables, constants, data types, casting, operators, I/O, conditionals, loops, functions | `Java/Basics/` |
| OOP, classes, objects, constructors, inheritance, polymorphism, encapsulation, abstraction | `Java/OOP/` |
| Collections, List, Set, Map, ArrayList, HashMap, Comparator | `Java/Collections/` |
| Exception handling, try/catch, custom exceptions | `Java/ExceptionHandling/` |
| Lambdas, functional interfaces, Streams | `Java/LambdasAndStreams/` |
| Generics, wildcards, bounded types | `Java/Generics/` |
| Multithreading, concurrency, Thread, ExecutorService | `Java/Concurrency/` |
| Arrays, Strings, Hashing, Two Pointers, Sliding Window, Sorting/Searching, Binary Search, Recursion & Backtracking, Linked List, Stack & Queue, Trees, Graphs, Dynamic Programming, Greedy, Bit Manipulation, Math & Number Theory | `DSA/<TopicName>/` (Phase 2 in `Roadmap.md`) |

If the folder doesn't exist yet, create it plus a `src/` subfolder and a `README.md` index modeled on `Java/Basics/README.md` (badges + reading-order table + "how to use" section).

## Step 2 — Pick the filename and number

List the folder's existing `NN-*.md` files, find the highest `NN`, and use the next integer, zero-padded to two digits (`01`, `02`, ... `12`, `13`...). Slugify the topic name for the filename (lowercase, hyphens).

## Step 3 — Write the lesson `.md`

Follow this exact structure (copy the shape from an existing file like `Java/Basics/10-conditionals.md`, don't just approximate it from memory):

1. `# N. Topic Title`
2. Badge line: `![Java Basics](...Topic%20N%2FTOTAL...) ![Level](...)` — adjust the badge label to the folder's series name and update `TOTAL` to match the new file count.
3. A one-line `>` blockquote hook — a genuine insight or analogy, not filler.
4. `## 🎯 Why This Matters` — grounded in real consequences (bugs avoided, interview questions, performance), not generic enthusiasm.
5. One `##` section per sub-concept the user listed, each with a runnable code block and inline comments on the non-obvious lines.
6. `## ⚠️ Common Mistakes` — concrete, specific bugs (not "be careful").
7. `## ✅ Quick Recap` — 3-5 bullets.
8. `## 🧪 Practice` — 2-3 hands-on exercises, at least one that deliberately reproduces a mistake from section 6 and then fixes it.
9. Nav line: `**Previous:** [← Prev](prev.md) · **Next:** [Next →](next.md)` (or `**Back to:** [Index](README.md)` if it's the last file in the folder).

Update the *previous* file's nav line to point forward to this new one, and update the folder's `README.md` reading-order table (and its `Topics-N` badge count).

## Step 4 — Write the companion `.java` file

In `<folder>/src/TopicNameDemo.java`:

- One `public class TopicNameDemo` matching the filename, with a Javadoc header comment linking back to the `.md` file (`Companion code for: ../NN-topic-name.md`).
- `main()` calls one `static void xyzDemo()` per `##` section in the lesson, in the same order, each printing a labeled `--- Section Name ---` header so running the file reads like a walkthrough.
- Every code example from the markdown should appear as real, compilable code here — don't invent new examples that don't match the lesson.
- Demonstrate "common mistakes" as commented-out lines (`// would NOT compile: ...`) rather than lines that actually break the build, UNLESS the mistake is a runtime-only issue (like `StackOverflowError` or silent overflow) — those should run and print the real, observed bad output, with a comment explaining it.

## Step 5 — Verify before finishing (mandatory)

A prior generation in this repo produced two `.md` files with a literal null byte in place of a `' '` character-literal example, which made editors refuse to render them as text. Before reporting the task done, always run:

```bash
python3 -c "
import sys
for f in sys.argv[1:]:
    data = open(f,'rb').read()
    n = data.count(0)
    if n:
        print(f, 'HAS', n, 'NULL BYTES')
" <every file you just wrote>
```

If a JDK is available (`javac -version` succeeds), compile every new `.java` file for real:

```bash
cd <folder>/src && javac *.java
```

If no JDK is available (check first — don't assume), do a brace-balance sanity check instead (`grep -o '{' file | wc -l` vs `grep -o '}' file | wc -l`) and say explicitly in your summary that compilation wasn't verified.

## Step 6 — Update the root docs

If the topic corresponds to an unchecked `[ ]` item in `Roadmap.md`, flip it to `[x]`. If `README.md`'s matching Phase section doesn't yet list a **Practice:** line or sub-bullets for this topic and the source material (or the paired lesson file) mentions specific example problems, add them, consistent with how existing Phase 2 sections in `README.md`/`Roadmap.md` already do this.

## Multiple topics in one request

If the user lists several topics at once (as they often do, pasting a chunk of a roadmap section), process them in the order given, incrementing the file number each time, and do the Step 5 verification once at the end across all newly written files rather than per-file.
