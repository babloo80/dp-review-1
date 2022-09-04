# Dynamic Programming Review

DP is generally solved with
- recursion
- recursion + memoization
- tabulation

## Recursion
Recursion is a way of DP program solving with more concise but complex code. At times, it takes more CPU cycles for execution.

## Recursion + Memoization
Recursion + Memoization is a way of DP program solving with recursion and reducing repeatitive computation using memorization. 

## Tabulation 
Tabulation takes extra space but provides more readable implementation of problem solving.

Typically, the base-case is setup with default value and the table is evaluated in an expected order.

## Content
The problems here are based on https://www.youtube.com/watch?v=oBt53YbR9Kk. 
The original videos are based on Javascript. This implementation is based on Scala (though less functional in nature as the intent of the program is to learn the technique and make it less terse from FP).

Java could have been another choice of implementation but would turn out to be more verbose. Javascript is a fine language to write, but is not type-safe and efficient. 
