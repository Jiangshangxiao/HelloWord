import java.util.ArrayList;
public class PrimeDirective {
    public boolean isPrime(int number) {
        if (number == 2) {
            return true;
        }
        if (number < 2) {
            return false;
        }
        for(int i = 2; i < number; i++) {
            if(number % i == 0) {
                System.out.println(number + " is not a prime number");
                return false;
            }
        }
        System.out.println(number + " is a prime number");
        return true;
    }

    public ArrayList<Integer> onlyPrimes(int[] numbers) {
        ArrayList<Integer> primes = new ArrayList<>();
        for (int number : numbers) {
            if (isPrime(number)) {
                primes.add(number);
            }
        }
        return primes;
    }

    public static void main(String[] args) {
        PrimeDirective pd = new PrimeDirective();
        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};
        for (int number : numbers) {
            pd.isPrime(number);
        }
        System.out.println(pd.onlyPrimes(numbers));
    }
}
