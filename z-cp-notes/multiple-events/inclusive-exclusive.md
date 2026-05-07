## Inclusive Exclusive Events

### Trigger
When problem asks given a set of events under a time frame m
- the events occurs at separate but periodic intervals, and may overlap
- the resource distribution is uniform or function driven based on the number of events occuring at that point
And we need to find out
- the resource allocated to a given event
- the number of times an event X only occured
- a mathematical formulation of event X related to other events

### Mistakes
- Thinking as pure division or lcm problem

### Idea
- Using inclusion exclusion principle to deal with it
- Given three events a,b,c occur
    * the event a occurence is given by m/a
    * the event a with one event is given by (m/lcm(a,b)) + (m/lcm(a,b))
    * the event a with two event is given by m(lcm(a, lcm(b,c)))
- Use venn diagram and set theory to evaluate the logic as we need to find "only" events
- So, "a only" is fetched by,
    * c1 = Total a days = a only + ab + ac + abc
    * c2 = a with 1 = ab + ac (but if abc comes, it gets counted twice)
    * c3 = a with 2 = abc
- Now
    * Only A = c1 - c2 + c3 (since c2 removed abc twice)
    * A with 1 only = c2 - 2 * c3 (since c2 gives abc twice, remove it to get A with 1 only)
    * A with 2 only = c3
- Repeat the process with B and C

### One Liner
- Break into equations of "only", A only, A with 1 only, etc. via set theory and use linear equation logic to evaluate and in the end add with the constraint

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Spring | [2204C](https://codeforces.com/problemset/problem/2204/C) | 1000 |