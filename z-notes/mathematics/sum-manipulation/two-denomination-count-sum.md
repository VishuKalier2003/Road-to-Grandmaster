## Two Denomination count sum

### Trigger
find min, max count of items when given two types of items of fixed sizes a and b that must sum to value n

### Key Idea
- Model as d1.a + d2b = n
- For min use larger value (a,b) greedily with ceil and vice versa for smaller with floor
- Only possible when n % gcd(d1,d2) == 0 and min <= max

### One Liner
- Greedy on opposite ends gives the range, floor and ceil handles edge cases

### Mistake
- Doing case analysis on n % d1 and n % d2

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [1679A](https://codeforces.com/problemset/problem/1679/A) | min, max when d1 = 4 and d2 = 6 | 900 |
