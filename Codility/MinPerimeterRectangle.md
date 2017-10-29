# MinPerimeterRectangle

Find the minimal perimeter of any rectangle whose area equals N.

## Task description

An integer N is given, representing the area of some rectangle.

The area of a rectangle whose sides are of length A and B is A * B, and the perimeter is 2 * (A + B).

The goal is to find the minimal perimeter of any rectangle whose area equals N. The sides of this rectangle should be only integers.

For example, given integer N = 30, rectangles of area 30 are:

* (1, 30), with a perimeter of 62,
* (2, 15), with a perimeter of 34,
* (3, 10), with a perimeter of 26,
* (5, 6), with a perimeter of 22.

Write a function:

```java
class Solution { public int solution(int N); }
```

that, given an integer N, returns the minimal perimeter of any rectangle whose area is exactly equal to N.

For example, given an integer N = 30, the function should return 22, as explained above.

Assume that:

* N is an integer within the range [1..1,000,000,000].

Complexity:

* expected worst-case time complexity is O(sqrt(N));
* expected worst-case space complexity is O(1).

## Solution

### First

* Programming language: Java
* Task score: 80%
  - Correctness: 100%
  - Performance: 60%
* Analysis
  - The following issues have been detected: timeout errors. For example, for the input 15486451 the solution exceeded the time limit.
  - Detected time complexity: O(sqrt(N))
* Code

```java
class Solution {
    public int solution(int N) {
        int a = 1;
        int b = N;
        
        while (a < b) {
            a++;
            
            if (N % a == 0)
                b = N / a;
        }
        
        return 2 * ((N / b) + b);
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
        int a = 1;
        int b = N;
        
        while (a * a < N) {
            a++;
            
            if (N % a == 0)
                b = N / a;  
        }
        
        return 2 * ((N / b) + b);
    }
}
```

## Comment

루프가 도는 조건을 어떻게 설정하는지가 퍼포먼스에 큰 영향을 끼친다. 불필요한 검증을 최대한 걸러내는 것이 중요하다.
