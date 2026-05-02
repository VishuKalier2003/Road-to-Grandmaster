## Closure Set Operations

### Trigger
When a commutative operationn like (a+b), (a*b), etc. are applied on a set of elements to check if the output is possible and merging is allowed and not splitting

### Mistakes
- Thinking about recursion when the approach can be solved by mathematics

### Idea
- Say for output y, any element that jumps out of the range, like for example greater than y can be neglected
- Rest elements can apply the operations commutatively and then we can check whether the result exist
- But this works under some constraints,
    * Family of closure on the operation, if x in S then x op x should also be in S
    * Operation invariant
    * One way transformation, only one operation to work with

### One Liner
- Drop the operation from recursion to operation over array with constraint

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | 2048 Game | [1221A](https://codeforces.com/problemset/problem/1221/A) | 1000 |