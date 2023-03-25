package LuoGu;

import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * DSU :并查集模板题：https://www.luogu.com.cn/problem/P3367
 */
public class P3367{
    static int[] fa;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        fa = new int[n+1];//代表者节点
        for(int i = 1; i <= n; i++) fa[i] = i;
        StringBuilder res = new StringBuilder();
        while(m-- > 0){
            int z = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            if(z == 1){
                union(x,y);
            }
            else{
                boolean f = (find(x) == find(y));
                if(f)
                    res.append("Y");
                else
                    res.append("N");
                if(m > 0) res.append("\n");
            }
        }
        System.out.println(res.toString());
    }

    static int find(int x){
        if(fa[x] != x){
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    static void union(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px != py){
            fa[px] = py;
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
