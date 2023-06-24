package CodeForce.Dp;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

/*
 * https://codeforces.com/problemset/problem/1738/C
 * math
 */

public class C1783 {
    static final int N = 105;
    //dp[i][j]:还剩i个奇数，j个偶数的情况下，先手能否得到偶数和/奇数和
    static boolean[][] even = new boolean[N][N];
    static boolean[][] odd = new boolean[N][N];
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int t = io.nextInt();
        StringBuilder sb = new StringBuilder();
        init();
        while(t-- > 0){
            int n = io.nextInt();
            int[] nums = new int[n];
            int a = 0, b = 0;
            for(int i = 0; i < n; i++) {    
                int v = io.nextInt();
                if(v%2 == 0) a++;
                else b++;
            }
            String res = even[b][a] ? "Alice" : "Bob";
            sb.append(res).append("\n");
        }
        System.out.println(sb.toString());
        io.close();
    }

    static void init(){
        //确定初始状态
        for(int i = 1; i < N; i++){
            even[0][i] = true;
            odd[0][i] = false;
            int k = (i+1)/2;//防止i==1和2 的情况出错
            if(k%2 == 0){
                even[i][0] = true;
                odd[i][0] = false;
            }else{
                even[i][0] = false;
                odd[i][0] = true;
            }
        }

        for(int i = 1; i < N; i++){
            for(int j = 1; j < i; j++){
                if((i-j)%2 == 0){
                    //奇数一共有偶数个时，综总为偶数
                    //A先选， 第i手得偶数和获胜，此时考虑上一轮B取得奇数和获胜得情况
                    //此时A选最有一个数后必为奇数和，
                    even[i-j][j] = !(odd[i-j-1][j] && odd[i-j][j-1]);
                    //先手取得奇数和
                    odd[i-j][j] = !(even[i-j-1][j] && even[i-j][j-1]);
                }else{
                    //状态必胜是由对手的上一轮状态决定的
                    even[i-j][j] = !(even[i-j-1][j] && even[i-j][j-1]);
                    odd[i-j][j] = !(odd[i-j-1][j] && odd[i-j][j-1]);
                }
            }
        }
    }

    static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;
        // 标准 IO
        public Kattio() { this(System.in, System.out); }
        public Kattio(InputStream i, OutputStream o) {
            super(o);
            r = new BufferedReader(new InputStreamReader(i));
        }
        // 文件 IO
        public Kattio(String intput, String output) throws IOException {
            super(output);
            r = new BufferedReader(new FileReader(intput));
        }
        // 在没有其他输入时返回 null
        public String next() {
            try {
                while (st == null || !st.hasMoreTokens())
                    st = new StringTokenizer(r.readLine());
                return st.nextToken();
            } catch (Exception e) {}
            return null;
        }
        public int nextInt() { return Integer.parseInt(next()); }
        public double nextDouble() { return Double.parseDouble(next()); }
        public long nextLong() { return Long.parseLong(next()); }
    }
}
