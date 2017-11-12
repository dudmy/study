# Flags

Find the maximum number of flags that can be set on mountain peaks.

## Task description

A non-empty zero-indexed array A consisting of N integers is given.

A peak is an array element which is larger than its neighbours. More precisely, it is an index P such that 0 < P < N − 1 and A[P − 1] < A[P] > A[P + 1].

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2

has exactly four peaks: elements 1, 3, 5 and 10.

You are going on a trip to a range of mountains whose relative heights are represented by array A, as shown in a figure below. You have to choose how many flags you should take with you. The goal is to set the maximum number of flags on the peaks, according to certain rules.

Flags can only be set on peaks. What's more, if you take K flags, then the distance between any two flags should be greater than or equal to K. The distance between indices P and Q is the absolute value |P − Q|.

For example, given the mountain range represented by array A, above, with N = 12, if you take:

* two flags, you can set them on peaks 1 and 5;
* three flags, you can set them on peaks 1, 5 and 10;
* four flags, you can set only three flags, on peaks 1, 5 and 10.

You can therefore set a maximum of three flags in this case.

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given a non-empty zero-indexed array A of N integers, returns the maximum number of flags that can be set on the peaks of the array.

For example, the following array A:

    A[0] = 1
    A[1] = 5
    A[2] = 3
    A[3] = 4
    A[4] = 3
    A[5] = 4
    A[6] = 1
    A[7] = 2
    A[8] = 3
    A[9] = 4
    A[10] = 6
    A[11] = 2

the function should return 3, as explained above.

Assume that:

* N is an integer within the range [1..400,000];
* each element of array A is an integer within the range [0..1,000,000,000].

Complexity:

* expected worst-case time complexity is O(N);
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

## Solution

### First

* Programming language: Java
* Task score: 40%
  - Correctness: 75%
  - Performance: 0%
* Analysis
  - The following issues have been detected: wrong answers.
* Code

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1])
                peaks.add(i);
        }
        
        if (peaks.size() < 2)
            return peaks.size();
        
        int flags = 1;
        int P = peaks.get(0);
        
        for (int i = 1; i < peaks.size(); i++) {
            int Q = peaks.get(i);
            int distance = Q - P;
            
            if (distance >= flags + 1) {
                P = Q;
                flags++;
            }
        }
        
        return flags;
    }
}
```

### Second

* Programming language: Java
* Task score: 66%
  - Correctness: 100%
  - Performance: 28%
* Analysis
  - The following issues have been detected: timeout errors.
* Code

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        List<Integer> peaks = new ArrayList<>();
        for (int i = 1; i < A.length - 1; i++) {
            if (A[i - 1] < A[i] && A[i] > A[i + 1])
                peaks.add(i);
        }
        
        for (int flagNum = 1; ; flagNum++) {
            int count = 0;
            int lastFlagged = -1;
            
            for (int peak : peaks) {
                if (lastFlagged < 0 || peak - lastFlagged >= flagNum) {
                    lastFlagged = peak;
                    count++;
                }
            }
            
            if (count < flagNum)
                return flagNum - 1;
        }
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
        if (A.length < 3)
            return 0;
            
        int flags;
        
        for (flags = 1; flags < A.length; flags++) {
            int K = flags;
            
            for (int i = 1; i < A.length - 1; i++) {
                // If position i is peak.
                if (A[i] > A[i - 1] && A[i] > A[i + 1]) {
                    K--;
                    i += flags - 1; // next peakable position
                }
                
                // There may be more peak position.
                if (K == 0)
                    break;
            }
            
            // If the flag that can be set to the maximum is exceeded.
            if (K > 0) {
                flags--;
                break;
            }
        }
        
        return flags;
    }
}
```

## Comment

이번 문제도 결국은 답을 찾지 못하고 다른 사람들의 풀이를 찾아보았다. Lesson이 진행될 수록 스스로 해결할 수 있는 문제가 줄어드는 것 같다.
