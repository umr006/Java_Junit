package edu.school21.numbers;

import static java.lang.Math.sqrt;

public class NumberWorker {
    public boolean isPrime(int number) {
        boolean res = true;
        for (int i = 2, cnt = 0; i <= sqrt(number); i++, cnt++) {
            if (number % i == 0) {
                res = false;
            }
        }
        return res;
    }

    public int digitsSum(int number) {
        int res = 0;
        while (number > 0) {
            res += number % 10;
            number /= 10;
        }
        return res;
    }
}
