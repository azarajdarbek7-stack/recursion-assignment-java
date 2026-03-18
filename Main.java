import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showWelcome();
        menu();
    }

    private static void showWelcome() {
        System.out.println("=================================");
        System.out.println("Assignment #1 - Recursion");
        System.out.println("Student: Azhar Aidarbek");
        System.out.println("Group: BDA-2502");
        System.out.println("=================================");
    }

    private static void menu() {
        System.out.println("\nChoose a task:");
        System.out.println("1 - Print Digits of a Number");
        System.out.println("2 - Average of Elements");
        System.out.println("3 - Prime Number Check");
        System.out.println("4 - Factorial");
        System.out.println("5 - Fibonacci Number");
        System.out.println("6 - Power Function");
        System.out.println("7 - Reverse Output");
        System.out.println("8 - Check Digits in String");
        System.out.println("9 - Count Characters in String");
        System.out.println("10 - GCD");
        System.out.print("Enter task number: ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter number: ");
                int n = scanner.nextInt();
                printDigits(n);
                break;

            case 2:
                System.out.print("Enter size: ");
                int size = scanner.nextInt();
                int[] arr = new int[size];
                for (int i = 0; i < size; i++) arr[i] = scanner.nextInt();
                double avg = (double) sum(arr, size) / size;
                System.out.println(avg);
                break;

            case 3:
                System.out.print("Enter number: ");
                int num = scanner.nextInt();
                System.out.println(isPrime(num, 2) ? "Prime" : "Composite");
                break;

            case 4:
                System.out.print("Enter n: ");
                int f = scanner.nextInt();
                System.out.println(factorial(f));
                break;

            case 5:
                System.out.print("Enter n: ");
                int fib = scanner.nextInt();
                System.out.println(fibonacci(fib));
                break;

            case 6:
                System.out.print("Enter a and n: ");
                int a = scanner.nextInt();
                int p = scanner.nextInt();
                System.out.println(power(a, p));
                break;

            case 7:
                System.out.print("Enter size: ");
                int s = scanner.nextInt();
                int[] array = new int[s];
                for (int i = 0; i < s; i++) array[i] = scanner.nextInt();
                reversePrint(array, s - 1);
                break;

            case 8:
                scanner.nextLine();
                System.out.print("Enter string: ");
                String str = scanner.nextLine();
                System.out.println(checkDigits(str, 0) ? "Yes" : "No");
                break;

            case 9:
                scanner.nextLine();
                System.out.print("Enter string: ");
                String st = scanner.nextLine();
                System.out.println(countChars(st));
                break;

            case 10:
                System.out.print("Enter two numbers: ");
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                System.out.println(gcd(x, y));
                break;

            default:
                System.out.println("Invalid choice");
        }
    }

    // Task 1
    private static void printDigits(int n) {
        if (n == 0) return;
        printDigits(n / 10);
        System.out.println(n % 10);
    }

    // Task 2
    private static int sum(int[] arr, int n) {
        if (n == 0) return 0;
        return arr[n - 1] + sum(arr, n - 1);
    }

    // Task 3
    private static boolean isPrime(int n, int i) {
        if (n <= 2) return (n == 2);
        if (n % i == 0) return false;
        if (i * i > n) return true;
        return isPrime(n, i + 1);
    }

    // Task 4
    private static int factorial(int n) {
        if (n == 0) return 1;
        return n * factorial(n - 1);
    }

    // Task 5
    private static int fibonacci(int n) {
        if (n <= 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Task 6
    private static int power(int a, int n) {
        if (n == 0) return 1;
        return a * power(a, n - 1);
    }

    // Task 7
    private static void reversePrint(int[] arr, int index) {
        if (index < 0) return;
        System.out.print(arr[index] + " ");
        reversePrint(arr, index - 1);
    }

    // Task 8
    private static boolean checkDigits(String s, int i) {
        if (i == s.length()) return true;
        if (!Character.isDigit(s.charAt(i))) return false;
        return checkDigits(s, i + 1);
    }

    // Task 9
    private static int countChars(String s) {
        if (s.equals("")) return 0;
        return 1 + countChars(s.substring(1));
    }

    // Task 10
    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}
