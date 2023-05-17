public class Lab5 {
// BJP5 12.8
    public int multiplyEvens(int num) throws IllegalArgumentException {
        int result = 2;
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        else if (num > 1) {
            result = multiplyEvens(num - 1) * num * 2;
        }
        return result;
    }
// BJP5 12.11
    public String repeat(String s, int n) throws IllegalArgumentException {
        String result = "";
        if (n < 0) {
            throw new IllegalArgumentException();
        }
        else if (n > 0) {
            result = repeat(s, n - 1);
            result += s;
        }
        return result;
    }
        
//BJP4 12.14
    public String dedup(String theString) {
        String result;
        if (theString.length() < 2) {
            result = theString;
        }
        else if (theString.charAt(0) == (theString.charAt(1))) {
            result = dedup(theString.substring(1));
        }
        else {
            result = theString.charAt(0) + dedup(theString.substring(1));
        }
        return result;
    }

//BJP5 12.16
    public int evenDigits(int n) {
        if 

    }

}