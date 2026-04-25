## Gcd Invariant

### Trigger
Two numbers with a simultaneous operation (add, subtract) maximize gcd

### Key Idea
- When applying +k or -k to both a and b, the difference |a-b| stays constant
- gcd(a,b) = gcd(|a-b|, b) if a > b
- Since gcd(a,b) must divide |a-b|, the max possible gcd is g = |a-b|

### One Liner
- Max gcd after simultaneous ops is |a-b| since the diff is invariant

### Mistake
- Thought I needed to search over a range or use euclidean algorithms to solve it
- Searching a range instead of finding is there a constant?

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [1543A](https://codeforces.com/problemset/problem/1543/A) | +1, -1 ops on both a and b | 900 |
