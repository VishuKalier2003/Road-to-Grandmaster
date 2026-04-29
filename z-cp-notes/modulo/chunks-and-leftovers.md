## Chunks and Leftovers (Carry forward)

### Trigger
When a process involves
- continuous accumulation of values
- chunk size of k
- overflow that carries to the next step
And the problem asks
- How many complete chunks are formed at each step?

### Mistakes
- Trying to simulate step by step
- tracking full states instead of the remainder that actually matters

### Idea
- Maintain a running variable `res` to maintain the partial or overflow state
- At each stage, add the incoming into res, check the completed chunks using floor and update the res as the remainder of chunk size k
- Just need to check how much is accumulated and how much is spilled over

### One Liner
- Maintain running sum, find the completed chunks and update the running sum as the leftover using modulo

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Death Note | [1016A](https://codeforces.com/problemset/problem/10169/A) | 900 |