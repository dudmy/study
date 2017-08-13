# CountDiv

Compute number of integers divisible by k in range [a..b].

## Task description

Write a function:

```java
class Solution { public int solution(int A, int B, int K); }
```

that, given three integers A, B and K, returns the number of integers within the range [A..B] that are divisible by K, i.e.:

{ i : A ≤ i ≤ B, i mod K = 0 }

For example, for A = 6, B = 11 and K = 2, your function should return 3, because there are three numbers divisible by 2 within the range [6..11], namely 6, 8 and 10.

Assume that:

* A and B are integers within the range [0..2,000,000,000];
* K is an integer within the range [1..2,000,000,000];
* A ≤ B.

Complexity:

* expected worst-case time complexity is O(1);
* expected worst-case space complexity is O(1).

## Solution

### First

* Programming language: Java
* Task score: 100%
* Analysis
  - The solution obtained perfect score.
  - Detected time complexity: O(1)
* Code

```java
class Solution {
    public int solution(int A, int B, int K) {
        int cntR = B / K;
        int cntL = A / K;
        int cntDup = (A % K == 0) ? 1 : 0;
        
        return cntR - cntL + cntDup;
    }
}
```

## Comment

처음에 (B - A) / K 로 mod 0 인 값을 계산했는데 답이 일치하지 않는 경우가 있었다. 이는 A ~ B 범위를 평균적으로 가정한 방법이기 때문에 +-1개 정도의 오차가 존재했다.