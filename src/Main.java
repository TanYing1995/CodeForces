import java.util.Scanner;

class SegTreeNode
{
    int l;
    int r;
    int sum;
    int max;
    int lmax;
    int rmax;

    SegTreeNode() {}
    SegTreeNode(int l_, int r_, int sum_, int max_, int lmax_, int rmax_)
    {
        l = l_;
        r = r_;
        sum = sum_;
        max = max_;
        lmax = lmax_;
        rmax = rmax_;
    }
}

public class Main
{
    static int [] a;
    static SegTreeNode [] tree;


    static void push_up(int root, int ll, int rr)
    {
        tree[root].sum = tree[ll].sum + tree[rr].sum;
        tree[root].lmax = Math.max(tree[ll].lmax, tree[ll].sum + tree[rr].lmax);
        tree[root].rmax = Math.max(tree[rr].rmax, tree[ll].rmax + tree[rr].sum);
        tree[root].max = Math.max(Math.max(tree[ll].max, tree[rr].max), tree[ll].rmax + tree[rr].lmax);
    }

    static void build(int root, int l, int r)
    {
        tree[root] = new SegTreeNode();
        tree[root].l = l;
        tree[root].r = r;

        if (l == r)
        {
            tree[root].sum = a[l];
            tree[root].max = a[l];
            tree[root].lmax = a[l];
            tree[root].rmax = a[l];
            return ;
        }

        int ll = root << 1;
        int rr = root << 1 | 1;
        int mid = (l + r) >> 1;

        // push_down();
        build(ll, l, mid);
        build(rr, mid + 1, r);
        push_up(root, ll, rr);
    }

    static void update(int root, int idx, int val)
    {
        if (tree[root].l == tree[root].r)
        {
            tree[root].sum = val;
            tree[root].max = val;
            tree[root].lmax = val;
            tree[root].rmax = val;
            return ;
        }

        int ll = root << 1;
        int rr = root << 1 | 1;
        int mid = tree[root].l + tree[root].r >> 1;

        // push_down();
        if(idx <= mid)
        {
            update(ll, idx, val);
        }
        else
        {
            update(rr, idx, val);
        }
        push_up(root, ll, rr);
    }

    static SegTreeNode query(int root, int ql, int qr)
    {
        if (ql <= tree[root].l && tree[root].r <= qr)
        {
            return tree[root];
        }

        int ll = root << 1;
        int rr = root << 1 | 1;
        int mid = tree[root].l + tree[root].r >> 1;

        SegTreeNode L = new SegTreeNode();
        SegTreeNode R = new SegTreeNode();
        SegTreeNode res = new SegTreeNode();

        L.sum = L.max = L.lmax = L.rmax = -(1 << 30);
        R.sum = R.max = R.lmax = R.rmax = -(1 << 30);
        res.sum = 0;

        if (ql <= mid)
        {
            L = query(ll, ql, qr);
            res.sum += L.sum;
        }
        if (mid + 1 <= qr)
        {
            R = query(rr, ql, qr);
            res.sum += R.sum;
        }

        res.max = Math.max(Math.max(L.max, R.max), L.rmax + R.lmax);

        res.lmax = Math.max(L.lmax, L.sum + R.lmax);
        //----只有右子
        if (mid + 1 <= ql)
        {
            res.lmax = Math.max(res.lmax, R.lmax);
        }

        res.rmax = Math.max(R.rmax, L.rmax + R.sum);
        //----只有左子
        if (qr <= mid)
        {
            res.rmax = Math.max(res.rmax, L.rmax);
        }
        return res;
    }   

    public static void main(String [] args)
    {
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt();
        int m = scan.nextInt();

        a = new int[n + 1];
        for (int i = 1; i < n + 1; i ++)
        {
            a[i] = scan.nextInt();
        }

        tree = new SegTreeNode[4 * n];
        build(1, 1, n);


        for (int i = 0; i < m; i ++)
        {
            int op = scan.nextInt();
            if (op == 1)
            {
                int l = scan.nextInt();
                int r = scan.nextInt();
                if (l > r)
                {
                    int tmp = l;
                    l = r;
                    r = tmp;
                }
                int cur = query(1, l, r).max;
                System.out.println(cur);
            }
            else
            {
                int idx = scan.nextInt();
                int val = scan.nextInt();
                update(1, idx, val);
            }
        }
    }
}
