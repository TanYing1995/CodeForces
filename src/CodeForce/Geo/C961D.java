package Geo;

import java.io.*;
import java.util.*;

public class C961D {
    public static void main(String[] args) {
        Kattio sc = new Kattio();
        int n = sc.nextInt();
        if(n <= 4){
            System.out.println("YES");
        }else{
            int[][] points = new int[n][2];
            for(int i=0; i < 2*n; i++){
                String s = sc.next();
                points[i/2][i%2] = Integer.parseInt(s.trim());
            }
            //枚举前三个点中的两个点，看剩下的点是否能在一条直线上
            boolean f = false;
            f |= check(points,0,1);
            //if(f) {System.out.println("YES");}
            f |= check(points,0,2);
            f |= check(points,1,2);
            if(f) System.out.println("YES");
            else System.out.println("NO");
        }
        sc.close();
    }

    static boolean check(int[][] p,int i, int j){
        int x0 = p[i][0],y0 = p[i][1];
        int x1 = p[j][0],y1 = p[j][1];
        int dy = y1-y0,dx = x1-x0;

        List<int[]> line = new ArrayList<>();//统计另外一条直线上的点数
        for(int k = 0; k < p.length; k++){
            if(k != i && k != j){
                int ndy = p[k][1]-y0,ndx = p[k][0]-x0;
                if((long)dy*ndx != (long)dx*ndy) {
                    if(line.size() < 2){
                        line.add(p[k]);
                    }
                    else{
                        int[] p1 = line.get(0),p2 = line.get(1);
                        int ddy = p2[1]-p1[1],ddx = p2[0]-p1[0];
                        int nddy = p[k][1]-p1[1],nddx = p[k][0]-p1[0];
                        if((long)nddy*ddx != (long)nddx*ddy)
                            return false;
                    }
                }
            }
        }
        return true;
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
