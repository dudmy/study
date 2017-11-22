# CountSemiprimes

Count the semiprime numbers in the given range [a..b]

## Task description

A prime is a positive integer X that has exactly two distinct divisors: 1 and X. The first few prime integers are 2, 3, 5, 7, 11 and 13.

A semiprime is a natural number that is the product of two (not necessarily distinct) prime numbers. The first few semiprimes are 4, 6, 9, 10, 14, 15, 21, 22, 25, 26.

You are given two non-empty zero-indexed arrays P and Q, each consisting of M integers. These arrays represent queries about the number of semiprimes within specified ranges.

Query K requires you to find the number of semiprimes within the range (P[K], Q[K]), where 1 ≤ P[K] ≤ Q[K] ≤ N.

For example, consider an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

The number of semiprimes within each of these ranges is as follows:

* (1, 26) is 10,
* (4, 10) is 4,
* (16, 20) is 0.

Write a function:

```java
class Solution { public int[] solution(int N, int[] P, int[] Q); }
```

that, given an integer N and two non-empty zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M elements specifying the consecutive answers to all the queries.

For example, given an integer N = 26 and arrays P, Q such that:

    P[0] = 1    Q[0] = 26
    P[1] = 4    Q[1] = 10
    P[2] = 16   Q[2] = 20

the function should return the values [10, 4, 0], as explained above.

Assume that:

* N is an integer within the range [1..50,000];
* M is an integer within the range [1..30,000];
* each element of arrays P, Q is an integer within the range [1..N];
* P[i] ≤ Q[i].

Complexity:

* expected worst-case time complexity is O(N*log(log(N))+M);
* expected worst-case space complexity is O(N+M), beyond input storage (not counting the storage required for input arguments).

## Solution

### First

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N * log(log(N)) + M)
* Code

```java
class Solution {
    public int[] solution(int N, int[] P, int[] Q) {
        /*
         * Sieve of Eratosthenes를 이용해 소수를 찾는다.
         */
        boolean[] notPrimes = new boolean[N + 1];
        notPrimes[0] = notPrimes[1] = true;
        for (int i = 2; i * i <= N; i++) {
            if (!notPrimes[i]) {
                for (int j = i * i; j <= N; j += i)
                    notPrimes[j] = true;
            }
        }
        
        /*
         * Sieve of Eratosthenes를 응용해 semiprime을 찾는다.
         */
        boolean[] semiprimes = new boolean[N + 1];
        for (int i = 2; i * i <= N; i++) {
            if (!notPrimes[i]) {
                semiprimes[i * i] = true;
                for (int j = i * i; j <= N; j += i) {
                    if (!notPrimes[j / i])
                        semiprimes[j] = true;
                }
            }
        }

        /*
         * index 위치까지의 찾은 semiprime의 개수를 카운트한다.
         */
        int[] semiprimeCount = new int[N + 1];
        for (int i = 2; i <= N; i++) {
            if (semiprimes[i])
                semiprimeCount[i] = semiprimeCount[i - 1] + 1;
            else
                semiprimeCount[i] = semiprimeCount[i - 1];
        }

        /*
         * range 내의 개수는 range의 마지막에서의 semiprime 개수에서 
         * range의 첫번째 이전에서의 emiprime 개수의 차를 통해 구한다.
         */
        int[] result = new int[P.length];
        for (int K = 0; K < P.length; K++)
            result[K] = semiprimeCount[Q[K]] - semiprimeCount[P[K] - 1];
        
        return result;
    }
}
```

## Comment

주어진 PDF 자료인 Sieve of Eratosthenes 내용을 많이 참고하여 문제를 풀 수 있었다. semiprimes 의 