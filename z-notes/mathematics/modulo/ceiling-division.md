## Ceiling Division

### Trigger
A cost function ceil(a<sub>i</sub> / x) and you can merge or split elements freely

### Key Idea
- Ceil(a/x) + Ceil(b/x) > Ceil((a+b)/x), merging never increases total cost
- Ceil formula - ceil(a/x) = (a + x - 1) / x (never use floating point)

### Generalized

```
    Given: array A[], integer x, free merge operations on adjacent elements
    Goal: minimize and maximize Σ⌈a_i / x⌉

    MINIMUM:
        totalSum = sum of all elements
        answer_min = (totalSum + x - 1) / x   // merge everything into one

    MAXIMUM:
        answer_max = 0
        for each element a in A:
            answer_max += (a + x - 1) / x        // keep all separate

    Return answer_min, answer_max
```

### One Liner
Min = Ceil(sum(a<sub>i</sub> / x)) and Max = sum(Ceil(a<sub>i</sub> / x))

### Mistake
- Didn't knew the inequality relation
- Also not to use floating point with ceil

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [1471A](https://codeforces.com/problemset/problem/1471/A) | ceiling operation | 900 |