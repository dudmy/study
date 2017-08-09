# MaxCounters

Calculate the values of counters after applying all alternating operations: increase counter by 1; set value of all counters to current maximum.

## Task description

You are given N counters, initially set to 0, and you have two possible operations on them:

* increase(X) − counter X is increased by 1,
* max counter − all counters are set to the maximum value of any counter.

A non-empty zero-indexed array A of M integers is given. This array represents consecutive operations:

* if A[K] = X, such that 1 ≤ X ≤ N, then operation K is increase(X),
* if A[K] = N + 1 then operation K is max counter.

For example, given integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4

the values of the counters after each consecutive operation will be:

    (0, 0, 1, 0, 0)
    (0, 0, 1, 1, 0)
    (0, 0, 1, 2, 0)
    (2, 2, 2, 2, 2)
    (3, 2, 2, 2, 2)
    (3, 2, 2, 3, 2)
    (3, 2, 2, 4, 2)

The goal is to calculate the value of every counter after all operations.

Write a function:

```java
class Solution { public int[] solution(int N, int[] A); }
```

that, given an integer N and a non-empty zero-indexed array A consisting of M integers, returns a sequence of integers representing the values of the counters.

The sequence should be returned as:

* a structure Results (in C), or
* a vector of integers (in C++), or
* a record Results (in Pascal), or
* an array of integers (in any other programming language).

For example, given:

    A[0] = 3
    A[1] = 4
    A[2] = 4
    A[3] = 6
    A[4] = 1
    A[5] = 4
    A[6] = 4

the function should return [3, 2, 2, 4, 2], as explained above.

Assume that:

* N and M are integers within the range [1..100,000];
* each element of array A is an integer within the range [1..N + 1].

Complexity:

* expected worst-case time complexity is O(N+M);
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 77%
  - Correctness: 100%
  - Performance: 60%
* Analysis
  - The following issues have been detected: timeout errors.
* Code

```java
class Solution {
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int max = 0;
        int pos;
        
        for (int element : A) {
            if (element <= N) {
                pos = element - 1;
                result[pos] += 1;
                if (result[pos] > max) max = result[pos];
            } else {
                for (int i = 0; i < result.length; i++) result[i] = max;
            }
        }
        
        return result;
    }
}
```

### Second

* Programming language: Java
* Task score: 88%
  - Correctness: 100%
  - Performance: 80%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N + M)
* Code

```java
class Solution {
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int maxValue = 0;
        int maxCounter = 0;
        int pos;
        
        for (int element : A) {
            if (element <= N) {
                pos = element - 1;
                result[pos] += 1;
                maxValue = Math.max(maxValue, result[pos] + maxCounter);
            } else {
                maxCounter = maxValue;
                result = new int[N];
            }
        }
        
        for (int i = 0; i < result.length; i++) result[i] += maxCounter; 
        
        return result;
    }
}
```

### Third

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N + M)
* Code

```java
class Solution {
    public int[] solution(int N, int[] A) {
        int[] result = new int[N];
        int maxValue = 0;
        int maxCounter = 0;
        int pos;
        
        for (int element : A) {
            if (element <= N) {
                pos = element - 1;
                result[pos] = Math.max(maxCounter + 1, result[pos] + 1);
                maxValue = Math.max(maxValue, result[pos]);
            } else {
                maxCounter = maxValue;
            }
        }
        
        for (int i = 0; i < result.length; i++) result[i] = Math.max(maxCounter, result[i]); 
        
        return result;
    }
}
```

## Comment

이번 문제는 score 100% 달생하는데 정확도보다 퍼포먼스로 인해 시간이 오래 걸렸다. 배열을 초기화하는 방법으로 풀이하면 timeout 에러로 실패했기 때문에 다른 방법을 찾아야 했다.
