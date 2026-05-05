## Sorting Inside Constraint Buckets

### Trigger
When problem given as
- some set of elements need to given more priority (can be placed into separate bucket)
- constraint group array elements into buckets (can be 2,3,..k)
- each bucket is independent state and the constraints of bucket do not overlap
- there exist a strict ordering constrain between the group
Then we are asked to
- create a unique priority rank for each element under a constraint
- create the ranks of the element per bucket

### Mistakes
- Thinking as a simple greedy one time sorting or a pairing question

### Idea
- Since we need to create buckets we need sorting once
- But the bucket elements are further constrained down, hence another sorting is required
- Assign contiguous rank ranges (as per constraint) to each bucket
- The constraints are greedy, so think greedily to minimize or maximize cost per bucket (locally) and then as a whole (globally)

### One Liner
- use custom based sorting to first sort elements into buckets and then within buckets on the basis of constraints

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Berland Music | [1622B](https://codeforces.com/problemset/problem/1622/B) | 1000 |