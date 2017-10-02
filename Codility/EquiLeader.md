# EquiLeader

Find the index S such that the leaders of the sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N - 1] are the same.

## Task description

A non-empty zero-indexed array A consisting of N integers is given.

The leader of this array is the value that occurs in more than half of the elements of A.

An equi leader is an index S such that 0 ≤ S < N − 1 and two sequences A[0], A[1], ..., A[S] and A[S + 1], A[S + 2], ..., A[N − 1] have leaders of the same value.

For example, given array A such that:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2

we can find two equi leaders:

* 0, because sequences: (4) and (3, 4, 4, 4, 2) have the same leader, whose value is 4.
* 2, because sequences: (4, 3, 4) and (4, 4, 2) have the same leader, whose value is 4.

The goal is to count the number of equi leaders.

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given a non-empty zero-indexed array A consisting of N integers, returns the number of equi leaders.

For example, given:

    A[0] = 4
    A[1] = 3
    A[2] = 4
    A[3] = 4
    A[4] = 4
    A[5] = 2

the function should return 2, as explained above.

Assume that:

* N is an integer within the range [1..100,000];
* each element of array A is an integer within the range [−1,000,000,000..1,000,000,000].

Complexity:

* expected worst-case time complexity is O(N);
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 88%
  - Correctness: 80%
  - Performance: 100%
* Analysis
  - The following issues have been detected: wrong answers.
  - Detected time complexity: O(N)
* Code

```java
import java.util.*;

class Solution {
    public int solution(int[] A) {
        int cnt = 0;
        int N = A.length;

        Stack<Integer> stackL = new Stack<>();
        Stack<Integer> stackR = new Stack<>();

        Integer[] leaderL = new Integer[N - 1];
        Integer[] leaderR = new Integer[N - 1];

        for (int i = 0; i < N - 1; i++) {
            if (stackL.empty() || stackL.peek() == A[i]) {
                stackL.push(A[i]);
            } else {
                stackL.pop();
            }
            leaderL[i] = stackL.empty() ? null : stackL.peek();

            int idxR = N - 1 - i;
            if (stackR.empty() || stackR.peek() == A[idxR]) {
                stackR.push(A[idxR]);
            } else {
                stackR.pop();
            }
            leaderR[idxR - 1] = stackR.empty() ? null : stackR.peek();
        }

        for (int i = 0; i < N - 1; i++) {
            if (leaderL[i] == null || leaderR[i] == null)
                continue;
                
            if (Objects.equals(leaderL[i], leaderR[i]))
                cnt++;
        }

        return cnt;
    }
}
```

### Second

* Programming language: Java
* Task score: 55%
  - Correctness: 100%
  - Performance: 0%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N ** 2)
* Code

```java
import java.util.*;

class Solution {
    private Integer getLeader(int[] A) {
        int N = A.length;
        int size = 0;
        int candidate = 0;

        for (int a : A) {
            if (size == 0) {
                size++;
                candidate = a;
            } else if (candidate != a) {
                size--;
            } else {
                size++;
            }
        }

        int cnt = 0;
        for (int a : A) {
            if (a == candidate)
                cnt++;
        }

        return cnt > N / 2 ? candidate : null;
    }

    public int solution(int[] A) {
        int N = A.length;

        Integer[] leaderL = new Integer[N - 1];
        Integer[] leaderR = new Integer[N - 1];

        for (int i = 0; i < N - 1; i++) {
            leaderL[i] = getLeader(Arrays.copyOfRange(A, 0, i + 1));
            leaderR[i] = getLeader(Arrays.copyOfRange(A, i + 1, N));
        }

        int eqiCnt = 0;
        for (int i = 0; i < N - 1; i++) {
            if (leaderL[i] == null || leaderR[i] == null)
                continue;

            if (Objects.equals(leaderL[i], leaderR[i]))
                eqiCnt++;
        }

        return eqiCnt;
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
import java.util.*;

class Solution {
    public int solution(int[] A) {
        int size = 0;
        int candidate = 0;

        for (int a : A) {
            if (size == 0) {
                size++;
                candidate = a;
            } else if (candidate != a) {
                size--;
            } else {
                size++;
            }
        }

        // Stack을 이용해서 체크했다면 empty인 경우로 후보자가 없는 상태이다.
        if (size == 0)
            return 0;
        
        int cnt = 0;
        for (int a : A) {
            if (a == candidate)
                cnt++;
        }
        
        // Leader가 될 수 있는 조건인 과반수를 넘지 않은 경우이다.
        if (cnt <= A.length / 2)
            return 0;
            
        int lCnt = 0;
        int eqiCnt = 0;
        
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] == candidate)
                lCnt++;
            
            boolean leftHasLeader = lCnt > (i + 1) / 2;
            boolean rightHasLeader = (cnt - lCnt) > (A.length - i - 1) / 2;
            if (leftHasLeader && rightHasLeader)
                eqiCnt++;
        }

        return eqiCnt;
    }
}
```

## Comment

어찌어찌 문제 해결에 근접하긴 했지만, 스스로 풀지는 못했다. 실패한 테스트 케이스에 대한 예제가 주어지지 않는 경우에는 어디서 잘못 됐는지 찾는 게 어렵다. 결국, 다른 사람의 코드를 참고하였고 나중에 다시 풀어봐야겠다.
