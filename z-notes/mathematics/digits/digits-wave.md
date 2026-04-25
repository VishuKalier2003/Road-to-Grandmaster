## Greedy Modular Wave / Ripple Anchoring

### Trigger
Sequence of digits repeats

### Key Idea
- The digits repeat in a wave, find the start point of the wave grredily
- Use % 10 in construction of digits with relation to index in the digit string
- Since digits are repeating in sequence, the % property will hold

### One Liner
Find the start of digit sequence and construct greedily

### Mistake
- Didn't think of using % as the substitute for boolean flags

### Problems
| S.No. | Problem | Note | Rating |
|-|-|-|-|
| 1. | [1467A](https://codeforces.com/problemset/problem/1467/A) | largest digit | 900 |
