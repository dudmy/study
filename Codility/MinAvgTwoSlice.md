# MinAvgTwoSlice

Find the minimal average of any slice containing at least two elements.

## Task description

A non-empty zero-indexed array A consisting of N integers is given. A pair of integers (P, Q), such that 0 ≤ P < Q < N, is called a slice of array A (notice that the slice contains at least two elements). The average of a slice (P, Q) is the sum of A[P] + A[P + 1] + ... + A[Q] divided by the length of the slice. To be precise, the average equals (A[P] + A[P + 1] + ... + A[Q]) / (Q − P + 1).

For example, array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

contains the following example slices:

* slice (1, 2), whose average is (2 + 2) / 2 = 2;
* slice (3, 4), whose average is (5 + 1) / 2 = 3;
* slice (1, 4), whose average is (2 + 2 + 5 + 1) / 4 = 2.5.

The goal is to find the starting position of a slice whose average is minimal.

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given a non-empty zero-indexed array A consisting of N integers, returns the starting position of the slice with the minimal average. If there is more than one slice with a minimal average, you should return the smallest starting position of such a slice.

For example, given array A such that:

    A[0] = 4
    A[1] = 2
    A[2] = 2
    A[3] = 5
    A[4] = 1
    A[5] = 5
    A[6] = 8

the function should return 1, as explained above.

Assume that:

* N is an integer within the range [2..100,000];
* each element of array A is an integer within the range [−10,000..10,000].

Complexity:

* expected worst-case time complexity is O(N);
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 60%
  - Correctness: 100%
  - Performance: 20%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N ** 2)
* Code

```java
class Solution {
    public int solution(int[] A) {
        float dividend, divisor;
        float ave = A.length;
        int result = 0;

        for (int i = 0; i < A.length - 1; i++) {
            dividend = A[i];

            for (int j = i + 1; j < A.length; j++) {
                dividend += A[j];
                divisor = j - i + 1;

                float temp = dividend / divisor;

                if (ave > temp) {
                    ave = temp;
                    result = i;
                }
            }
        }

        return result;
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
        int result = 0;
        float min = (A[0] + A[1]) / 2f;

        for (int i = 2; i < A.length; i++) {
            float ave2 = (A[i] + A[i - 1]) / 2f;
            if (min > ave2) {
                min = ave2;
                result = i - 1;
            }
            
            float ave3 = (A[i] + A[i - 1] + A[i - 2]) / 3f;
            if (min > ave3) {
                min = ave3;
                result = i - 2;
            }
        }

        return result;
    }
}
```

## Comment

이 문제는 마지막까지 완벽하게 풀지 못했다. 시간복잡도로 인해 퍼포먼스 100% 달성에 실패했는데, 다른 답들을 살펴봐도 이해가 제대로 되지는 않았다. 최소 평균 slice의 길이는 3보다 길 수 없으므로 길이가 2와 3인 실라이스의 평균만 계산하면 된다는 것이다. 예제로 주어진 배열에 대한 결과 또한 slice (1, 2)가 최소 평균으로 길이가 2이다. 물론 느낌적으로 그럴 것 같다고 생각은 들지만, 이를 확실히 이해하려면 수학적 증명을 살펴봐야 한다.