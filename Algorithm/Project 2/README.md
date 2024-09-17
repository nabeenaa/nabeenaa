
# Algorithm and Data Structure Implementations

## Project Overview
This repository contains implementations of various algorithms and data structures, focusing on sorting and resource management in a grid-based problem. The project is divided into two main tasks:

1. **Mergesort Variations**: Implementation of different variations of the Mergesort algorithm, including merging two, three, and multiple arrays, as well as recursive sorting with varying levels of granularity.
2. **Digger Problem**: A recursive solution to find the maximum resources collectible by a digger navigating through a grid map, with an optimized version using memoization.

## Task 1: Mergesort Variations

### Task 1.1: Merge
**Description**: Implements a method to merge two sorted integer arrays into one sorted array.
- **Method**: `merge(int[] a, int[] b)`
- **Parameters**: 
  - `a`: First sorted array.
  - `b`: Second sorted array.
- **Returns**: Merged sorted array.
- **Approach**: Uses two pointers to compare elements from both arrays and merge them into a new array.

### Task 1.2: Mergesort
**Description**: Implements the standard Mergesort algorithm that recursively sorts an array by dividing it into halves and merging the sorted halves.
- **Method**: `mergesort(int[] arr)`
- **Parameters**:
  - `arr`: Array to be sorted.
- **Returns**: Sorted array.
- **Approach**: Recursively divides the array into halves, sorts each half, and merges them.

### Task 1.3: Merge3
**Description**: Implements a method to merge three sorted integer arrays into one sorted array.
- **Method**: `merge3(int[] a, int[] b, int[] c)`
- **Parameters**:
  - `a`, `b`, `c`: Three sorted arrays to be merged.
- **Returns**: Merged sorted array.
- **Approach**: Uses multiple pointers to compare elements from three arrays and merge them into a new array.

### Task 1.4: Mergesort3
**Description**: Implements a variation of Mergesort that divides the array into three parts, sorts each part recursively, and merges them using `merge3`.
- **Method**: `mergesort3(int[] arr)`
- **Parameters**:
  - `arr`: Array to be sorted.
- **Returns**: Sorted array.
- **Approach**: Divides the array into three segments, recursively sorts each segment, and merges them.

### Task 1.5: MergeAll
**Description**: Implements a method to merge an arbitrary number of sorted integer arrays into one sorted array.
- **Method**: `mergeAll(int[][] arrays)`
- **Parameters**:
  - `arrays`: Array of sorted arrays to be merged.
- **Returns**: Merged sorted array.
- **Approach**: Concatenates all arrays into one and sorts the concatenated array.

### Task 1.6: MergesortK
**Description**: Implements a generalized Mergesort that divides the array into `K` parts, sorts each part recursively, and merges them using `mergeAll`.
- **Method**: `mergesortK(int[] arr, int k)`
- **Parameters**:
  - `arr`: Array to be sorted.
  - `k`: Number of parts to divide the array into.
- **Returns**: Sorted array.
- **Approach**: Divides the array into `K` segments, recursively sorts each segment, and merges them.

## Task 2: Digger Problem

### Task 2.1: Recursive maxResources
**Description**: Implements a recursive method to calculate the maximum resources that can be collected by a digger navigating through a grid.
- **Method**: `maxResources(int[][] grid)`
- **Parameters**:
  - `grid`: A 2D integer array representing the grid map of resources.
- **Returns**: Maximum resources collectible in one run.
- **Approach**: Uses recursion to explore the maximum resources by moving diagonally left-down or right-down.

### Task 2.2: Memoized maxResources
**Description**: Optimizes the `maxResources` method by adding memoization to improve performance for larger grids.
- **Method**: `maxResourcesM(int[][] grid)`
- **Parameters**:
  - `grid`: A 2D integer array representing the grid map of resources.
- **Returns**: Maximum resources collectible in one run.
- **Approach**: Stores results of previously computed states to avoid redundant calculations and speed up the solution.


## Testing

Testing involves verifying the correctness and performance of each method:
1. **Unit Tests**: Test each method with various inputs to ensure correctness.
2. **Edge Cases**: Test with edge cases such as empty arrays, single-element arrays, and large inputs.
3. **Performance**: Measure the performance of recursive and memoized solutions for large grids.

## Conclusion

This repository demonstrates proficiency in implementing various sorting algorithms and solving complex problems using recursion and memoization. The provided methods cover a range of sorting techniques and optimization strategies for handling large datasets effectively.

