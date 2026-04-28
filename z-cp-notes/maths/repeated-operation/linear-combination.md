## Linear Combination

### Trigger
When
- an operation is applied multiple time
And we need to check the feasibility of solution

### Mistakes
- Trying to simulate as steps

### Idea
- Break the total effect into steps x operation (k), t = s x k
- Then think about whether the reduction depends 
    * When operation repeatable and unordered - think as gcd
    * When operation output repeats in cycles, divisibility or too large to simulate - think as modulo
    * When uses same number and primes mentioned - think as prime
- Hence we reduce the operation to mathematical compression (not solving the process but what the process represents)

### One Liner
- Break the total effect into linear combination

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Prime Subtraction | [1238A](https://codeforces.com/problemset/problem/1238/A) | 900 |