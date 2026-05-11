## Max Average

### Trigger
When 
- optimizing an aggregated quantity like average, gcd, bitwise, score, etc.
- over subarrays, subsets, segments, etc.
- but aggregate is mathematically bounded by a extremal element
and need to evaluate like
- maximum average, rate, score, etc.

### Mistakes
- Using prefix sums immediately or thinking sliding window

### Idea
- Before optimizing aggregate value ask, what is the theoretical possible maximum value?
- Often aggregate is less than or equal to extremal element, if equality is achievable the problem collapses
- Suppose for eg- max = M
    * any segment average = sum / length, which cannot exceed M
    * The equality exists only when each element of the segment is M
    * Hence the answer reduces to counting values of M
- Then optimization dissappears and only counting remains

### One Liner
- Many optimization problems reduce to extremal-element structures, reduce problem to structure detection, rather than checking values

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Best Subsegment | [1117A](https://codeforces.com/problemset/problem/1117/A) | 1100 |