## Not More Than k

### Trigger
When we need to maximize the sum or product from an array
- where a number (max, some specific, etc.) cannot appear consecutively no more than k times

### Mistakes
- Trying simulation or over-complicating the function with modulus

### Idea
- Maximizing can be done by choosing the largest number, and since it cannot be repeated more than k times, the bucket will be of size k+1
- The k+1 th element will be the second largest element
- Evaluate the remainder of bucket if possible, such that if remainder exists, it will all be the max number

### One Liner
- Evaluate bucket and the remainder bucket's elements are all max element or as per the constraint

### Problem

Related problems are given below-

| S. No. | Problem Name | Problem | Rating |
|-|-|-|-|
| 1. | Emotes | [1117B](https://codeforces.com/problemset/problem/1117/B) | 1000 |