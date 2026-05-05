## Nearest Multiple

### Trigger
When 
- we can increase or decrease a number, item, etc.
- the cost is different for the operations (a,b)
- need to make it divisible by some number x
Finding the min cost for that

### Mistakes
- Do not take the case of n % x == 0 blindly

### Idea
- If n % x != 0 = k, then to make it divisible we can either decrease it k blocks or increase it n - k blocks

### One Liner
- Divisibility can be found by following both operations +1/-1 the choice is which is the minimum

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Commentary Boxes | [990A](https://codeforces.com/problemset/problem/990/A) | 1000 |