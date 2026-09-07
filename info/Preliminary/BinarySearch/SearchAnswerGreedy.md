### Search Answer with Greedy

A pattern finding the feasible answer based on the fact that the search space is monotonic in predicate, and then the predicate is itself evaluated based on some greedy constraints

#### STEP - I (Binary Search)

##### Input
    - Data Array D1
    - Target T

##### Purpose
    - Finding the higher end answer from the search space given a rule F (<= T, >= T, T must be true) on T

##### Technique
    - First find the lower and upper range of the possible answer range A
    - The lower range and upper range can be like (max, sum), (min, max) (0, 1e9), etc.
    - Now use Binary Search BS on A
    - Evaluate the greedy predicate P when doing BS, the output if we are choosing the current value from A
    - Shift left and right pointers on the basis of monotonic greedy predicate P

##### Output
    - The best feasible answer for the rule F on target T

#### Variantions

##### Maximum Feasible Value
    - The rule F becomes <= T

##### Minimum Possible Value
    - The rule F becomes >= T

##### First value of the monotonic constraint
    - The problem gives a monotonic condition over T

##### Boundary Finding
    - The rule changes to finding the index at which the predicate changes values

#### STEP - II (Greedy Predicate)

##### Input
    - A target value X for predicate from binary search (not T)
    - The input data D1
    - Set of constraint parameter
    - A rule F applied over X

##### Purpose
    - The predicate determines the shifting of l and r values, and the predicates is mostly evaluated under O(n)

##### Technique
    - Greedily assort the D1 elements into buckets as per constraint
    - Ensure that none of the bucket violates rule F applied over X

##### Output
    - A boolean flag giving the output of the greedy predicate P

#### Variations

##### Capacity based feasibility (Fill until violation)
    - Given target X, assign elements into k buckets such that the capacity doesn't exceed X

##### Partition Allocation (Greedy grouping)
    - Greedily allocate continuous groups such that cost(group) <= T
    - The technique will need to store the count of parititions

##### Maximize Minimum Distance (Place earliest)
    - Treat D1 elements as stall and K objects, such that the min distance between any two objects is max
    - The technique places first object at earliest position
    - Then the technique places the subsequent object >= X (target value for predicate)

##### Group Creation (Counting without buckets)
    - The problem now asks about creating groups with a certain rule F (<= k, etc.)
    - The technique doesn't create buckets but a counter to count the groups

##### Pairing Predicate (Select as many as possible)
    - The rule changes to count of pairs of elements with difference Z or a certain rule on Z
    - We sort the D1 such that evaluating elements for pairs or combinatorics becomes easier
    - The technique might use MOD if numbers grow large