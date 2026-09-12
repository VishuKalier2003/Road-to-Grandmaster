package sheets.Preliminary.BinarySearch;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class P7 {
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
        int t = nextInt();
        while(t-- > 0) {
            int n = nextInt(), k = nextInt();
            int nums[] = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = nextInt();
            println(solve(k, nums));
        }
        flush();
    }

    private static int solve(int k, int nums[]) {
        Arrays.sort(nums);
        int max = 0, min = 0, ans = -1;
        for(int num : nums)
            max = Math.max(max, num);
        while(min <= max) {
            int mid = (min + max) >>> 1;
            if(possible(k, nums, mid)) {
                ans = mid;
                min = mid + 1;
            }
            else
                max = mid - 1;
        }
        return ans;
    }

    private static boolean possible(int k, int nums[], int mid) {
        int s = nums[0];
        k--;    // Place first cow, now we need to place k-1 more cows
        for(int num : nums) {
            if(num - s >= mid) {
                s = num;
                k--;
            }
            if(k <= 0)
                return true;
        }
        return k <= 0;
    }
}
