## Jump to Divisible State

### Trigger
When there are two types of operations
- One Division
- One Subtraction by fixed value x
- or vice versa multiplication and addition
and we need to find the minimum number of operations to reach target?

### Mistakes
- Trying to simulate as steps of subtraction

### Idea
- Division is always better than subtraction is reducing the number and when subtracting we need to reach division, the better state
- To reach better state we simply do r = n % k, and divide r by the fixed value x to calculate number of steps without simulating

### One Liner
- Jump to better state via Modulo without simulating use r = n % k and divide r by fixed value x

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | From hero to zero | [1175A](https://codeforces.com/problemset/problem/1175/A) | 900 |