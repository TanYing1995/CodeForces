package Test;

public class t1 {
    public static void main(String[] args) {
        int n = 200000;
        long sum = 0;
        long t = 0;
        for(int i = 1; i <= n/2; i++){
            sum += (2*i);
            t += (2*i-1);
        }
        System.out.println(sum);
        System.out.println(t);
    }
}
