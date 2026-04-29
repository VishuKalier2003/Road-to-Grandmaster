## State Compression by Modulo

### Trigger
Given n elements, and in one operation we decrease current largest element by k, and if an element goes below a threshold (usually 0), the element is eliminated, find the sequence of elimination of elements (give the indices)

### Mistakes
- Thinking about simulation and priority queue
- Thinking about simulating and applying operations one at a time

### Idea
- Reduce the states or elements to a range [1, k] using modulo, because the first removal will happen only when all states are <= k
- Since first removal itself will happen when states are <= k, simulating entire process is inefficient
- A hidden trick is that the range will be [1, k] and not [0, k], the element which is a % k == 0, is assigned k, since the element will be last to be removed
- Reduction is necessary because until then we won't know which element will be removed among all the elements
- Sort the reduced elements as per the constraints

### One Liner
- Reduce states in range [1, k], for a % k == 0, keep k and then sort as per the constraints provided

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Monsters | [1849B](https://codeforces.com/problemset/problem/1849/B) | 1000 |