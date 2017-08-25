# GenomicRangeQuery

Find the minimal nucleotide from a range of sequence DNA.

## Task description

A DNA sequence can be represented as a string consisting of the letters A, C, G and T, which correspond to the types of successive nucleotides in the sequence. Each nucleotide has an impact factor, which is an integer. Nucleotides of types A, C, G and T have impact factors of 1, 2, 3 and 4, respectively. You are going to answer several queries of the form: What is the minimal impact factor of nucleotides contained in a particular part of the given DNA sequence?

The DNA sequence is given as a non-empty string S = S[0]S[1]...S[N-1] consisting of N characters. There are M queries, which are given in non-empty arrays P and Q, each consisting of M integers. The K-th query (0 ≤ K < M) requires you to find the minimal impact factor of nucleotides contained in the DNA sequence between positions P[K] and Q[K] (inclusive).

For example, consider string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6

The answers to these M = 3 queries are as follows:

* The part of the DNA between positions 2 and 4 contains nucleotides G and C (twice), whose impact factors are 3 and 2 respectively, so the answer is 2.
* The part between positions 5 and 5 contains a single nucleotide T, whose impact factor is 4, so the answer is 4.
* The part between positions 0 and 6 (the whole string) contains all nucleotides, in particular nucleotide A whose impact factor is 1, so the answer is 1.

Write a function:

```java
class Solution { public int[] solution(String S, int[] P, int[] Q); }
```

that, given a non-empty zero-indexed string S consisting of N characters and two non-empty zero-indexed arrays P and Q consisting of M integers, returns an array consisting of M integers specifying the consecutive answers to all queries.

The sequence should be returned as:

* a Results structure (in C), or
* a vector of integers (in C++), or
* a Results record (in Pascal), or
* an array of integers (in any other programming language).

For example, given the string S = CAGCCTA and arrays P, Q such that:

    P[0] = 2    Q[0] = 4
    P[1] = 5    Q[1] = 5
    P[2] = 0    Q[2] = 6

the function should return the values [2, 4, 1], as explained above.

Assume that:

* N is an integer within the range [1..100,000];
* M is an integer within the range [1..50,000];
* each element of arrays P, Q is an integer within the range [0..N − 1];
* P[K] ≤ Q[K], where 0 ≤ K < M;
* string S consists only of upper-case English letters A, C, G, T.

Complexity:

* expected worst-case time complexity is O(N+M);
* expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).

Elements of input arrays can be modified.

## Solution

### First

* Programming language: Java
* Task score: 62%
    - Correctness: 100%
    - Performance: 0%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N * M)
* Code

```java
import java.util.*;

class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        Map<String, Integer> factor = new HashMap<>();
        factor.put("A", 1);
        factor.put("C", 2);
        factor.put("G", 3);
        factor.put("T", 4);
        
        int[] result = new int[P.length];
        String[] s = S.split("");
        
        for (int i = 0; i < P.length; i++) {
            int min = 4;

            for (int j = P[i]; j <= Q[i]; j++) {
                min = Math.min(factor.get(s[j]), min);
            }
            result[i] = min;
        }
        
        return result;
    }
}
```

### Second

* Programming language: Java
* Task score: 87%
    - Correctness: 100%
    - Performance: 66%
* Analysis
  - The following issues have been detected: timeout errors.
  - Detected time complexity: O(N + M)
  - almost_all_same_letters (ex. GGGGGG..??..GGGGGG..??..GGGGGG)
* Code

```java
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        String[] s = S.split("");

        int[] A = new int[s.length + 1];
        int[] C = new int[s.length + 1];
        int[] G = new int[s.length + 1];
        int[] T = new int[s.length + 1];

        for (int i = 0; i < s.length; i++) {
            A[i + 1] = A[i] + (s[i].equals("A") ? 1 : 0);
            C[i + 1] = C[i] + (s[i].equals("C") ? 1 : 0);
            G[i + 1] = G[i] + (s[i].equals("G") ? 1 : 0);
            T[i + 1] = T[i] + (s[i].equals("T") ? 1 : 0);
        }

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            if (A[P[i]] < A[Q[i] + 1]) result[i] = 1;
            else if (C[P[i]] < C[Q[i] + 1]) result[i] = 2;
            else if (G[P[i]] < G[Q[i] + 1]) result[i] = 3;
            else result[i] = 4;
        }

        return result;
    }
}
```

### Third

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(N + M)
* Code

```java
class Solution {
    public int[] solution(String S, int[] P, int[] Q) {
        int[] A = new int[S.length() + 1];
        int[] C = new int[S.length() + 1];
        int[] G = new int[S.length() + 1];

        for (int i = 0; i < S.length(); i++) {
            A[i + 1] = A[i] + (S.charAt(i) == 'A' ? 1 : 0);
            C[i + 1] = C[i] + (S.charAt(i) == 'C' ? 1 : 0);
            G[i + 1] = G[i] + (S.charAt(i) == 'G' ? 1 : 0);
        }

        int[] result = new int[P.length];

        for (int i = 0; i < P.length; i++) {
            if (A[P[i]] < A[Q[i] + 1]) result[i] = 1;
            else if (C[P[i]] < C[Q[i] + 1]) result[i] = 2;
            else if (G[P[i]] < G[Q[i] + 1]) result[i] = 3;
            else result[i] = 4;
        }

        return result;
    }
}
```

## Comment

PAINLESS 문제를 풀면서 방법에 익숙해졌다고 생각했는데... RESPECTABLE 문제 역시 해결 방법이 잘 떠오르지 않는다.
