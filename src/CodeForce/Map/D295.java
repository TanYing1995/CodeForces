package CodeForce.Map;

import java.io.*;
import java.util.*;

/***
* @Author: tanying
* @Date: 2023/9/11
* @Description: https://atcoder.jp/contests/abc295/tasks/abc295_d
* @Param: 
 * @param null
* @return: 
*/

public class D295 {
    public static void main(String[] args) {
        Kattio io = new Kattio();
        String str = io.next();
        int n = str.length();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++) nums[i] = (str.charAt(i)-'0');
        Map<Integer,Integer> cnt = new HashMap<>();
        cnt.put(0,1);
        long ans = 0L;
        int mask = 0;
        for (int i = 0; i < n; i++) {
            int offset = str.charAt(i)-'0';
            mask ^= (1 << offset);
            ans += cnt.getOrDefault(mask,0);
            cnt.put(mask,cnt.getOrDefault(mask,0)+1);
        }
        System.out.println(ans);
        io.flush();
    }

    static class Kattio extends PrintWriter {
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


