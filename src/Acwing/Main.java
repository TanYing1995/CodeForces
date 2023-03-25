package Acwing;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    static Tree[] tree;
    static int n;
    static int m;
    static int[] nums;
    public static void main(String[] args) {
        Kattio io = new Kattio();
        n = io.nextInt();
        m = io.nextInt();
        nums = new int[n+1];
        tree = new Tree[4*n+5];//开辟4n空间创建线段树
        for(int i = 1; i <= n; i++) nums[i] = io.nextInt();
        for(int i = 0; i < tree.length; i++) tree[i] = new Tree();
        build(1,n,1);

        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            int type = io.nextInt();
            if(type == 1){//查询最大子段和
                int l = io.nextInt();
                int r = io.nextInt();
                l = Math.min(l,r);
                r = Math.max(l,r);
                if(l == r) {
                    sb.append(nums[l]);
                    if(m != 1) sb.append("\n");
                }
                else{
                    Tree ans = query(l,r,1);
                    sb.append(ans.ms);
                    if(m != 1) sb.append("\n");
                }

            }
            else{//单点更新
                int x = io.nextInt();
                int y = io.nextInt();
                update(x,y,1);
            }
        }
        System.out.println(sb.toString());
        io.close();
    }

    //查询区间[l,r]的最值
    static Tree query(int l,int r,int k){
        //查询区间覆盖该节点的区间
        if(l <= tree[k].l && tree[k].r <= r){
            return tree[k];//返回最大子段和
        }

        int mid = (tree[k].l+tree[k].r)/2;//划分点
        int lc = 2*k;
        int rc = 2*k+1;

        Tree res = new Tree();
        Tree L = new Tree();
        Tree R = new Tree();

        L.sum = 0; L.ms = L.ls = L.rs = Integer.MIN_VALUE/2;
        R.sum = 0; R.ms = R.ls = R.rs = Integer.MIN_VALUE/2;
        res.sum = 0;

        if (l <= mid)
        {
            L = query(l,r,lc);
            res.sum += L.sum;
        }
        if (mid + 1 <= r)
        {
            R = query(l, r, rc);
            res.sum += R.sum;
        }

        res.ms = Math.max(Math.max(L.ms, R.ms), L.rs + R.ls);

        res.ls = Math.max(L.ls, L.sum + R.ls);
        //----只有右子
        if (mid + 1 <= l)
        {
            res.ls = Math.max(res.ls, R.ls);
        }

        res.rs = Math.max(R.rs, L.rs + R.sum);
        //----只有左子
        if (r <= mid)
        {
            res.rs = Math.max(res.rs, L.rs);
        }
        return res;
    }


    //将nums[x]处的值更新为y
    static void update(int x, int y,int k){
        //找到索引为x的叶子节点
        if(tree[k].l==tree[k].r && tree[k].l == x){
            tree[k].sum = y;
            tree[k].ls = y;
            tree[k].rs = y;
            tree[k].ms = y;
            return;
        }

        //递归过程更新区间相关信息
        int mid = tree[k].l+(tree[k].r-tree[k].l)/2;
        int lc = 2*k;
        int rc = 2*k+1;
        if(x <= mid){
            update(x,y,lc);
        }
        else{
            update(x,y,rc);
        }

        //更新子树后再处理相关信息
        push_up(k,lc,rc);
    }



    static void build(int l, int r,int k){
        tree[k].l = l;
        tree[k].r = r;
        if(l == r){
            tree[k].ms = nums[l];
            tree[k].ls = nums[l];
            tree[k].rs = nums[l];
            tree[k].sum = nums[l];
            System.out.println("第"+l+"个值为： "+tree[k].sum);
            return;
        }
        //向下递归
        int mid = (r+l)/2;//划分点
        int lc = 2*k;
        int rc = 2*k+1;

        //递归构建子树
        build(l,mid,lc);
        build(mid+1,r,rc);

        //维护相关信息
        push_up(k,lc,rc);
    }

    static void push_up(int k,int lc,int rc){
        tree[k].sum = tree[lc].sum+tree[rc].sum;
        tree[k].ls = max(tree[lc].ls,tree[lc].sum+tree[rc].ls);
        tree[k].rs = max(tree[rc].rs,tree[rc].sum+tree[lc].rs);
        tree[k].ms = max(max(tree[lc].ms,tree[rc].ms),tree[lc].rs+tree[rc].ls);
    }

    static int max(int x, int y){
        return Math.max(x,y);
    }

    static class Tree{
        int l;//左子区间
        int r;//右子区间

        int ls;//左端点开始的最大子段和
        int rs;//右端点开始的最大子段和
        int ms;//最大子段和
        int sum;//区间和
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
