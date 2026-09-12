package sheets.Preliminary.BinarySearch;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class P6 {
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
        int n = nextInt(), t = nextInt();
        long nums[] = new long[n];
        long h = 0l;
        for(int i = 0; i < n; i++) {
            nums[i] = nextInt();
            h = Math.max(h, nums[i]);
        }
        // set the lower and upper boundaries wisely
        print(solve(t, nums, 1, h*t));
        flush();
    }

    public static long solve(int k, long nums[], long l, long r) {
        long ans = r;
        while(l <= r) {
            long mid = l + (r-l)/2;
            if(possible(k, nums, mid)) {
                ans = mid;
                r = mid - 1;
            } else
                l = mid + 1;
        }
        return ans;
    }

    public static boolean possible(int k, long nums[], long mid) {
        long c = 0;
        for(long num : nums) {
            // count the product made by a machine in given time mid
            k -= (mid / num);       // always better to subtract than add (prevents overflow)
            // If the required number reached then return true
            if(k <= 0)
                return true;
        }
        return false;
    }
}
