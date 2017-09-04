# MaxProductOfThree

Maximize A[P] * A[Q] * A[R] for any triplet (P, Q, R).

## Task description

A non-empty zero-indexed array A consisting of N integers is given. The product of triplet (P, Q, R) equates to A[P] * A[Q] * A[R] (0 ≤ P < Q < R < N).

For example, array A such that:

    A[0] = -3
    A[1] = 1
    A[2] = 2
    A[3] = -2
    A[4] = 5
    A[5] = 6

contains the following example triplets:

* (0, 1, 2), product is −3 * 1 * 2 = −6
* (1, 2, 4), product is 1 * 2 * 5 = 10
* (2, 4, 5), product is 2 * 5 * 6 = 60

Your goal is to find the maximal product of any triplet.

Write a function:

```
class Solution { public int solution(int[] A); }
```

that, given a non-empty zero-indexed array A, returns the value of the maximal product of any triplet.

For example, given array A such that:

    A[0] = -3
    A[1] = 1
    A[2] = 2
    A[3] = -2
    A[4] = 5
    A[5] = 6

the function should return 60, as the product of triplet (2, 4, 5) is maximal.

Assume that:

* N is an integer within the range [3..100,000];
* each element of array A is an integer within the range [−1,000..1,000].

Complexity:

* expected worst-case time complexity is O(N*log(N));
* expected worst-case space complexity is O(1), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 55%
    - Correctness: 50%
    - Performance: 60%
* Analysis
  - The following issues have been detected: wrong answers.
  - For example, for the input [-5, 5, -5, 4] the solution returned a wrong answer (got 100 expected 125).
* Code

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        
        int result = -Integer.MAX_VALUE;
        for (int i = 0; i < A.length - 2; i++) {
            int compare = A[i] * A[i + 1] * A[i + 2];
            result = Math.max(compare, result);
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
    - Detected time complexity: O(N * log(N))
* Code

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        Arrays.sort(A);
        
        int K = A.length - 1;
        int maxNag = A[0] * A[1] * A[K];
        int maxPos = A[K - 2] * A[K - 1] * A[K];
        
        return Math.max(maxNag, maxPos);
    }
}
```

## Comment

몇 가지 테스트 케이스에 대해서 생각해보면 간단히 해결할 수 있는 문제이다. 최댓값이 나오기 위해서는 결국 가장 큰 값들의 곱이어야 한다. 한 가지 고려해야 할 부분은 배열 A의 범위에 음수가 포함된다는 것이다.
