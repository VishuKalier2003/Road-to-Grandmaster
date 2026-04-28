## Modulo Coverage

### Trigger
Whenthe problem gives 
- multiple denominations
- in a linear combination equal to n as a1x1 + a2x2 + ... + anxn = N
We need to find the counts of each denomination?

### Mistakes
- Thinking as backtracking

### Idea
- Take the smallest number
- Use the Frobenius problem which states that if gcd(a1, a2,.. an) = 1, then large numbers can be formed as linear combination
- Also find which remainders in the range [0, a1] are covered by which denomination
- The remainder will be fixed by simply choosing the mapped number and that too only once
- Hence we need to brute force only smaller numbers which can be done by hit an trial
- Build the if else statements or the switch case return statement

### One Liner
- Ensure the gcd of denominations is 1 and check the remainders and map them using if else statements

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Apartments | [1430A](https://codeforces.com/problemset/problem/1430/A) | 900 |