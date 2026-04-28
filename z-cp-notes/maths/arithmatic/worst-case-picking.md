## Worst Case Picking

### Trigger
When asked
- under what minimum number of moves, event X is guaranteed to happen? (guarantee here means worst-case)
- Usually two events X and Y

### Mistakes
- Trying to simulate as steps
- Thinking as backtracking or pick/not-pick problem

### Idea
- To guarantee event X to occur, we must first exhaust event Y from total events N, a = N - X
- Add +1 to survive the worst case
- In case of multiple events use max = max(N-X, N-Y) + 1

### One Liner
- Guaranteed occurance of both events X,Y out of N to happen is max(N-X, N-Y) + 1

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Stickers and Toys | [1187A](https://codeforces.com/problemset/problem/1187/A) | 900 |