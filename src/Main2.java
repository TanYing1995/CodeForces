import java.util.Scanner;

public class Main2 {
    static int n;
    static int m;
    static Tree[] tree;
    static int[] nums;
    public static void main(String[] args) {
        Scanner io = new Scanner(System.in);
        n = io.nextInt();
        tree = new Tree[4*n+1];
        nums = new int[n];
        m = io.nextInt();
        for(int i = 0; i < n; i++) nums[i] = io.nextInt();
        for(int i = 0; i < tree.length; i++) tree[i] = new Tree();
        build(1,0,n-1);
        StringBuilder sb = new StringBuilder();
        while(m-- > 0){
            int l = io.nextInt();
            int r = io.nextInt();
            int c = query(1,l,r-1);
            sb.append(c).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void build(int root,int l,int r){
        tree[root].l = l;
        tree[root].r = r;

        if(l == r){
            tree[root].mi = nums[l];
            return;//到达叶子节点返回
        }

        int mid = l+(r-l)/2;
        int lc = root*2;
        int rc = lc+1;

        build(lc,l,mid);//构建左子树
        build(rc,mid+1,r);//构建右子树

        tree[root].mi = Math.min(tree[lc].mi,tree[rc].mi);
    }

    static int query(int root,int l,int r){
        //查询区间覆盖该节点区间
        if(l <= tree[root].l && tree[root].r <= r) return tree[root].mi;

        int mid = (tree[root].l+tree[root].r)/2;
        int lc = 2*root;
        int rc = lc+1;
        int ans = Integer.MAX_VALUE;
        if(l <= mid) ans = Math.min(ans,query(lc,l,r));
        if(r > mid) ans = Math.min(ans,query(rc,l,r));

        return ans;
    }

    static class Tree{
        int l;//左子区间
        int r;//右子区间

        int mi;//区间最小值
    }
}
