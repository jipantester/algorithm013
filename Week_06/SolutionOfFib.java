package Week_06;

public class SolutionOfFib{
    //递归
    public int fib(final int n) {
        if(n <= 1) return n;
        return fib(n-1)+fib(n-2);
    }
    //记忆化递归
    public int fib2(int n) {
        int con = 1000000007;
        if(n <= 1) return n;
        int[] a = new int[n+1];
        a[0] = 0;
        a[1] = 1;
        for(int i = 2; i < n+1; i++){
            a[i] = (a[i-1] % con) + (a[i-2] % con); 
        }
        return a[n] % con;
    }
    //动态规划
    public int fib3(int n){
        int a = 0, b = 1, sum ;
        for (int i = 0; i < n; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}