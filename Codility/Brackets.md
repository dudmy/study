# Brackets

Determine whether a given string of parentheses is properly nested.

## Task description

A string S consisting of N characters is considered to be properly nested if any of the following conditions is true:

* S is empty;
* S has the form "(U)" or "[U]" or "{U}" where U is a properly nested string;
* S has the form "VW" where V and W are properly nested strings.

For example, the string "{[()()]}" is properly nested but "([)()]" is not.

Write a function:

```java
class Solution { public int solution(String S); }
```

that, given a string S consisting of N characters, returns 1 if S is properly nested and 0 otherwise.

For example, given S = "{[()()]}", the function should return 1 and given S = "([)()]", the function should return 0, as explained above.

Assume that:

* N is an integer within the range [0..200,000];
* string S consists only of the following characters: "(", "{", "[", "]", "}" and/or ")".

Complexity:

* expected worst-case time complexity is O(N);
* expected worst-case space complexity is O(N) (not counting the storage required for input arguments).

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

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (stack.isEmpty() || c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if ((stack.peek() == '(' && c == ')')
                    || (stack.peek() == '[' && c == ']')
                    || (stack.peek() == '{' && c == '}')) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        return stack.empty() ? 1 : 0;
    }
}
```

### Second

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

        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);

            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else if (stack.empty()
                    || (stack.peek() == '(' && c != ')') 
                    || (stack.peek() == '[' && c != ']') 
                    || (stack.peek() == '{' && c != '}')) {
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

이 문제는 자료구조 강의에서 스택을 배울때 등장하는 괄호 검사이다. 두 번째 방법은 자료구조 책에 있는 괄호 검사 프로그램으로 작성해보았는데, 디테일한 부분에서 시간을 단축시킨 걸 확인할 수 있다.
