## Last State Modulo

### Trigger
When
- an operation nums[i] op k is applied multiple time
- the operation element is specific (max of the array, min, etc.)
And we need to find out the order of elements in which they go below or above a certain threshold x

### Mistakes
- Simulating as a greedy, using priority queue

### Idea
- The sequence or the order depends upon the final state of the elements
- The final state is within the range x and x op k, because the op will be applied to the elements which are not in this range as per the constraint
- The values are then sorted as per the constraint and printed

### One Liner
- Reduce the states from range [0, n] to [x, x op k], the final state and then perform sorting

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Prime Subtraction | [1238A](https://codeforces.com/problemset/problem/1238/A) | 900 |