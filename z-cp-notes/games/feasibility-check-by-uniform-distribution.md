## Feasibility Check by Uniform Distribution

### Trigger
When asked whether a construction is possible under a limit like-
- at most k changes / moves / recolors
- m buckets / colors / groups
- one side can “repair” or “absorb” only a bounded number of items
- Most importantly one side tries to make adjacent buckets different and other tries to reverse the effect

### Mistakes
- Trying to simulate the opponent moves (impractical approach)
- Thinking as explicit construction
- Missing that answer depends upon largest bucket only

### Idea
- Translate action into a threshold
    * Find out after evenly distributing can the opponent color (repair) the buckets into color of max available bucket
    * Think as bucketing the problem or generalizing the moves of first player
    * Based on the generalized moves, what or when or the limit k when the second player cannot win
- In case of coloring, the opponent will try to color all differently colors blocks into the maximum color block present

### One Liner
- Find the bottleneck or when the limit when the opponent can break the bucket

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Paint the Ribbon | [1954A](https://codeforces.com/problemset/problem/1954/A) | 900 |
