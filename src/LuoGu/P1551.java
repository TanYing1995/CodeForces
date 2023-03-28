package LuoGu;

import java.io.*;
import java.util.*;

/**
 * DSU ： 并查集  https://www.luogu.com.cn/problem/P1551
 */
public class P1551 {
    static int[] fa;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int p = sc.nextInt();
        fa = new int[n+1];
        for(int i = 1; i <= n; i++){
            fa[i] = i;
        }
        for(int i = 0; i < m; i++){
            int x = sc.nextInt();
            int y = sc.nextInt();
            union(x,y);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < p; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(find(a) == find(b)){
                sb.append("Yes").append("\n");
            }
            else{
                sb.append("No").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    static int find(int x){
        if(fa[x] != x){
            fa[x] = find(fa[x]);
        }
        return fa[x];
    }

    static void union(int x,int y){
        int a = find(x);
        int b = find(y);
        if(a != b){
            fa[b] = a;
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
