//package sheets.Preliminary.BinarySearch;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P5 {
    private static final DataInputStream IN = new DataInputStream(new BufferedInputStream(System.in, 1 << 16));
    private static final StringBuilder OUT = new StringBuilder();
    private static final PrintWriter PW = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

    public static int nextInt() throws IOException {
        int c, x = 0;
        do {c = IN.read();} while(c < ' ');
        boolean neg = c == '-';
        if(neg) c = IN.read();
        do {x = x * 10 + (c - '0');} while((c = IN.read()) >= '0');
        return neg ? -x : x;
    }

    public static long nextLong() throws IOException {
        int c;
        long x = 0l;
        do{c = IN.read();} while(c < ' ');
        boolean neg = c == '-';
        if(neg) c = IN.read();
        do {
            x = x * 10 + (c - '0');
        } while ((c = IN.read()) >= '0');
        return neg ? -x : x;
    }

    public static String next() throws IOException {
        int c;
        do {c = IN.read();} while(c < ' ');
        StringBuilder sb = new StringBuilder();
        do {
            sb.append((char)c);
        } while((c = IN.read()) > ' ');
        return sb.toString();
    }

    public static void print(Object o) {OUT.append(o);}
    public static void println(Object o) {OUT.append(o).append('\n');}
    public static void flush() {PW.print(OUT); PW.flush();}

    public static void main(String args[]) throws IOException {
        int n = nextInt(), k = nextInt();
        int nums[] = new int[n];
        long l = 0l, h = 0l;
        for(int i = 0; i < n; i++) {
            nums[i] = nextInt();
            l = Math.max(l, nums[i]);
            h += nums[i];
        }
        print(solve(n, k, nums, l, h));
        flush();
    }

    public static long solve(int n, int k, int nums[], long l, long h) {
        long ans = 0l;
        while(l <= h) {
            long mid = l + (h-l)/2;
            if(possible(n, k, nums, mid)) {
                ans = mid;
                h = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    public static boolean possible(int n, int k, int nums[], long mid) {
        long sub[] = new long[k];
        int i = 0;
        for(int num : nums) {
            if(sub[i] + num <= mid)
                sub[i] += num;
            else {
                i++;
                if(i == k)
                    return false;
                sub[i] += num;
            }
        }
        return true;
    }
}
