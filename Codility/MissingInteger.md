# MissingInteger

Find the minimal positive integer not occurring in a given sequence.

## Task description

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given a non-empty zero-indexed array A of N integers, returns the minimal positive integer (greater than 0) that does not occur in A.

For example, given:

  A[0] = 1  A[1] = 3  A[2] = 6  A[3] = 4  A[4] = 1  A[5] = 2

the function should return 5.

Assume that:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

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
import java.util.*;

class Solution {
    public int solution(int[] A) {
        Set<Integer> set = new HashSet<>();

        for (int element : A) {
            if (elemminent > 0) set.add(element);
        }
    
        int min = 1;
        while (set.contains(min)) min++;
        
        return min;
    }
}
```

## Comment

이번 task에서 가장 크게 느낀 점은 문제를 올바르게 해석해야 한다는 것이다. 이에 대한 원인이 영어 때문인지, 아니면 나의 이해도가 낮은 건지 고민해볼 필요가 있다.
