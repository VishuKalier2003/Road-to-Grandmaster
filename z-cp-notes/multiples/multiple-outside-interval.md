## Multiple Outside Interval

### Trigger
When we need to find smallest multiple of x
- which is outside range [l, r]

### Mistakes
- Trying to think something related to modulo

### Idea
- There are three cases-
    * if x > r then number is itself
    * if x < l then also number is itself
    * if x is in the range [l,r], then we need to find the number of multiples that occur till r, s = r/x then find s+1 th multiple

### One Liner
- First multiple outside bound is (r/x)+1 th multiple apart from edge cases

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Minimum Integer | [1101A](https://codeforces.com/problemset/problem/1101/A) | 1000 |