#### Two Sets Matching

When there are two types of data provided, the feasibility rule F is defined between the two data values, the goal is to maximise the number of successful matches.

##### STEP I (Ordering the candidates)

###### Input
- Data array D1
- Resource array D2
- Rule F(D1, D2)

###### Purpose
Expose the ordering of both sides so that the infeasible choices can be skipped

###### Technique
- Sort D1 and D2 and maintain separate pointers for both array as X and Y respectively
- Keep checking the rule F and updating the pointers until one of the pointer reaches the end of its assigned array
- If small discard one by incrementing one pointer and vice versa in case of large, we consume smallest resource that cannot hurt future decisions
- If match found, increment both pointers and the answer

###### Output
The count of valid pairs

###### Variations
The variations happen over the rule F and the major technique remains the same

*Tolerance Matching*
> Rule F is |a - b| <= k, keeping the values within a difference

*Intervals*
> Rule F is a list of intervals for each Data D1, variation depends upon the total number of matches, maximising matches, etc.

*Weighted Matching*
> Rule F encounters a weight as well. The weight might be another function, which transforms the problem from greedy to DP (value-optimised matching)

*Capacity*
> A resource R can include multiple Data D1 upto capacity C, still solved greedily after sorting
