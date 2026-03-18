import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        showWelcome();
        menu();
    }

    private static void showWelcome() {
        System.out.println("====================================");
        System.out.println("Assignment #1 - Recursion");
        System.out.println("Student: Azhar Aidarbek");
        System.out.println("Group: [WRITE YOUR GROUP]");
        System.out.println("====================================");
    }

    private static void menu() {
        System.out.println("\nChoose a task:");
        System.out.println("1  - Print Digits of a Number");
        System.out.println("2  - Average of Elements");
        System.out.println("3  - Prime Number Check");
        System.out.println("4  - Factorial");
        System.out.println("5  - Fibonacci Number");
        System.out.println("6  - Power Function");
        System.out.println("7  - Reverse Output");
        System.out.println("8  - Check Digits in String");
        System.out.println("9  - Count Characters in a String");
        System.out.println("10 - Greatest Common Divisor (GCD)");
        System.out.println("0  - Exit");
        System.out.print("Enter task number: ");

        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.nextLine();
            menu();
            return;
        }

        int choice = scanner.nextInt();
        scanner.nextLine();
        handleChoice(choice);
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1:
                task1();
                break;
            case 2:
                task2();
                break;
            case 3:
                task3();
                break;
            case 4:
                task4();
                break;
            case 5:
                task5();
                break;
            case 6:
                task6();
                break;
            case 7:
                task7();
                break;
            case 8:
                task8();
                break;
            case 9:
                task9();
                break;
            case 10:
                task10();
                break;
            case 0:
                System.out.println("Program finished.");
                return;
            default:
                System.out.println("Invalid task number.");
                menu();
                return;
        }

        askToContinue();
    }

    private static void askToContinue() {
        System.out.print("\nDo you want to choose another task? (yes/no): ");
        String answer = scanner.nextLine().trim().toLowerCase();

        if (answer.equals("yes") || answer.equals("y")) {
            menu();
        } else if (answer.equals("no") || answer.equals("n")) {
            System.out.println("Program finished.");
        } else {
            System.out.println("Please answer yes or no.");
            askToContinue();
        }
    }

    // Task 1
    private static void task1() {
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        if (number < 0) {
            System.out.println("-");
            number = -number;
        }

        System.out.println("Digits:");
        printDigits(number);
    }

    private static void printDigits(int number) {
        if (number < 10) {
            System.out.println(number);
            return;
        }
        printDigits(number / 10);
        System.out.println(number % 10);
    }

    // Task 2
    private static void task2() {
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Number of elements must be positive.");
            scanner.nextLine();
            return;
        }

        int[] array = new int[n];
        System.out.println("Enter " + n + " integers:");
        readArrayRecursive(array, 0);
        scanner.nextLine();

        int sum = sumArrayRecursive(array, 0);
        double average = (double) sum / n;
        System.out.println("Average: " + average);
    }

    private static void readArrayRecursive(int[] array, int index) {
        if (index == array.length) {
            return;
        }
        array[index] = scanner.nextInt();
        readArrayRecursive(array, index + 1);
    }

    private static int sumArrayRecursive(int[] array, int index) {
        if (index == array.length) {
            return 0;
        }
        return array[index] + sumArrayRecursive(array, index + 1);
    }

    // Task 3
    private static void task3() {
        System.out.print("Enter a number: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n < 2) {
            System.out.println("Composite");
            return;
        }

        System.out.println(isPrimeRecursive(n, 2) ? "Prime" : "Composite");
    }

    private static boolean isPrimeRecursive(int n, int divisor) {
        if (divisor * divisor > n) {
            return true;
        }
        if (n % divisor == 0) {
            return false;
        }
        return isPrimeRecursive(n, divisor + 1);
    }

    // Task 4
    private static void task4() {
        System.out.print("Enter a non-negative integer: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n < 0) {
            System.out.println("Factorial is defined only for non-negative integers.");
            return;
        }

        System.out.println("Factorial: " + factorial(n));
    }

    private static long factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    // Task 5
    private static void task5() {
        System.out.print("Enter n: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n < 0) {
            System.out.println("n must be non-negative.");
            return;
        }

        System.out.println("Fibonacci(" + n + ") = " + fibonacci(n));
    }

    private static long fibonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // Task 6
    private static void task6() {
        System.out.print("Enter base a: ");
        long a = scanner.nextLong();
        System.out.print("Enter exponent n: ");
        int n = scanner.nextInt();
        scanner.nextLine();

        if (n < 0) {
            System.out.println("This version supports only non-negative exponents.");
            return;
        }

        System.out.println("Result: " + power(a, n));
    }

    private static long power(long a, int n) {
        if (n == 0) {
            return 1;
        }
        return a * power(a, n - 1);
    }

    // Task 7
    private static void task7() {
        System.out.print("Enter number of elements: ");
        int n = scanner.nextInt();

        if (n < 0) {
            System.out.println("Number of elements cannot be negative.");
            scanner.nextLine();
            return;
        }

        System.out.println("Enter " + n + " integers:");
        System.out.print("Reversed order: ");
        reverseReadAndPrint(n);
        System.out.println();
        scanner.nextLine();
    }

    private static void reverseReadAndPrint(int n) {
        if (n == 0) {
            return;
        }
        int value = scanner.nextInt();
        reverseReadAndPrint(n - 1);
        System.out.print(value + " ");
    }

    // Task 8
    private static void task8() {
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        System.out.println(containsOnlyDigits(s, 0) ? "Yes" : "No");
    }

    private static boolean containsOnlyDigits(String s, int index) {
        if (s.isEmpty()) {
            return false;
        }
        if (index == s.length()) {
            return true;
        }
        if (!Character.isDigit(s.charAt(index))) {
            return false;
        }
        return containsOnlyDigits(s, index + 1);
    }

    // Task 9
    private static void task9() {
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        System.out.println("Character count: " + countChars(s));
    }

    private static int countChars(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return 1 + countChars(s.substring(1));
    }

    // Task 10
    private static void task10() {
        System.out.print("Enter first number: ");
        int a = scanner.nextInt();
        System.out.print("Enter second number: ");
        int b = scanner.nextInt();
        scanner.nextLine();

        System.out.println("GCD: " + gcd(Math.abs(a), Math.abs(b)));
    }

    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}
