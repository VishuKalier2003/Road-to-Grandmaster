## Dominant Element

### Trigger
When asked given x types of elements
- place the elements in line such that no tow adjacent elements are of same type
- Can be asked about feasibility or constructing the sequence

### Mistakes
- Trying brute force

### Idea
- We need to find the max element and then distribute the rest around them
- Sort elements based on frequency, and then order the greater frequency elements first
- the relation max <= sum of others + 1 must hold

### One Liner
- Sort and check the max first

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Stickers and Toys | [1279A](https://codeforces.com/problemset/problem/1279/A) | 900 |