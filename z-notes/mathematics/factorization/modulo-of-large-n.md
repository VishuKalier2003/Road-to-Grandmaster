## Divisibility of a<sup>x</sup> by b

### Trigger
Checking divisibility of a<sup>x</sup> by n where a<sup>x</sup> is very large

### Key Idea
- Do not do simple modulo, find radical (product of distinct prime factors) of both a<sup>x</sup> and n
- Each prime factor of n must have power lower than that of corresponding distinct prime factor a<sup>x</sup>.

### Mistake
- Trying simple modulo or thinking binary search

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [2205B](https://codeforces.com/problemset/problem/2205/B) | finding radical(n) | 800 |
