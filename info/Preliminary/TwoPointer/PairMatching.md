### Pair Matching (Two Pointers)

A pattern of pairing elements from a set under a monotone feasibility constraint, where the goal is to satisfy rule F to the maximum possible

##### STEP - I (Greedy Pairing)

###### Input
- Data array D
- Rule F for a Pair (X<sub>i</sub>, X<sub>j</sub>)

###### Purpose
Finding the maximum number of disjoint pairs satisfying rule F

###### Technique
- First guarantee that rule F is monotone feasible
- Sort the array D
- Pick two pointers L and R, both at extreme ends respectively until L <= R
- Test whether L and R can form a valid pair, under the rule F
- If valid, pair them as L++ and R--, otherwise discard largest element from the rule F by doing R--

###### Output
Count of maximum number of valid disjoint pairs under the rule F

###### Variations
There are multiple variations for the pair matching pattern on basis of the feasibility rule F such as

*Threshold Pairing*
> Rule is a + b <= X and we just need to do two pointer greedy post sorting

*Difference Pairings*
> Rule F is |a + b| <= X, we sort and pair based on nearest feasible elements using two pointers but the direction of greedy movement changes.

*Exact Sum Pairing*
> Rule F changes to a + b <= X, we use hashmap or two pointers after sorting

*Online Pairing*
> The data comes online in batches, better to use a TreeMap for dynamic feasibility check