## Digit Sum

### Trigger
When we have a given digit (root digit), and want to find the kth digit that when reduced with the recurring formula
    T(n) = S(n) = sum of its digits
is the same as the given digit

### Mistakes
- Thinking about simulation
- Not knowing the formula

### Idea
- The formula is direct and if you know it then problem is simple else utterly complex
- For any number S = 10<sub>0</sub> + <sub>1</sub> + ... + <sub>k</sub> for k digits, and 10 = 1 mod 9 so all powers get refactored as whole x mod 9
- Hence the root digit z for x is same as x+9, x+18, x+27, etc. creating an Arithmetic Progression with d = 9
- We just need to map the [0,8] interval to [1,9] interval so we do k-1, resulting in the formula z = a + (k-1) * d

### One Liner
- Kth number that has same root digit = x + (k-1) * 9

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Digit Root | [1107B](https://codeforces.com/problemset/problem/1107/B) | 1000 |