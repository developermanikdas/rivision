public class DivideTwoIntegers {

    public static int divide(int dividend, int divisor) {
        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to long and use absolute values
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        int result = 0;

        while (dvd >= dvs) {
            long temp = dvs, multiple = 1;
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            result += multiple;
        }

        return negative ? -result : result;
    }

    public static void main(String[] args) {
        int dividend = 10;
        int divisor = 3;
        int result = divide(dividend, divisor);
        System.out.println("Quotient of " + dividend + " / " + divisor + " = " + result);

        dividend = 7;
        divisor = -3;
        result = divide(dividend, divisor);
        System.out.println("Quotient of " + dividend + " / " + divisor + " = " + result);
    }
}
