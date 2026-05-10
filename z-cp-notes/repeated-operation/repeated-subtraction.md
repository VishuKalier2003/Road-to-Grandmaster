## Repeated Subtraction

### Trigger
When
- operation repeatedly adds/subtracts the same quantity
- values monotonically decrease
- operation count does not matter, only the final value holds responsibility

### Mistakes
- Trying simulation

### Idea
- The simulation compress subtraction into modulo (%) since only the remainder or output matters
- Modulo is compressed repeated subtraction

### One Liner
- Subtraction loop until a threshold is reached is same as applying modulo (%)

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Weird Subtraction Process | [946B](https://codeforces.com/problemset/problem/946/B) | 1100 |