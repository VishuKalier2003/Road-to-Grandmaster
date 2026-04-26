## Range Overlap

### Trigger
- A number x can be added into the array in or k times to reach sum s
- checking two ranges are overlapping or not
- number of times of occurence of number x in a range

### Key Idea
- Sum is commutative (a+b) = (b+a)
- So we can sum the entire array as precomputation

### One Liner
Addition is cumulative, so can be performed at any time (preferrably first or last)

### Lemma

Lemma A - How many multiples of k or frequency of k fits in window of size m,
```
    freq(k) in [0, m] = floor(m/k) + 1
    freq(k) in (0, m) = floor(m/k)
```

### Mistake
- Thinking in which element to add sum

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [2193A](https://codeforces.com/problemset/problem/2193/A) | add x to a<sub>i</sub> | 800 |
| 2. | [1341A](https://codeforces.com/problemset/problem/1341/A) | range overlap | 900 |
| 3. | [1945A](https://codeforces.com/problemset/problem/1945/B) | occurence of k in a window | 900 |
