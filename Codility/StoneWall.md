# StoneWall

Cover "Manhattan skyline" using the minimum number of rectangles.

## Task description

You are going to build a stone wall. The wall should be straight and N meters long, and its thickness should be constant; however, it should have different heights in different places. The height of the wall is specified by a zero-indexed array H of N positive integers. H[I] is the height of the wall from I to I+1 meters to the right of its left end. In particular, H[0] is the height of the wall's left end and H[N−1] is the height of the wall's right end.

The wall should be built of cuboid stone blocks (that is, all sides of such blocks are rectangular). Your task is to compute the minimum number of blocks needed to build the wall.

Write a function:

```java
class Solution { public int solution(int[] H); }
```

that, given a zero-indexed array H of N positive integers specifying the height of the wall, returns the minimum number of blocks needed to build it.

For example, given array H containing N = 9 integers:

    H[0] = 8    H[1] = 8    H[2] = 5
    H[3] = 7    H[4] = 9    H[5] = 8
    H[6] = 7    H[7] = 4    H[8] = 8

the function should return 7. The figure shows one possible arrangement of seven blocks.

Assume that:

* N is an integer within the range [1..100,000];
* each element of array H is an integer within the range [1..1,000,000,000].

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
    public int solution(int[] H) {
        int cnt = 0;
        Stack<Integer> s = new Stack<>();

        for (int height : H) {
            while (!s.empty() && s.peek() > height) {
                s.pop();
            }

            if (s.empty() || s.peek() < height) {
                s.push(height);
                cnt++;
            }
        }

        return cnt;
    }
}
```

## Comment

이 문제를 풀었지만 조금 찜찜한 부분이 있다. 이 레슨의 제목이 Stacks and Queues 라서, 어떻게 접근해야 하는지 쉽게 파악했기 때문이다. 만약 Stack 또는 Queue 자료구조를 활용하면 된다는 것을 몰랐다면 한 번에 풀 수 있었을지 모르겠다.
