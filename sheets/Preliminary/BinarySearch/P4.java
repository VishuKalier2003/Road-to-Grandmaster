//package sheets.Preliminary.BinarySearch;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class P4 {
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
        int n = nextInt(), x = nextInt();
        int nums[] = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = nextInt();
        print(solve(n, x, nums));
        flush();
    }

    public static int solve(int n, int x, int nums[]) {
        Arrays.sort(nums);
        int l = 0, r = nums[n-1], min = 0;
        while(l <= r) {
            int mid = l + (r-l)/2;
            if(up(n, x, nums, mid)) {
                min = mid;      // always swap with mid
                l = mid + 1;
            }
            else
                r = mid - 1;
        }
        return min;
    }

    public static boolean up(int n, int x, int nums[], int h) {
        long sum = 0l;
        for(int i = 0; i < n; i++) {
            if(nums[i] > h)
                sum += (nums[i] - h);
        }
        return sum >= x;
    }
}
