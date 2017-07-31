# TapeEquilibrium

Minimize the value |(A[0] + ... + A[P-1]) - (A[P] + ... + A[N-1])|.

## Task description

A non-empty zero-indexed array A consisting of N integers is given. Array A represents numbers on a tape.

Any integer P, such that 0 < P < N, splits this tape into two non-empty parts: A[0], A[1], ..., A[P − 1] and A[P], A[P + 1], ..., A[N − 1].

The difference between the two parts is the value of: |(A[0] + A[1] + ... + A[P − 1]) − (A[P] + A[P + 1] + ... + A[N − 1])|

In other words, it is the absolute difference between the sum of the first part and the sum of the second part.

For example, consider array A such that:

  A[0] = 3  A[1] = 1  A[2] = 2  A[3] = 4  A[4] = 3

We can split this tape in four places:

* P = 1, difference = |3 − 10| = 7 
* P = 2, difference = |4 − 9| = 5 
* P = 3, difference = |6 − 7| = 1 
* P = 4, difference = |10 − 3| = 7 

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given a non-empty zero-indexed array A of N integers, returns the minimal difference that can be achieved.

For example, given:

  A[0] = 3  A[1] = 1  A[2] = 2  A[3] = 4  A[4] = 3

the function should return 1, as explained above.

Assume that:

* N is an integer within the range [2..100,000];
* each element of array A is an integer within the range [−1,000..1,000].

Complexity:

* expected worst-case time complexity is O(N);
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 41%
  - Correctness: 33%
  - Performance: 50%
* Analysis
  - The following issues have been detected: wrong answers.
* Code

```java
class Solution {
    public int solution(int[] A) {
        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        
        int minDiff = sum;
        int first = 0, second = 0, diff = 0;
        
        for (int P = 1; P < A.length; P++) {
            first += A[P - 1];
            second = sum - first;
            diff = Math.abs(first - second);
            
            if (minDiff > diff) {
                minDiff = diff;   
            }
        }
        
        return minDiff;
    }
}
```

### Second 

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N)
* Code

```java
class Solution {
    public int solution(int[] A) {
        int sum = 0;
        for (int value : A) {
            sum += value;
        }
        
        int minDiff = Integer.MAX_VALUE;
        int first = 0, second = 0, diff = 0;
        
        for (int P = 1; P < A.length; P++) {
            first += A[P - 1];
            second = sum - first;
            diff = Math.abs(first - second);
            
            if (minDiff > diff) {
                minDiff = diff;   
            }
        }
        
        return minDiff;
    }
}
```

### Third 

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N)
* Code

```java
class Solution {
    public int solution(int[] A) {
        int minDiff = Integer.MAX_VALUE;
        int first = 0, second = 0;
        
        for (int value : A) {
            second += value;
        }
        
        for (int P = 1; P < A.length; P++) {
            first += A[P - 1];
            second -= A[P - 1];
            minDiff = Math.min(minDiff, Math.abs(first - second));
        }
        
        return minDiff;
    }
}
```

### Comment

첫 번째 풀이에서 올바르게 작성했다고 생각했는데 퍼포먼스가 아닌 정확도로 인해 답이 틀렸다고 나왔다. 계속된 삽질의 결과 minDiff의 초깃값을 잘 못 설정했다는 것을 알게 됐다. 주어진 배열 A의 element 범위를 고려하지 않고, 배열의 총합은 양수일 거라고 가정을 한 것이 문제이다. 그래서 minDiff를 Integer의 최댓값으로 놓고 다시 돌려보니 통과했다. 이러한 실수를 줄여나가야 하는데 계속 반복하게 된다. :(