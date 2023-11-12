
import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.print("Choose a natural number: ");

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        if (n > 1000 | n <= 0)
        {
            System.out.println("Shit happens..");
            System.exit(0);
        }

        int result = SuperPrimeCounter.numberCount(n);
        System.out.println("Super prime number counter: " + result);
        in.close();
    }

    interface NumberReverse
    {
        int reverse(int n);
    }
    interface NumberCount
    {
        int numberCount(int n);
    }
    interface NumberCheck
    {
        boolean numberCheck(int n);
    }

    private static NumberCheck isPrime = n -> // prime number check
    {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;
        if (n % 2 == 0 || n % 3 == 0)
        return false;
        for (int i = 5; i * i <= n; i += 6)
        {
            if (n % i == 0  || n % (i + 2) == 0)
            {
                return false;
            }
        }
        return true;
    };

    private static NumberReverse reverseNumber = n -> // reverse function
    {
        int reversedNumber = 0;
        while (n != 0)
        {
            int digit = n % 10;
            reversedNumber = reversedNumber * 10 + digit;
            n = n / 10;
        }
        return reversedNumber;
    };

    private static NumberCheck isSuperPrime = n -> // super prime number checker
            isPrime.numberCheck(n) && isPrime.numberCheck(reverseNumber.reverse(n));

    private static NumberCount SuperPrimeCounter = n -> // super prime number counter
    {
        int superCounter = 0;
        for (int i = 1; i <= n; i++)
        {
            if (isSuperPrime.numberCheck(i))
            {
                System.out.println(i);
                superCounter++;
            }
        }
        return superCounter;
    };
}