### Piecewise Function Queries

A pattern for turning a function over a large range or coordinates into constant interval ranges and storing as compressed data, cumulating them and then using this data to effectively solve queries

#### STEP - I (Building Breakpoints)

##### Input
    Data D (area, array, etc.)
    Rule F which determines where the data will change, might not be available in some cases

##### Purpose
    Find breakpoints or the segments where the data is constant and hence can be compressed and represented as an individual

##### Technique
    Identify all changing breakpoints into an array X (use the given function or logic to figure the breakpoints)
    Sort the breakpoints and treat (X[i], X[i+1]) as single interval of constant data
    Store the rule F for that interval in array Y

##### Output
    Gives an array of sorted breakpoints X and interval value array Y

#### Variations

##### Divisor
    The breakpoints are divisors or factorisation of Data D (can be a area, etc.)

##### Events
    The breakpoints occur because of an Event E (can be a function, or list of events, etc.)

##### Coordinate Compression
    The breakpoints come from coordinates (can be a polygon vertices, a list of coordinates, etc.)

##### Mathematical
        The breakpoints are derived from functions (can be floor, ceil, intersections, geometrical and polynomial functions, etc.)

#### STEP - II (Prefix Computation)

##### Input
        Breakpoint array X
        Rule value F for each interval in array Y (Interval value array)

##### Purpose
        Perform preprocessing such that large ranges need not be computed

##### Technique
        For each interval, evaluate contribution C as (X[i+1] - X[i]) x Y[i]
        Build Cumulative Contribution across intervals P<sub>C</sub> via cumulation function F

##### Output
        Prefix Contribution Array P for Breakpoint array X and interval value array Y

#### Variations

##### Prefix Sums
        Cumulation function F is prefix sums or C[i]

##### Prefix Area
        Cumulation function F is prefix area (l x b)

##### Weighted Contribution
        Cumulation function F follows another interval function Z

##### Range Contribution
        Cumulation Function F follows range(l, r) = C[r] - C[l]

#### STEP - III (Query by Segment)

##### Input
        Query Q
        Breakpoint array X
        Interval value array Y
        Prefix Contribution array P

##### Purpose
        Finding the interval or range of intervals containing the query without scanning all intervals

##### Technique
        Use binary search (upper bound / lower bound) to figure out the relevant breakpoint B, or the starting B0 and ending B1 breakpoints
        Apply the query specific boundary range Q
        Use the prefix Contribution array P to take only the value from the range Q and remove the unnecessary contributions

##### Output
        Query answer in O(log n)

#### Variations

##### Point Boundary Query
        Query Q is finding Rule F or Contribution upto point A

##### Range Query
        Query Q is finding Rule F or Contribution upto range [l, r]

##### Capped Query
        Query Q uses Rule F as a max or min

##### Intersection Query
        Query Q uses intersection of Areas
