package sheets.Preliminary.BinarySearch;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class P3 {
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

    public static long solve(int n, int x, int nums[]) {
        long p[] = new long[n + 1];
        Map<Long, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++)
            p[i+1] = p[i] + nums[i];
        long ans = 0l;
        mp.put(0l, 1);
        for(int i = 0; i < n; i++) {
            long req = p[i+1] - x;
            if(mp.containsKey(req))
                ans += mp.get(req);
            mp.put(p[i+1], mp.getOrDefault(p[i+1], 0) + 1);
        }
        return ans;
    }
}
