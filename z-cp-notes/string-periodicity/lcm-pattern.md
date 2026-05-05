## Lcm Pattern

### Trigger
When 
- we are given two or more strings
- strings have repetition
- divisibility is introduced in the strings
need to find the Lcm string

### Mistakes
- Do not think of brute-forcing using loops
- Do not do unnecessary computation of finding min and max

### Idea
- If the strings are commutative s1 + s2 == s2 + s1, the the lcm exists, as the pattern must repeat in both strings
- The hcf can be evaluated based on string length, and so the lcm via the formula hcf x lcm = a x b
- The repetition value z can be found by dividing lcm with the other string length

### One Liner
- Use s1 + s2 == s2 + s1 principle and then evaluate repetition value z

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | String LCM | [1473B](https://codeforces.com/problemset/problem/1473/B) | 1000 |