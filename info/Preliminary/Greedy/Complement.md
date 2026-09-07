### Complement

A pattern for finding whether two elements from a data follow a perspective property or not.

#### STEP - I (Complement)

##### Input
    - Data array D1
    - Target T

##### Purpose
    - Find count or validate elements D<sub>i</sub> and D<sub>j</sub> where F(D<sub>i</sub>, D<sub>j</sub>) = T and the relationship F determines the required complement

##### Technique
    - For current element D<sub>i</sub> evaluate Complement D'<sub>i</sub>, such that F(D<sub>i</sub>, D'<sub>i</sub>) = T
    - The problem becomes about checking whether D'<sub>i</sub> has been seen previously from D1
    - Use Map M to store either index, earliest index, frequency, etc. as per the constraint of the problem

##### Output
    - A pair or an empty pair

#### Variantions

##### Pair Existence
    - Checks if pairs exist or not, also values or indices as per appropriate
    - In technique, if checking use Set S, otherwise use Map M

##### Count
    - Count pairs that satisfy the condition F(D<sub>i</sub>, D'<sub>i</sub>) = T

##### Longest Pair
    - The longest valid pair that satisfies the constraint
    - In technique, use Map M to store earliest occurence