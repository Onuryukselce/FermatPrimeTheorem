package FermatPrimeTheorem;

import java.math.BigInteger;

class FermatPrimeTheorem {
    public static void main(String... args) {
        for (int i = 100000; i < 1000000; i++) {
            if (isPrime(i, 5))
                System.out.print(i + ",");
        }
        System.out.println("");
    }

    private static boolean isPrime(int number, int t) {
        if (number % 2 == 0)
            return false;

        BigInteger bigRandomNumber, bigNumber, power, bigModulus;
        int randomRange = number - 2;
        int randomNumber = (int) (Math.random() * randomRange) + 1;
        bigRandomNumber = new BigInteger(Integer.toString(randomNumber));
        power = bigRandomNumber.pow(number - 1);
        bigNumber = new BigInteger(Integer.toString(number));
        bigModulus = power.mod(bigNumber);
        if (bigModulus.compareTo(new BigInteger("1")) != 0) {
            return false;
        }

        if (t > 1)
            return isPrime(number, --t);
        else
            return true;
    }
}