# CountFactors

Count factors of given number n.

## Task description

A positive integer D is a factor of a positive integer N if there exists an integer M such that N = D * M.

For example, 6 is a factor of 24, because M = 4 satisfies the above condition (24 = 6 * 4).

Write a function:

```java
class Solution { public int solution(int N); }
```

that, given a positive integer N, returns the number of its factors.

For example, given N = 24, the function should return 8, because 24 has 8 factors, namely 1, 2, 3, 4, 6, 8, 12, 24. There are no other factors of 24.

Assume that:

* N is an integer within the range [1..2,147,483,647].

Complexity:

* expected worst-case time complexity is O(sqrt(N));
* expected worst-case space complexity is O(1).

## Solution

### First

* Programming language: Java
* Task score: 92%
  - Correctness: 100%
  - Performance: 83%
* Analysis
  - The following issues have been detected: timeout errors. For example, for the input 2147483647 the solution exceeded the time limit.
  - Detected time complexity: O(sqrt(N))
* Code

```java
class Solution {
    public int solution(int N) {
        int i = 1;
        int cntFactor = 0;
        
        while (i * i < N) {
            if (N % i == 0)
                cntFactor += 2;
            i++;
        }
        
        if (i * i == N)
            cntFactor++;
            
        return cntFactor;
    }
}
```

### Second

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(sqrt(N))
* Code

```java
class Solution {
    public int solution(int N) {
        int i = 1;
        int cntFactor = 0;
        
        while (i < Math.sqrt(N)) {
            if (N % i == 0)
                cntFactor += 2;
            i++;
        }
        
        if (i * i == N)
            cntFactor += 1;

        return cntFactor;
    }
}
```

## Comment

PDF 자료에 있는 10.1 Counting the number of divisors 를 이용해서 해봤는데, N = MAX_INT 일 때 타임아웃 에러가 떴다. 그래서 Math.sqrt() 메소드를 이용해서 돌려봤더니 문제없이 통과했다. i * i < N 대신 i < Math.sqrt(N) 으로 계산하는 게 퍼포먼스에 영향을 줄 만큼 차이가 큰가?
