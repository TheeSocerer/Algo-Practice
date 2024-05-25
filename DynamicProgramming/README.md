# Dynamic Programming Algorithms

This README provides an overview of dynamic programming algorithms, including the Fibonacci sequence calculation with memoization, the Grid Traveler problem with memoization, and credits to FreeCodeCamp for their tutorial on dynamic programming. 🚀

## Fibonacci Memoization

The Fibonacci sequence is a series of numbers where each number is the sum of the two preceding ones. The `fib` method calculates the nth Fibonacci number recursively, with memoization for optimization.

### Time Complexity

1. **Without Memoization**: Exponential time complexity O(2^n).
2. **With Memoization**: Linear time complexity O(n).

### Memory Usage

1. **Without Memoization**: Exponential memory usage.
2. **With Memoization**: Linear memory usage O(n).

Memoization significantly improves both time complexity and memory usage by eliminating redundant calculations.

## Grid Traveler Memoization

The Grid Traveler problem involves moving from the top-left corner of a grid to the bottom-right corner, with only down or right movements allowed. The task is to count the number of possible paths. Memoization can be applied to optimize this problem.

### Time Complexity

1. **Without Memoization**: Exponential time complexity O(2^n+m).
2. **With Memoization**: time complexity O(m*n).

### Memory Usage

1. **Without Memoization**: Linear memory usage O(n+m).
2. **With Memoization**: Linear memory usage O(n+m).

## Credits

Credit goes to FreeCodeCamp for their tutorial on dynamic programming. You can watch the tutorial [here](https://youtu.be/oBt53YbR9Kk).

## Conclusion

Dynamic programming algorithms offer efficient solutions to various computational problems by storing and reusing subproblem solutions. By optimizing recursive algorithms with techniques like memoization, dynamic programming improves both time and memory efficiency, making it a powerful tool for algorithm design and optimization. ✨
