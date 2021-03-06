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

### Second

* Programming language: Java
* Task score: 68%
    - Correctness: 100%
    - Performance: 16%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N**3)
* Code

```java
class Solution {
    public int solution(int[] A) {
        mergeSort(A, 0, A.length - 1);
        
        for (int i = 0; i < A.length - 2; i++) {
            long AP = A[i];
            long AQ = A[i + 1];
            long AR = A[i + 2];

            if (AP + AQ > AR && AQ + AR > AP && AR + AP > AQ)
                return 1;
        }

        return 0;
    }
   
    private void mergeSort(int[] A, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(A, left, mid);
            mergeSort(A, mid + 1, right);
            merge(A, left, mid, right);
        }
    }

    private void merge(int[] A, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int[] sorted = new int[A.length];

        while (i <= mid && j <= right) {
            if (A[i] <= A[j])
                sorted[k++] = A[i++];
            else
                sorted[k++] = A[j++];
        }

        if (i  > mid)
            for (int l = j; l <= right; l++)
                sorted[k++] = A[l];
        else
            for (int l = i; l <= mid; l++)
                sorted[k++] = A[l];

        for (int l = left; l <= right; l++)
            A[l] = sorted[l];
    }
}
```

### Third

* Programming language: Java
* Task score: 93%
    - Correctness: 100%
    - Performance: 83%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N*log(N))
* Code

```java
class Solution {
    public int solution(int[] A) {
        quickSort(A, 0, A.length - 1);

        for (int i = 0; i < A.length - 2; i++) {
            long AP = A[i];
            long AQ = A[i + 1];
            long AR = A[i + 2];

            if (AP + AQ > AR && AQ + AR > AP && AR + AP > AQ)
                return 1;
        }

        return 0;
    }

    private void quickSort(int[] A, int left, int right) {
        if (left < right) {
            int pivot = partition(A, left, right);
            quickSort(A, left, pivot - 1);
            quickSort(A, pivot + 1, right);
        }
    }
    
    private int partition(int[] A, int left, int right) {
        int pivot = left;
        int low = left;
        int high = right + 1;
        
        do {
            do {
                low++;
            } while (low <= right && A[low] < A[pivot]);
            do {
                high--;
            } while (high >= left && A[high] > A[pivot]);
            
            if (low < high)
                swap(A, low, high);
                
        } while (low < high);
        
        swap(A, left, high);
        
        return high;
    }
    
    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
```

### Fourth

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N*log(N))
* Code

```java
import java.util.*;

class Solution {
     public int solution(int[] A) {
        Arrays.sort(A);

        for (int i = 0; i < A.length - 2; i++) {
            long AP = A[i];
            long AQ = A[i + 1];
            long AR = A[i + 2];

            if (AP + AQ > AR && AQ + AR > AP && AR + AP > AQ)
                return 1;
        }

        return 0;
    }
}
```

## Comment

문제를 해결하기 위해서 삽입정렬, 합병정렬, 퀵정렬 그리고 Arrays 클래스의 sort()를 사용해보았다. 그리고 퍼포먼스의 결과는 합병정렬 < 삽입정렬 < 퀵정렬 < Arrays.sort() 순서로 나타났다. 예전에 알고리즘 공부할 때에 합병정렬 최악의 시간복잡도는 O(N**2)라고 봤었는데 이 부분은 다시 한번 확인해봐야 할 것 같다. Arrays.sort() 메소드에서 사용하는 정렬 알고리즘이 궁금해서 찾아보았더니 Dual-Pivot Quicksort(by Vladimir Yaroslavskiy, Jon Bentley, and Joshua Bloch)라고 API에 나와 있다. 일반적인 퀵정렬은 하나의 pivot을 가지고 2부분으로 나누는데, 이 알고리즘은 두 개의 pivot을 가지고 3부분으로 나누어서 해결하는 것 같다. 나중에... 언젠가... 구현해보자...
