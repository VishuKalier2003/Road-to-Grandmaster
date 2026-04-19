## K Sum Reachability

### Trigger
Out of n elements of array, choose k elements to sum and reach a target, is target inside a reachable sum range

### Key Idea
- If order doesn't matter and elements are flexible, think in terms of range, not combinatorics
- Replace selection with range check

### One Liner
If order doesn't matter think of range (greedy) not selecting (dp)

### Mistake
- Which k numbers should I take?

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [1878C](https://codeforces.com/problemset/problem/1878C) | choose k from [1, n] to reach sum x | 900 |
