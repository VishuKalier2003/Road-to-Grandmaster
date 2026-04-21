## Max gcd

### Trigger
The gcd(x,y)+y to be maximized, where x > y

### Key Idea
- gcd(x,y) can never exceed x
- Hence gcd(x,x-1) = 1 so gcd(x,x-1) + x-1 is the max

### One Liner
- the gcd(x,y) is min at y = x-1 but gcd(x,y) + y is max

### Mistake
- Couldn't derive the gcd(x,x-1) relation

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [1968A](https://codeforces.com/problemset/problem/1968/A) | max of gcd(x,y) + y with 1 <= y < x | 800 |
