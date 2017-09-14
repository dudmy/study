# NumberOfDiscIntersections

Compute the number of intersections in a sequence of discs.

## Task description

We draw N discs on a plane. The discs are numbered from 0 to N − 1. A zero-indexed array A of N non-negative integers, specifying the radiuses of the discs, is given. The J-th disc is drawn with its center at (J, 0) and radius A[J].

We say that the J-th disc and K-th disc intersect if J ≠ K and the J-th and K-th discs have at least one common point (assuming that the discs contain their borders).

The figure below shows discs drawn for N = 6 and A as follows:

    A[0] = 1
    A[1] = 5
    A[2] = 2
    A[3] = 1
    A[4] = 4
    A[5] = 0

There are eleven (unordered) pairs of discs that intersect, namely:

* discs 1 and 4 intersect, and both intersect with all the other discs;
* disc 2 also intersects with discs 0 and 3.

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given an array A describing N discs as explained above, returns the number of (unordered) pairs of intersecting discs. The function should return −1 if the number of intersecting pairs exceeds 10,000,000.

Given array A shown above, the function should return 11, as explained above.

Assume that:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [0..2,147,483,647].

Complexity:

* expected worst-case time complexity is O(N*log(N));
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 62%
  - Correctness: 100%
  - Performance: 25%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N**2)
* Code

```java
class Solution {
    public int solution(int[] A) {
        int cnt = 0;

        for (int i = 0; i < A.length; i++) {
            long rJth = (long) i + A[i];

            for (int j = i + 1; j < A.length; j++) {
                long lKth = (long) j - A[j];

                if (rJth >= lKth)
                    cnt++;

                if (cnt > 10000000)
                    return -1;
            }
        }

        return cnt;
    }
}
```

### Second

* Programming language: Java
* Task score: 87%
  - Correctness: 100%
  - Performance: 75%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N*log(N)) or O(N)
* Code

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        long[] lKth = new long[A.length];
        long[] rJth = new long[A.length];
        
        for (int i = 0; i < A.length; i++) {
            lKth[i] = (long) i - A[i];
            rJth[i] = (long) i + A[i];
        }
        
        Arrays.sort(lKth);
        Arrays.sort(rJth);
        
        int cnt = 0;
        for (int i = 0; i < A.length - 1; i++) {
            for (int j = i + 1; j < A.length && rJth[i] >= lKth[j]; j++) {
                cnt++;
                
                if (cnt > 10000000)
                    return -1;
            }
        }
        
        return cnt;
    }
}
```

### Third

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N*log(N)) or O(N)
* Code

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        long[] lKth = new long[A.length];
        long[] rJth = new long[A.length];
        
        for (int i = 0; i < A.length; i++) {
            lKth[i] = (long) i - A[i];
            rJth[i] = (long) i + A[i];
        }
        
        Arrays.sort(lKth);
        Arrays.sort(rJth);
        
        int cnt = 0;
        int j = 0;
        for (int i = 0; i < A.length - 1; i++) {
            while (j < A.length && rJth[i] >= lKth[j]) {
                cnt += j - i;
                j++;
                
                if (cnt > 10000000)
                    return -1;
            }
        }
        
        return cnt;
    }
}
```

## Comment

퍼포먼스를 제외한 문제의 정확도를 만족하는 풀이는 금방 구현할 수 있었다. 하지만 마지막까지 퍼포먼스 100%를 달성하는 데 실패했다. 다른 사람들의 풀이(3번째 solution)를 찾아봤는데 while 루프 안에 cnt += j - 1 부분이 왜 성립하는지 이해되지 않는다. 이 문제는 나중에 다시 살펴봐야겠다.
