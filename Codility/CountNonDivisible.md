# CountNonDivisible

Calculate the number of elements of an array that are not divisors of each element.

## Task description

You are given an array A consisting of N integers.

For each number A[i] such that 0 ≤ i < N, we want to count the number of elements of the array that are not the divisors of A[i]. We say that these elements are non-divisors.

For example, consider integer N = 5 and array A such that:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
For the following elements:

* A[0] = 3, the non-divisors are: 2, 6,
* A[1] = 1, the non-divisors are: 3, 2, 3, 6,
* A[2] = 2, the non-divisors are: 3, 3, 6,
* A[3] = 3, the non-divisors are: 2, 6,
* A[4] = 6, there aren't any non-divisors.

Write a function:

```java
class Solution { public int[] solution(int[] A); }
```

that, given an array A consisting of N integers, returns a sequence of integers representing the amount of non-divisors.

The sequence should be returned as:

* a structure Results (in C), or
* a vector of integers (in C++), or
* a record Results (in Pascal), or
* an array of integers (in any other programming language).

For example, given:

    A[0] = 3
    A[1] = 1
    A[2] = 2
    A[3] = 3
    A[4] = 6
the function should return [2, 4, 3, 2, 0], as explained above.

Assume that:

* N is an integer within the range [1..50,000];
* each element of array A is an integer within the range [1..2 * N].

Complexity:

* expected worst-case time complexity is O(N*log(N));
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

## Solution

### First

* Programming language: Java
* Task score: 55%
    - Correctness: 100%
    - Performance: 0%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N ** 2)
* Code

```java
class Solution {
    public int[] solution(int[] A) {
        int N = A.length;
        int[] result = new int[N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                
                if (A[i] % A[j] != 0)
                    result[i]++;
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
  - Detected time complexity: O(N * log(N))
* Code

```java
class Solution {
    public int[] solution(int[] A) {
        int N = A.length;

        int[] cnt = new int[2 * N + 1];
        for (int a : A) {
            // 배열 A의 각 요소의 개수를 센다.
            cnt[a]++;   
        }

        // 나눌 수 있는 요소의 개수를 센다.
        int[] divisible = new int[cnt.length];
        // 소수는 n의 배수가 아니기 떄문에, 루트 n까지만 나누어서 떨어지면 된다.
        for (int i = 1; i * i < divisible.length; i++) {
            // 요소의 배수만큼 반복문을 돌면서 확인한다.
            for (int j = i * i; j < divisible.length; j += i) {
                divisible[j] += cnt[i];

                if (j != i * i) {
                    divisible[j] += cnt[j / i];
                }
            }
        }

        int[] result = new int[N];
        for (int i = 0; i < N; i++) {
            // 배열 A의 총 개수에서 나눌 수 있는 요소의 개수를 차를 구하면,
            // 나눌 수 없는 요소의 개수를 구할 수 있다.
            result[i] = N - divisible[A[i]];
        }

        return result;   
    }
}
```

## Comment

에라토스테네스의 체(Sieve of Eratosthenes)라는 알고리즘이 한 번에 떠오르지 않았다. 특정한 알고리즘을 이해하고 활용할 수 있어야 문제도 잘 풀 수 있는 것 같다. 많이 풀어보고 익숙해지는 게 답인 듯하다.
