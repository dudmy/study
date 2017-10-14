# MaxDoubleSliceSum

Find the maximal sum of any double slice.

## Task description

A non-empty zero-indexed array A consisting of N integers is given.

A triplet (X, Y, Z), such that 0 ≤ X < Y < Z < N, is called a double slice.

The sum of double slice (X, Y, Z) is the total of A[X + 1] + A[X + 2] + ... + A[Y − 1] + A[Y + 1] + A[Y + 2] + ... + A[Z − 1].

For example, array A such that:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2

contains the following example double slices:

* double slice (0, 3, 6), sum is 2 + 6 + 4 + 5 = 17,
* double slice (0, 3, 7), sum is 2 + 6 + 4 + 5 − 1 = 16,
* double slice (3, 4, 5), sum is 0.

The goal is to find the maximal sum of any double slice.

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given a non-empty zero-indexed array A consisting of N integers, returns the maximal sum of any double slice.

For example, given:

    A[0] = 3
    A[1] = 2
    A[2] = 6
    A[3] = -1
    A[4] = 4
    A[5] = 5
    A[6] = -1
    A[7] = 2

the function should return 17, because no double slice of array A has a sum of greater than 17.

Assume that:

* N is an integer within the range [3..100,000];
* each element of array A is an integer within the range [−10,000..10,000].

Complexity:

* expected worst-case time complexity is O(N);
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N)
* Code

```java
class Solution {
    public int solution(int[] A) {
        if (A.length == 3)
            return 0;
            
        int[] sumLeft = new int[A.length];
        int[] sumRight = new int[A.length];

        int maxEnding = 0;
        for (int i = 1; i < A.length - 1; i++) {
            maxEnding = sumLeft[i - 1];
            sumLeft[i] = Math.max(0, maxEnding + A[i]);
        }
        
        maxEnding = 0;
        for (int i = A.length - 2; i > 0; i--) {
            maxEnding = sumRight[i - 1];
            sumRight[i] = Math.max(0, sumRight[i + 1] + A[i]);
        }
        
        int maxSum = 0;
        for (int Y = 1; Y < A.length - 1; Y++)
            maxSum = Math.max(maxSum, sumLeft[Y - 1] + sumRight[Y + 1]);
        
        return maxSum;
    }
}
```

## Comment

PDF 자료에 있는 golden_max_slice 함수를 참고하여 풀어보았다. 중간에 쓸데없이 삽질하는 시간을 줄여야 할 텐데...
