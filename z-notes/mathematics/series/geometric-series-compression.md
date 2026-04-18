## Geometric Series Compression

### Trigger
Sum of powers of 2: 1 + 2 + 4 + ... + 2<sup>k</sup> = n or doubling sequence, Sm<sub>2</sub><sup>k</sup>

### Key Idea
- Reduce the sequence of GP to x(2<sup>k</sup> - 1) then iterate k instead of n
- 2<sup>k</sup> grows exponentially, k <= 30 for int

### Mistake
- Thinking as simulation
- Thinking as binary search or adhoc on n

### Problems
| S. No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [1343A](https://codeforces.com/problemset/problem/1343/A) | x(Sm<sub>2</sub><sup>k</sup>) = n find x | 900 |