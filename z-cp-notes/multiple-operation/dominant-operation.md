## Dominant Operation

### Trigger
When the question involves
- multiple type operations
- data or array can be categorized into classes or groups
- the valid pair is only of indices (i,j) when i < j (strict)
and are asked to maximize the number of pairs based on constraints

### Mistakes
- Using brute force or pure mathematics

### Idea
- Find the dominating group. The dominating group is defined as-
    * If a subset `S` of elements satisfies f(x,y) = `true` for all x in `S` and all y, then placing S elements first is optimal for maximizing pairs, in short the dominating group is the group or type of elements that make the f(x,y) = true on maximum possibilities hence universally favorable
- This generalizes to
    * odd even
    * numbers divisible by a fixed k
    * elements with a maximal weight or frequency
    * "always compatible items" in scheduling problems

### One Liner
- Move the universally good group to front, to maximize cross-pairs

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Array Reordering | [1535B](https://codeforces.com/problemset/problem/1535/B) | 900 |
