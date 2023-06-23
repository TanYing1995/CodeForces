package Math;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
* https://codeforces.com/problemset/problem/1714/E
* */

public class CF1714E {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        int T = io.nextInt();
        StringBuilder ans = new StringBuilder();
        while(T-- > 0){
            int n = io.nextInt();
            int[] nums = new int[n];
            boolean flag = false;
            for(int i = 0; i < n; i++) {
                nums[i] = io.nextInt();
                if(nums[i]%5 == 0){
                    flag = true;
                    nums[i] = next(nums[i]);
                }
            }
            if(flag){
                Arrays.sort(nums);
                if(nums[0] == nums[n-1]) ans.append("Yes").append("\n");
                else ans.append("No").append("\n");
            }
            else{
                boolean f2 = false,f12 = false;
                for(int i = 0; i < n; i++){
                    int x = nums[i];
                    while(x%10 != 2){
                        x = next(x);
                    }
                    if(x%20 == 2) f2 = true;
                    else{
                        f12 = true;
                    }
                }
                if(f2 && f12)
                    ans.append("No").append("\n");
                else
                    ans.append("Yes").append("\n");
            }
        }
        System.out.println(ans.toString());
        io.close();
    }

    static int next(int x){
        return x + x%10;
    }

    public static class Kattio extends PrintWriter {
        private BufferedReader r;
        private StringTokenizer st;

        // 标准 IO
        public Kattio() {
            this(System.in, System.out);
        }

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
            } catch (Exception e) {
            }
            return null;
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }
}
