## Monotonic Visited Set

### Trigger
When we need to simulate a process
- store the traversed elements of an array
- elements may be unique
- The pointer never moves back
and for each element check a specific constraint, like when it was reached?

### Mistakes
- Trying nested loops

### Idea
- We will need two pointers i and j
- As the pointers never moves back, we can store the visited elements of pointer j in a set or a map to keep track of them
- Solve the queries by moving the pointer i representing the query array

### One Liner
- When pointers move monotonically forward, the nested loops compress to a visited data structure (map, set) and a single array pass

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Vasya and Books | [1173B](https://codeforces.com/problemset/problem/1173/B) | 1000 |