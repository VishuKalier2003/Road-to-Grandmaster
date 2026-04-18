## Divisibility of a<sub>x</sub> by b

### Trigger
Checking divisibility of a<sub>x</sub> by n where a<sub>x</sub> is very large

### Key Idea
- Do not do simple modulo, find radical (product of distinct prime factors) of both a<sub>x</sub> and n
- Each prime factor of n must have power lower than that of corresponding distinct prime factor a<sub>x</sub>.

### Mistake
- Trying simple modulo or thinking binary search

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [2205B](https://codeforces.com/problemset/problem/2205/B) | finding radical(n) | 800 |
