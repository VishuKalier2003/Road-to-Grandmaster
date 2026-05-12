## Balance Point

### Trigger
When the question can be reduced to form
    * Y(x) = A(x) + B(x)
such that 
- one term increases
- one term decreases
- increasing x increases one part but decreases (worsens) other part
- a balance point is attained that is termed as minima
- the graph becomes convex leading to convex optimization

### Mistakes
- Thinking binary search

### Idea
- If function is expressed as form y(x) = A(x) + B(x), it is a convex when increasing x, increases one part and decreases other part
- Usually optimum occurs near balance point
- Evaluate minima using derivative
- To remove the floating point precision error, when evaluating the minima, traverse +5 and -5 integers around it

### One Liner
- Find the minima using derivative of the expression, solve it for +5, -5 values around the minima to remove floating point

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Deadline | [1288A](https://codeforces.com/problemset/problem/1288/A) | 1100 |