public class App {

    private int[] fac = {5, 10, 20, 100};
    private int[] ggt = {49, 56, 12345, 2345};

    public static void main(String[] args) {
        new App();
    }

    public App() {
        for (int num : fac) System.out.println(facIterative(num) + " | " + facRecursive(num));
        for (int i = 0; i < ggt.length; i+=2) System.out.println(ggTIterative(ggt[i], ggt[i+1])  + " | " + ggTRecursive(ggt[i], ggt[i+1]));
    }

    public long facIterative(int n) {
        long a = 1;
        for (int i = n; i >= 1; i--) {
            a *= i;
        }
        return a;
    }

    public long facRecursive(int n) {
        if (n == 1) return 1;
        else return n * facRecursive(n-1);
    }

    public int ggTIterative(int a, int b) {
        while (a != b) {
            if (a >= b) a -= b;
            else b -= a;
        }
        return a;
    }

    public int ggTRecursive(int a, int b) {
        if (a==b) return a;
        if (a >= b) return ggTRecursive(a - b, b);
        return ggTRecursive(b - a, a);
    }

    public int fibIterative(int n) {
        
    }

    public int fibRecursive(int n) {
        int m = 1;
    }

}