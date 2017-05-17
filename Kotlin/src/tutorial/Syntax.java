package tutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by yujin on 2017. 4. 5..
 */
public class Syntax {

    private static int sum(int a, int b) {
        return a + b;
    }

    private static void printSum(int a, int b) {
        System.out.println("sum of " + a + " and " + b + " is " + (a + b));
    }

    private static void localVariables() {
        int a = 1;
        int c;
        c = 3;
    }

    private static void stringTemplates() {
        int a = 1;
        String s1 = "a is " + a;
        System.out.println(s1);

        a = 2;
        String s2 = s1.replace("is", "was") + ", but now is " + a;
        System.out.println(s2);
    }

    private static int maxOf(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    private static Integer parseInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return null;
        }
    }

    private static void printProduct(String arg1, String arg2) {
        Integer x = parseInt(arg1);
        Integer y = parseInt(arg2);

        if (x != null && y != null) {
            System.out.println(x * y);
        } else {
            System.out.println("either '" + arg1 + "' or '" + arg2 + "' is not a number");
        }
    }

    private static Integer getStringLength(Object obj) {
        if (obj instanceof String) {
            return ((String) obj).length();
        }
        return null;
    }

    private static void forLoop() {
        List items = Arrays.asList("apple", "banana", "kiwi");
        for (Object item : items) {
            System.out.println((String) item);
        }

        for (int index = 0; index < items.size(); index++) {
            System.out.println("item at " + index + " is " + (String) items.get(index));
        }
    }

    private static void whileLoop() {
        List items = Arrays.asList("apple", "banana", "kiwi");
        int index = 0;
        while (index < items.size()) {
            System.out.println("item at " + index + " is " + (String) items.get(index));
            index++;
        }
    }

    private static String describe(Object obj) {
        try {
            Integer parsedInt = parseInt(String.valueOf(obj));
            if (parsedInt != null && 1 == parsedInt) {
                return "One";
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        if ("Hello".equals(String.valueOf(obj))) {
            return "Greeting";
        } else if (obj instanceof Long) {
            return "Long";
        } else if (!(obj instanceof String)) {
            return "Not a string";
        } else {
            return "Unknown";
        }
    }

    private static void ranges() {
        int x = 10;
        int y = 9;
        if (x >= 1 && x <= y + 1) {
            System.out.println("fit is range");
        }

        List<String> list = Arrays.asList("a", "b", "c");
        int index = -1;
        if (index < 0 || index > list.size() - 1) {
            System.out.println("-1 is out of range");
        }
        boolean inRange = false;
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size()) {
                inRange = true;
            }
        }
        if (!inRange) {
            System.out.println("list size is out of valid list indices range too");
        }

        for (int i = 1; i <= 10; i+=2) {
            System.out.print(i);
        }
        System.out.println();

        for (int i = 9; i >= 0; i-=3) {
            System.out.print(i);
        }
        System.out.println();
    }

    private static void collections() {
        List<String> items = Arrays.asList("avocado", "apple", "banana", "kiwi");
        for (String item : items) {
            System.out.println(item);
        }

        if (items.contains("orange")) {
            System.out.println("juicy");
        } else if (items.contains("apple")) {
            System.out.println("apple is fine too");
        }

        List<String> filterItems = new ArrayList<>();
        for (String item : items) {
            if (item.startsWith("a")) {
                filterItems.add(item.toUpperCase());
            }
        }
        Collections.sort(filterItems);
        for (String item : filterItems) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {

        System.out.println("--Defining functions--");
        System.out.println("1 + 2 = " + sum(1,2));
        printSum(2, 3);

        System.out.println("\n--Defining local variables");
        localVariables();

        System.out.println("\n--Using string templates--");
        stringTemplates();

        System.out.println("\n--Using conditional expressions--");
        System.out.println(maxOf(1, 2));

        System.out.println("\n--Using nullable values and checking for null--");
        printProduct("1", "a");

        System.out.println("\n--Using type checks and automatic casts--");
        getStringLength("abc");

        System.out.println("\n--Using a for loop--");
        forLoop();

        System.out.println("\n--Using a while loop--");
        whileLoop();

        System.out.println("\n--Using when expression--");
        System.out.println(describe("test"));

        System.out.println("\n--Using ranges--");
        ranges();

        System.out.println("\n--Using collections--");
        collections();
    }
}
