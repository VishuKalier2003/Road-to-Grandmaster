## Min of Max

### Trigger
When distribute n elements into k buckets such that max among all buckets is min

### Mistakes
- Simulating the problem

### Idea
- Use nested ceil, as we need to store the extra elements if encountered when dividing, so we use ceil instead of using if and +1

### One Liner
- Min of Max among k buckets - ceil( (ceil(n/k) * k) / n)

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | K Divisible Sum | [1473B](https://codeforces.com/problemset/problem/1473/B) | 1000 |