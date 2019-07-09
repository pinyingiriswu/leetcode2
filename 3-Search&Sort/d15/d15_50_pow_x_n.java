public class d15_50_pow_x_n {

    public double myPow(double x, int n) {
        if (n == 0) return 1;
        double half = myPow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            if (n > 0) {
                return half * half * x;
            } else {
                return half * half / x; //prevent overflow on Integer.MIN
            }
        }

    }
}
