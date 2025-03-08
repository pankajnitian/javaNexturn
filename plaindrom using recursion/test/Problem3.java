package test;

// 3. Fibonacci Series

class Problem3 {
    public static void printFibonacci(int n) {
        int a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int n = 5; // Example input
        printFibonacci(n); // Expected Output: 0 1 1 2 3
    }
}

