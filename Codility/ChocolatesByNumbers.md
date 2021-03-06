# ChocolatesByNumbers

There are N chocolates in a circle. Count the number of chocolates you will eat.

## Task description

Two positive integers N and M are given. Integer N represents the number of chocolates arranged in a circle, numbered from 0 to N − 1.

You start to eat the chocolates. After eating a chocolate you leave only a wrapper.

You begin with eating chocolate number 0. Then you omit the next M − 1 chocolates or wrappers on the circle, and eat the following one.

More precisely, if you ate chocolate number X, then you will next eat the chocolate with number (X + M) modulo N (remainder of division).

You stop eating when you encounter an empty wrapper.

For example, given integers N = 10 and M = 4. You will eat the following chocolates: 0, 4, 8, 2, 6.

The goal is to count the number of chocolates that you will eat, following the above rules.

Write a function:

```java
class Solution { public int solution(int N, int M); }
```

that, given two positive integers N and M, returns the number of chocolates that you will eat.

For example, given integers N = 10 and M = 4. the function should return 5, as explained above.

Assume that:

* N and M are integers within the range [1..1,000,000,000].

Complexity:

* expected worst-case time complexity is O(log(N+M));
* expected worst-case space complexity is O(log(N+M)).

## Solution

### First

* Programming language: Java
* Task score: 62%
  - Correctness: 100%
  - Performance: 25%
* Analysis
  - The following issues have been detected: runtime errors. For example, for the input (1000000000, 1) the solution terminated unexpectedly.
  - Detected time complexity: O(N + M)
* Code

```java
class Solution {
    public int solution(int N, int M) {
        boolean[] isChecked = new boolean[N];
        
        int num = 0;
        int count = 0;
        
        while (true) {
            num = (num + M) % N;
            
            if (isChecked[num]) {
                break;
            } else {
                isChecked[num] = true;
                count++;
            }
        }
        
        return count;
    }
}
```

### Second

* Programming language: Java
* Task score: 87%
  - Correctness: 100%
  - Performance: 75%
* Analysis
  - The following issues have been detected: runtime errors. For example, for the input (1000000000, 1) the solution terminated unexpectedly.
  - Detected time complexity: O(log(N + M))
* Code

```java
class Solution {
    public int solution(int N, int M) {
        // Number of chococlates that I will eat.
        return N / gcdBySubtraction(N, M);
    }
    
    // Euclidean algorithm - Greatest common divisor by subtraction.
    public int gcdBySubtraction(int a, int b) {
        if (a == b) {
            return a;
        } else if (a > b) {
            return gcdBySubtraction(a - b, b);
        } else {
            return gcdBySubtraction(a, b - a);
        }
    }
}
```

### Third

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(log(N + M))
* Code

```java
class Solution {
    public int solution(int N, int M) {
        // Number of chococlates that I will eat.
        return N / gcdByDivision(N, M);
    }
    
    // Euclidean algorithm - Greatest common divisor by dividing.
    public int gcdByDivision(int a, int b) {
        if (a % b == 0) {
            return b;
        } else {
            return gcdByDivision(b, a % b);
        }
    }
}
```

## Comment

주어진 두 수 사이에 존재하는 최대공약수(Greatest Common Divisor)를 구하는 유클리드 알고리즘을 이용하면 풀 수 있다. 주어진 문제에 어떠한 알고리즘을 이용해야 하는지 빨리 파악하는게 중요한 것 같다.
