package codeforces.expert.rating1700;

import java.io.*;

// https://codeforces.com/problemset/problem/2227/F
public class P2227F {
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
            int n = nextInt(), max = 0;
            int nums[] = new int[n];
            for(int i = 0; i < n; i++) {
                nums[i] = nextInt();
                max = Math.max(nums[i], max);
            }
            println(solve(n, max, nums));
        }
        flush();
    }

    private static long solve(int n, int max, int nums[]) {
        long cubes[] = new long[max+1];   // number of cubes for height greater than i
        for(int num : nums)
            cubes[num]++;
        for(int h = max-1; h > 0; h--)      // h corresponds to height
            cubes[h] += cubes[h+1];
        long initialSum = 0l, finalSum = 0l;
        for(int i = 0; i < n; i++)
            initialSum += 1l * i * nums[i];
        for(int h = 1; h <= max; h++) {
            long cnt = cubes[h];
            finalSum += cnt * (2l * n - cnt - 1l) / 2l;     // Arithmetic Progression Sum
        }
        long ans = finalSum - initialSum;
        for(int i = 0; i < n; i++) {
            // gain of distance is amount final and initial sum change when a block is removed from ith column
            long gain = i - n + cubes[nums[i]];
            ans = Math.max(ans, finalSum - initialSum + gain);
        }
        return ans;
    }
}