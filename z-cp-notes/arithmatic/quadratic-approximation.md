## Quadratic Approximation

### Trigger
When the problem
- is present or can be expressed as a quadratic function in the problem
- is a series, blocks, etc. are a triangular sequence like [1],[1,2],[1,4,6], etc.
- formula is monotonically increasing
- formula has small deviation in square root, like k^2, k^2+1, etc.
And we need to find the variable

### Mistakes
- Trying to simulate

### Idea
- Find the root using Math.sqrt()
- The deviation due to precision is countered by adjusting ans linearly

### One Liner
- Find the root and then first decrease and then increase k linearly to find the exact value

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Points on Plane | [1809B](https://codeforces.com/problemset/problem/1809/B) | 1000 |