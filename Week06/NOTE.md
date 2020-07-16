# Week 5 Study Note
## Dynamic Programming
Dynamic Programming is mainly an optimization over plain recursion. Wherever we see a recursive solution that has repeated calls for same inputs, we can optimize it using **Dynamic Programming**. 

The idea is to simply store the results of subproblems, so that we do not have to re-compute them when needed later. 

This simple optimization reduces time complexities from exponential to polynomial. 

For example, if we write simple recursive solution for Fibonacci Numbers, we get exponential time complexity and if we optimize it by storing solutions of subproblems, time complexity reduces to linear.

![dp1](Assets/DP_1.png)

> Sample Problems:
> |  Problem  | Status |
> |--------- |------- |
> |[Fibonacci Number](https://leetcode.com/problems/fibonacci-number/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=brightgreen&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/DP/509.fibonacci-number.java) |
> |[Climbing Stairs](https://leetcode.com/problems/climbing-stairs/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=brightgreen&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/DP/70.climbing-stairs.java)
> |[Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/) | [![View](https://img.shields.io/static/v1?label=View%20My%20Solution&message=√&color=brightgreen&style=?style=for-the-badge&logo=Github)](https://github.com/Fettes/Coding-Exercise/blob/master/DP/746.min-cost-climbing-stairs.java)


## Dynamic Programming *vs* Divide & Conquer
- Actually no obvious difference. In both contexts it refers to simplifying a complicated problem by breaking it down into simpler sub-problems in a recursive manner. 
- If a problem can be solved optimally by breaking it into sub-problems and then recursively finding the optimal solutions to the sub-problems, then it is said to have **optimal substructure**. We can call it **Dynamic Programming**.
- While some decision problems cannot be taken apart this way, which means we need to solve all the sub-problems. Thus, we call it **Divide & Conquer**.