# CyclicRotation

Rotate an array to the right by a given number of steps.

## Task description

A zero-indexed array A consisting of N integers is given. Rotation of the array means that each element is shifted right by one index, and the last element of the array is also moved to the first place.

For example, the rotation of array A = [3, 8, 9, 7, 6] is [6, 3, 8, 9, 7]. The goal is to rotate array A K times; that is, each element of A will be shifted to the right by K indexes.

Write a function:

```java
class Solution { public int[] solution(int[] A, int K); }
```

that, given a zero-indexed array A consisting of N integers and an integer K, returns the array A rotated K times.

For example, given array A = [3, 8, 9, 7, 6] and K = 3, the function should return [9, 7, 6, 3, 8].

Assume that:

* N and K are integers within the range [0..100];
* each element of array A is an integer within the range [−1,000..1,000].

In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.

## Solution

### First

* Programming language: Java
* Task score: 100%
* Analysis summary: The solution obtained perfect score.
* Code

```java
class Solution {
    public int[] solution(int[] A, int K) {
        int[] result = new int[A.length];
        int rotateIdx;
        
        for (int i = 0; i < A.length; i++) {
            rotateIdx = (i + K) % A.length;
            result[rotateIdx] = A[i];
        }
        
        return result;
    }
}
```

## Comment

더는 방법이 떠오르지 않을 때, 이게 최선일까 라는 생각이 든다. 다른 사람의 코드를 참고할 타이밍을 정하는 게 어렵다.
