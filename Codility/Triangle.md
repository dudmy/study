# Triangle

Determine whether a triangle can be built from a given set of edges.

## Task description

A zero-indexed array A consisting of N integers is given. A triplet (P, Q, R) is triangular if 0 ≤ P < Q < R < N and:

* A[P] + A[Q] > A[R],
* A[Q] + A[R] > A[P],
* A[R] + A[P] > A[Q].

For example, consider array A such that:

    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 20

Triplet (0, 2, 4) is triangular.

Write a function:

```java
class Solution { public int solution(int[] A); }
```

that, given a zero-indexed array A consisting of N integers, returns 1 if there exists a triangular triplet for this array and returns 0 otherwise.

For example, given array A such that:

    A[0] = 10    A[1] = 2    A[2] = 5
    A[3] = 1     A[4] = 8    A[5] = 20

the function should return 1, as explained above. Given array A such that:

    A[0] = 10    A[1] = 50    A[2] = 5
    A[3] = 1
the function should return 0.

Assume that:

* N is an integer within the range [0..100,000];
* each element of array A is an integer within the range [−2,147,483,648..2,147,483,647].

Complexity:

* expected worst-case time complexity is O(N*log(N));
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 75%
    - Correctness: 100%
    - Performance: 33%
* Analysis
  - The following issues have been detected: timeout errors.
* Code

```java
class Solution {
    public int solution(int[] A) {
        insertionSort(A);

        for (int i = 0; i < A.length - 2; i++) {
            long AP = A[i];
            long AQ = A[i + 1];
            long AR = A[i + 2];

            if (AP + AQ > AR && AQ + AR > AP && AR + AP > AQ)
                return 1;
        }

        return 0;
    }

    private void insertionSort(int[] A) {
        int item, j;
        for (int i = 1; i < A.length; i++) {
            item = A[i];
            for (j = i - 1; j >= 0 && A[j] > item; j--) {
                A[j + 1] = A[j];
            }
            A[j + 1] = item;
        }
    }
}
```
