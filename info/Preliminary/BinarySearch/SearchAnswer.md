### Search Answer

A pattern finding the feasible answer based on the fact that the search space is monotonic in predicate

#### STEP - I (Binary Search)

##### Input
    - Data Array D1
    - Target T

##### Purpose
    - Finding the higher end answer from the search space given a rule F (<= T, >= T, T must be true) on T

##### Technique
    - First find the lower and upper range of the possible answer range A
    - Now use Binary Search BS on A
    - Evaluate the predicate P when doing BS, the output if we are choosing the current value from A
    - Shift left and right pointers on the basis of monotonic P

##### Output
    - The best feasible answer for the rule F on target T

#### Variantions

##### Maximum Feasible Value
    - The rule F becomes <= T

##### Minimum Possible Value
    - The rule F becomes >= T

##### Max / Min value satisfying a constraint
    - The constraint C is also taken into account when evaluating the predicate

##### Capacity based feasibility
    - Can N workers work under X resources
    - The technique introduces another greedy O(N) algorithm when evaluating predicate P

##### Partition allocation
    - Can D1 data be split into N groups following the constraint C
    - The technique introduces another greedy O(N) algorithm when evaluating predicate P
