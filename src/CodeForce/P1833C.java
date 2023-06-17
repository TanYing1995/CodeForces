package CodeForce;

import java.util.*;
import java.io.*;
import java.util.StringTokenizer;

public class P1833C {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        //这是一个输入输出模板
        int t = io.nextInt();
        StringBuilder sb = new StringBuilder();
        while(t-- > 0){
            int n = io.nextInt();
            int[] nums = new int[n];
            int mi = 1000000000;
            for(int i = 0; i < n; i++){
                nums[i] = io.nextInt();
                mi = Math.min(mi, nums[i]);
            }
            boolean f = true;
            
            Arrays.sort(nums);
            boolean odd = nums[0]%2 == 1 ? true : false;
            boolean even = nums[0]%2 == 0 ? true : false;
            for(int i = 1; i < n; i++){
                if((nums[i]-nums[0])%2 != 0){
                    if((!odd) && even) {
                        f = false;
                        break;
                    }//先出现偶数，没有出现奇数，直接跳出
                    odd = true;
                    even = true;
                }
            }
            if(f) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }
        System.out.println(sb.toString());
        io.close();
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
