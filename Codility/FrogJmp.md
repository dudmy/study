# FrogJmp

Count minimal number of jumps from position X to Y.

## Task description

A small frog wants to get to the other side of the road. The frog is currently located at position X and wants to get to a position greater than or equal to Y. The small frog always jumps a fixed distance, D.

Count the minimal number of jumps that the small frog must perform to reach its target.

Write a function:

```
class Solution { public int solution(int X, int Y, int D); }
```

that, given three integers X, Y and D, returns the minimal number of jumps from position X to a position equal to or greater than Y.

For example, given:

  X = 10  Y = 85  D = 30

the function should return 3, because the frog will be positioned as follows:

* after the first jump, at position 10 + 30 = 40
* after the second jump, at position 10 + 30 + 30 = 70
* after the third jump, at position 10 + 30 + 30 + 30 = 100

Assume that:

* X, Y and D are integers within the range [1..1,000,000,000];
* X ≤ Y.

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
    public int solution(int X, int Y, int D) {
        int distance = Y - X;
        int remainder = distance % D;
        
        if (remainder == 0)
            return distance / D;
        else
            return distance / D + 1;
    }
}
```

### Comment

처음에는 X에서 Y까지의 거리와 개구리가 점프한 거리가 같은 경우를 고려하지 못했다. 풀이를 시작하기 전에 모든 상황에 대해서 생각해볼 수 있는 충분한 시간을 갖는게 필요할 것 같다.
