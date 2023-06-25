package BinarySearch;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;


/*
 * https://codeforces.com/problemset/problem/460/C
 * 
 * binarysearch
 */
public class C460 {
    static int[] nums;
    static int n,m,w,mi;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        n = io.nextInt();
        m = io.nextInt();
        w = io.nextInt();
        nums = new int[n];

        mi = (int)1e9;
        for(int i = 0; i < n; i++){ 
            nums[i] = io.nextInt();
            mi = Math.min(mi,nums[i]);
        }
        int mi = (int)1e9;
        for(int i = 0; i < n; i++){ 
            nums[i] = io.nextInt();
            mi = Math.min(mi,nums[i]);
        }
        if(w == n) {
            System.out.println(mi+m);
            io.close();
            return;
        }
        int l = mi,r = (int)1e9+100001;
        //二分答案
        while(l <= r){
            int mid = l+(r-l)/2;
            if(check(mid)){
                l = mid+1;
            }else{
                r = mid-1;
            }
            //System.out.println(l + "  "+ r);
        }
        System.out.println(r);
        //System.out.println(check(499));
        io.close();
    }

    //将最小数字变成k所需的操作次数
    static boolean check(int k){
        int[] diff = new int[nums.length];
        diff[0] = nums[0];
        for(int i = 1; i < diff.length; i++){
            diff[i] = nums[i]-nums[i-1];
            //System.out.print(diff[i] + " ");
        }
        //System.out.println();
        long v = 0;
        long cnt = 0;
        for(int i = 0; i < n; i++){
            v += diff[i];
            if(v < k){
                if(i+w < n) diff[i+w] -= (k-v);
                cnt = cnt +(k-v);
                v = k;//增加当前值到k
            }
        }
         return cnt <= m;
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
