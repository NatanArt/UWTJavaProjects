public class Recursion5 {
    public static void main(String[] theArgs) {
        // System.out.println(sumIt(100));
        // System.out.println(expon(2, 0));
        // System.out.println(fib(8));

        // drawPattern(8);
        // System.out.println();
        
        System.out.print("natan: ");
        System.out.println(isPalindrome("natan"));

    }

    public static boolean isPalindrome(String theString) {
        boolean result = false;
        if (theString.length() < 2) {
            result = true;
        }
        else if (theString.charAt(0) == theString.charAt(theString.length() - 1)) {
            String nextTest = theString.substring(1, theString.length() - 1);
            result = isPalindrome(nextTest);
        }
        return result;
    }

    public static void drawPattern(int n) {
        if (n == 1) {
            System.out.print("+");
        }
        else if (n == 2) {
            System.out.print("++");
        }
        else if (n == 3) {
            System.out.print("++");
        }
        else {
            System.out.print("/");
            System.out.print("\\");
            drawPattern(n - 3);
            System.out.print("\\");
        }
    }

    public static int fib(int n) {
        int result = 1;
        if (n > 2) {
            result = fib(n - 1) + fib(n - 2);
        }
        return result;
    }
    public static void stars(int n) {
        if (n == 1) {
            System.out.println("*");
        }
        else {
            stars(n - 1);
            System.out.print("*");
        }
    }

    public static int expon(int b, int e) {
        int res = 1;
        if (e > 0) {
            res = expon(b, e - 1) * b;
        }
        return res;
    }

    public static int sumIt(int n) {
        int result = 1;
        if (n > 1) {
            result = sumIt(n - 1) + n;
        }
        return result;
    }
}