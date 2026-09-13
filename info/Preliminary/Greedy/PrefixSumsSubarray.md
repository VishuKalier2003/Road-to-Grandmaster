#### Prefix Sums Subarray

A pattern where the problem asks to find the count of sub-arrays of specific constraint, we use prefix sums to reduce the complexity

##### STEP - I (Precomputation)

###### Input
- Data array D1
- Target T
- Array Size N

###### Purpose
Convert the Data array D1 into Prefix array P, of size N+1, to compress [L, R] sum into two pointers relationship of P<sub>r</sub> and P<sub>l</sub>

###### Technique
- Use addition to convert D1 to Prefix array P
- First element is 0, hence the P size is n+1

###### Output
An array of length N+1 that store the sum of D1 elements for a given index (here sum)

###### Variantions

*Subarray XOR = x*
> Instead of sum use XOR

*Equal number of 0 and 1*
> Transform 0 to -1 and 1 to +1 and then build the array

*Equal number of multiple categories*
> Build the state as (cA - cB, cA - cC). Equal states here represent valid subarrays, hence might require a higher order prefix array

*Target Average is X*
> Build the state as A[i] = A[i] - X centered around the average X

##### STEP - II (Subarray Condition)

###### Input
- Prefix array P
- Target T

###### Purpose
Evaluating the count of subarrays which satisfy a given rule F (sum = k, sum = 0, etc.), here sum to be equal to T

###### Technique
- Store the frequency of occurence of each prefix in a map M
- We know P<sub>r</sub> - P<sub>l</sub> = T is the rule to be followed, P<sub>l</sub> = P<sub>r</sub> - T
- Check happens before the update
- Initially 0 occurs once and evaluate P<sub>l</sub> as we are sliding the r boundary and want to check if there is any l that satisfies the rule F
- If rule F is satisfied, update the answer
- Keep updating the map M as we traverse

###### Output
Count of subarrays following the rule F

###### Variations

*Subarray sum = 0*
> Rule becomes sum = 0

*Subarray sum divisible by k*
> Rule becomes sum % k == 0, creates frequency map of size k

*Longest / Shortest Subarray of sum X*
> The technique now requires another map to store the earliest / latest index per prefix value. The technique then uses the value to extract difference of indices as distance

*Count of subarrays where the difference in count of two elements is k*
> Number of subarrays where n(A) - n(B) = k. Use the 0/1 technique of compuation and give the larger count as 1 and smaller count as -1, A -> 1 and B -> -1. The earlier step, will transform into sum array and then find sum of k.