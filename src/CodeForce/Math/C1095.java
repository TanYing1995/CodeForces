package CodeForce.Math;

import java.io.*;
import java.util.*;

/*
*  https://codeforces.com/problemset/problem/1095/C
*  math
 */
public class C1095 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int n = io.nextInt();
        int k = io.nextInt();
        if(k > n || k < Integer.bitCount(n)){
            System.out.println("NO");
        } else{
            int[] nums = new int[k];//假设能够分割成k个数
            Arrays.fill(nums,1);
            n -= k;
            for(int i = 0; i < k && n > 0; i++){
                if(Integer.bitCount(n+1) == 1){
                    nums[i] = n+1;
                    n = 0;
                }
                int tar = n == 1 ? 2 : get(n);
                if(n >= tar-1){
                    n -= (tar-1);
                    nums[i] = tar;
                }
            }
            StringBuilder sb = new StringBuilder();
            String res = n == 0 ? "YES" : "NO";
            sb.append(res).append("\n");
            if(n == 0){
                for(int i = 0; i < k; i++){
                    sb.append(nums[i]).append(" ");
                }
            }
            System.out.println(sb.toString());
        }
        io.close();
    }

    //返回小于tar的最大二进制数
    static int get(int tar){
        int l = 0,r = 30;
        while(l <= r){
            int mid = (l+r)/2;
            int v = (1 << mid);
            if(v <= tar){
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return (1 << r);
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
