### Resource Allocation

A pattern of allocating resources to a given set of queries, the problem asks for allocating based on a certain rule.

#### STEP - I (Allocation)

##### Input
    - Queries Array Q1
    - Data Array D1

##### Purpose
    - Find the best feasible data D<sub>i</sub> for each query Q<sub>i</sub> on the basis of a certain rule F (less than, greater than, etc.)

##### Technique
    - First prove that the question is greedy
    - Use ordered frequency map or TreeMap TM to effectively store D1 with count in order
    - Pick Q1 elements and start mapping on basis of rule F
    - Remember to update count and remove empty slots from TM
    - Use sentinel values whenever necessary

##### Output
    - An array containing best feasible data for each query Q<sub>i</sub> on basis of rule F

#### Variantions

##### Floor Allocation
    - The rule F becomes D<sub>i</sub> <= Q<sub>i</sub>

##### Ceil Allocation
    - The rule F becomes D<sub>i</sub> >= Q<sub>i</sub>

##### Nearest Allocation
    - The rule F becomes | D<sub>i</sub> - Q<sub>i</sub>
    - Depending on the problem the ties may prefer smaller, larger, earlier, cheaper
    - Technique adds finding floor, ceil and then compare

##### Allocation without Consumption
    - Technique adds not updating the TM

##### Allocation with group capacity
    - The query comes as a group Q<sub>G</sub>, else it is rejected
    - Technique adds using a state to remember the changes, if any query of the group Q<sub>G1</sub> fails, fail the group

##### Multi-dimensional Allocation
    - The query doesn't have one data, but multiple data (DA, DB, etc)
    - The technique uses different TM for each data