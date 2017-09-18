# Nesting

Determine whether given string of parentheses is properly nested.

## Task description

A string S consisting of N characters is called properly nested if:

* S is empty;
* S has the form "(U)" where U is a properly nested string;
* S has the form "VW" where V and W are properly nested strings.

For example, string "(()(())())" is properly nested but string "())" isn't.

Write a function:

```java
class Solution { public int solution(String S); }
```

that, given a string S consisting of N characters, returns 1 if string S is properly nested and 0 otherwise.

For example, given S = "(()(())())", the function should return 1 and given S = "())", the function should return 0, as explained above.

Assume that:

* N is an integer within the range [0..1,000,000];
* string S consists only of the characters "(" and/or ")".

Complexity:

* expected worst-case time complexity is O(N);
* expected worst-case space complexity is O(1) (not counting the storage required for input arguments).

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
    public int solution(String S) {
        if (S.isEmpty())
            return 1;

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()) {
                return 0;
            } else {
                stack.pop();
            }
        }

        return stack.empty() ? 1 : 0;
    }
}
```

## Comment

이 문제도 스택을 이용하면 쉽게 해결할 수 있다.